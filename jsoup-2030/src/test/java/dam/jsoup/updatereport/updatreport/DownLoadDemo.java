package dam.jsoup.updatereport.updatreport;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DownLoadDemo {
    @Test
    void go () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        //创建Chrome driver的实例
        ChromeOptions chromeoptions=new ChromeOptions ();

//        chromeoptions.addArguments("--headless");//无头浏览
//        chromeoptions.addArguments("blink-settings=imagesEnabled=false");//禁用图片
        WebDriver driver = new ChromeDriver(chromeoptions);
        List<String> list = new ArrayList<>();
        list.add("604");
        for (String s : list) {
            String url = "https://www.nexusmods.com/stardewvalley/mods/" + s;
            driver.navigate().to(url);
            Thread.sleep(10000);
            WebElement element = driver.findElement(By.xpath("/html/body/div[2]/section/div/div[2]/div[2]/div/ul/li[2]"));
            Thread.sleep(10000);
            element.click();
            WebElement element1 = driver.findElement(By.xpath("//*[@id=\"file-container-main-files\"]/div[2]/dl/dd/div[2]/ul/li[3]/a"));
            Thread.sleep(10000);
            element.click();
            System.out.println("end");
        }

    }
}
