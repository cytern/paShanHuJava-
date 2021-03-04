package dam.jsoup.updatereport.updatreport;

import dam.jsoup.updatereport.updatreport.dao.SettingMapper;
import dam.jsoup.updatereport.updatreport.pojo.Setting;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author dam
 * @version 1.0
 * @date 2020/12/22 17:04
 */
@SpringBootTest
public class TestDemo {
     @Autowired
     private SettingMapper settingMapper;
    @Test
   void   test () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", getDir());
        //创建Chrome driver的实例
        WebDriver driver = new ChromeDriver();
        // 最大化浏览器
        driver.manage().window().maximize();

        //打开百度首页
        driver.navigate().to ("https://hsm.sspu.edu.cn/selfreport/Default.aspx");
        //driver.get("http://www.baidu.com");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("20171130316");
        password.sendKeys("zhenlong112066");
        backStatus(driver);
//        WebElement loginButton = driver.findElement(By.className("submit_button"));
//        loginButton.click();
        WebElement toPost = driver.findElement(By.xpath("//*[@id=\"form1\"]/div[6]/ul/li[1]/a/div"));
        toPost.click();
        //form表单操作
        WebElement icon = driver.findElement(By.id("p1_ChengNuo-inputEl-icon"));
        icon.click();
        WebElement num1 = driver.findElement(By.xpath("//*[@id=\"fineui_2\"]/div[2]/div/label"));
        num1.click();
        Thread.sleep(1000);
        WebElement num2 = driver.findElement(By.id("p1_TiWen-inputEl"));
        num2.sendKeys("36.5");
        WebElement num3 = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[2]/div[2]/div/div/a[1]"));
        num3.click();
        Thread.sleep(1000);
        WebElement num4 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/a[1]"));
        num4.click();
        Thread.sleep(1000);
        WebElement num5 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/table/tr/td[2]/div"));
        System.out.println(num5.getText()+ "=--------text");
//        //通过name属性找到搜索输入框
//        WebElement search_input	= driver.findElement(By.name("wd"));
//
//        //在搜索输入框中输入搜索关键字"耗子尾汁"
//        search_input.sendKeys("耗子尾汁");
//
//        //递交搜索请求
//        search_input.submit();
//
//        //等待5秒后自动关闭浏览器
//        Thread.sleep(5000);
//
//        //验证搜索结果页面的标题，若匹配则关闭浏览器
//        Assert.assertEquals("耗子尾汁_百度搜索",driver.getTitle());
//
//        //关闭浏览器窗口
//        driver.quit();

    }
    private String getDir() {
         Setting setting = settingMapper.selectByPrimaryKey(1);
         return setting.getSettingValue();
    }

    private String backStatus(WebDriver webDriver) {
         WebElement webElement =webDriver.findElement(By.className("submit_button"));
         webElement.click();
         return "success";
    }
}
