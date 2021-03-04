package dam.jsoup.updatereport.updatreport;

import dam.jsoup.updatereport.updatreport.util.mId.ExecCmd;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExceCmdDemo {
    @Test
    void go() {
        ExecCmd execCmd = new ExecCmd("wmic csproduct get uuid");
        execCmd.run();
        System.out.println(execCmd.getComment().get(1).replaceAll("[ \t\n]*", ""));
    }
}
