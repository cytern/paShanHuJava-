package dam.jsoup.updatereport.updatreport.util;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumUtils {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        executeWithAnnotationMehtod();

    }

    static void executeWithAnnotationMehtod() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 通过反射执行测试类中的有@Test修饰的方法
        Class<?> c = SeleniumUtils.class;
        Object test = c.newInstance();
        Method[] ms = c.getDeclaredMethods();

        for (Method m : ms) {
            // System.out.println(m);

            // 判定方法上有没有Test注解
            if (m.isAnnotationPresent(MockTest.class)) {
                try{
                    m.invoke(test);
                }
                catch(Exception e){
                    e.printStackTrace(System.out); //这样则可以顺序输出
                }
            }
        }
    }

    /**
     * 用火狐进行测试,打开百度
     */
    //  @MockTest
    void startWithFireFox(){
        // 这里要修改你的Firefox的安装路径
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver driver =  new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   //设置默认超时时间
        driver.get("https://www.baidu.com");
        // 获取 网页的 title
        System.out.println("The testing page title is: " + driver.getTitle());

        //  driver.findElement(By.id("search-input")).sendKeys("selenium");
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        //   driver.quit();
    }


    /**
     * 用谷歌进行测试打开百度，搜索Selenium ,  kw为文本关键字文本框按钮，su为提交按钮
     */
    //   @MockTest
    void startWithChorme(){
        // 这里要修改你的谷歌的安装路径
        System.setProperty("webdriver.chrome.driver", "D:\\idea\\workspace\\okHttp\\src\\main\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //   driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);   //设置默认超时时间
        driver.get("https://www.baidu.com");
        // 获取 网页的 title
        System.out.println("The testing page title is: " + driver.getTitle());
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        driver.quit();
    }

    @MockTest(desc = "文件上传")
    public void testUntitled() throws Exception {
        File file = new File("");

        String filePath = file.getAbsolutePath() + File.separator + "src.main.java".replace(".", File.separator) + File.separator + this.getClass().getName().replace(".", File.separator);
        String uploadFileName = filePath + ".java";
        String targetFile = filePath + ".html";
        file = new File(targetFile);
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "<title>测试</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>上传</h1>\n" +
                "    <form method=\"post\" action=\"/TomcatTest/UploadServlet\"\n" +
                "        enctype=\"multipart/form-data\">\n" +
                "        文件路径: <input type=\"file\" name=\"uploadFile\" /> <br />\n" +
                "        <br /> <input type=\"submit\" value=\"上传\" />\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";

        if (file.exists()) {
            file.delete();

        }

        file.createNewFile();
        FileOutputStream out = new FileOutputStream(targetFile);
        out.write(html.getBytes("utf-8"));
        out.flush();
        out.close();

        System.setProperty("webdriver.chrome.driver", "D:\\idea\\workspace\\okHttp\\src\\main\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(targetFile);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.findElement(By.name("uploadFile")).sendKeys(uploadFileName);
        // 获取文件上传文半框位置，传入文件上传地址。
        Thread.sleep(1000);

        JavascriptExecutor js=(JavascriptExecutor) driver;
        //3秒后执行
        js.executeAsyncScript("setTimeout(\"alert('2秒后准备关闭')\",2000)");
        Thread.sleep(2000);
        // driver.close();
        // driver.quit();

    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
@interface MockTest {
    String desc() default "";
}