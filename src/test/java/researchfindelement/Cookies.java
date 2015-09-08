package researchfindelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

/**
 * Cookies
 *
 * @author Dinglulu
 * @function
 * @createDate 2015/9/7
 * @updateBy Dinglulu
 * @updateDate 2015/9/7
 */
public class Cookies {
    WebDriver driver = null;

    @BeforeTest
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void addCookies() {
            driver.get("http://www.zhihu.com/#signin");

            WebElement user = driver.findElement(By.xpath("//input[@name='email']"));
            user.clear();
            user.sendKeys("seleniumcookies@126.com");
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.clear();
            password.sendKeys("cookies123");

            WebElement submit = driver.findElement(By
                    .xpath("//button[@class='sign-button']"));
            submit.submit();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            File file = new File("broswer.data");
            try {
                // delete file if exists
                file.delete();
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Cookie ck : driver.manage().getCookies()) {
                    bw.write(ck.getName() + ";" + ck.getValue() + ";"
                            + ck.getDomain() + ";" + ck.getPath() + ";"
                            + ck.getExpiry() + ";" + ck.isSecure());
                    bw.newLine();
                }
                bw.flush();
                bw.close();
                fw.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("cookie write to file");
            }
        }
    }