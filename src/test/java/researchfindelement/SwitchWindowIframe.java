package researchfindelement;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * SwitchWindowIframe
 *
 * @author Dinglulu
 * @function
 * @createDate 2015/9/7
 * @updateBy Dinglulu
 * @updateDate 2015/9/7
 */
@Log4j
public class SwitchWindowIframe {
    WebDriver driver = null;

    @BeforeTest
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @Test
    public void testSwithInnerFrame() throws Exception{
        String file_path =  "file:///C:/Users/Administrator/Desktop/html/frame.html";
        driver.get(file_path);

        //先找到ifrome1（id = f1）
        driver.switchTo().frame("f1");
        //再找到其下面的ifrome2(id =f2)
        driver.switchTo().frame("f2");
        //下面就可以正常的操作元素了
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
    }

    @Test
    public void testSwithTwoFrame() throws Exception{
        String file_path =  "file:///C:/Users/Administrator/Desktop/html/twoFrames.html";
        driver.get(file_path);

        //先找到到ifrome1（id = f1）
        driver.switchTo().frame("f1");
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        //再找到其下面的ifrome2(id =f2)
        driver.switchTo().defaultContent();
        driver.switchTo().frame("f2");
        //下面就可以正常的操作元素了
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
    }

    @Test
    public void testSwitchWindow(){

    }

    //    @AfterTest
    public void closeDriver(){
        if(driver != null){
            driver.close();
        }
    }
}
