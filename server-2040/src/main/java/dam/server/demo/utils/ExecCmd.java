package dam.server.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExecCmd implements Runnable {
    private String command;
    private List<String> comment;

    public List<String> getComment() {
        return comment;
    }

    public ExecCmd(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        Process process;
        int exitVal = 0;
        try {
            process = Runtime.getRuntime().exec(command);
            // Runtime.exec() 创建的子进程公用父进程的流, 不同平台上, 父进程的 stream buffer 可能被打满导致子进程阻塞, 从而永远无法返回.
            // 针对这种情况, 我们只需要将子进程的 stream 重定向出来即可.
            CmdStreamThread info = new CmdStreamThread(process.getInputStream(), "INFO");
            info.start();

            exitVal = process.waitFor();
            // 返回执行后的内容
            comment = info.getList_data();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (exitVal != 0) {
            throw new RuntimeException("cmd任务执行失败");
        }
    }

    class CmdStreamThread extends Thread {
        private InputStream is;
        private String printType;
        private List<String> list_data;

        CmdStreamThread(InputStream is, String printType) {
            this.is = is;
            this.printType = printType;
        }

        List<String> getList_data() {
            return list_data;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                List<String> data_ = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(printType + ">" + line);
                    if(!"".equals(line)) {
                        data_.add(line);
                    }
                }
                list_data = data_;
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}