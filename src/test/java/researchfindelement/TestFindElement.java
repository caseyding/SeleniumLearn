package researchfindelement;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * TestFindElement
 *
 * @author Dinglulu
 * @function
 * @createDate 2015/9/6
 * @updateBy Dinglulu
 * @updateDate 2015/9/6
 */
@Log4j
public class TestFindElement {
    WebDriver driver = null;

    @BeforeTest
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @Test
    public void testDt() throws Exception{
        driver.get("https://www.bestpay.com.cn/");
        WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

        /**
         * <li class="ui-headernav-li">
             <a href="/moneybills/index" class="indexheadernav-a index-moneybills"  target="_blank"><span class="a-new01"></span></a>
           </li>

         * <a class="header-tab-a" href="/appcenter/lifepay/water">水电煤缴费</a>
         */
        // <a class="header-tab-a" href="/appcenter/lifepay/water">水电煤缴费</a>
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String myjs="document.getElementsByClassName('header-tab-a')[0].click()";
        js.executeScript(myjs);


//        WebElement personalserviceByXpath = driver.findElement(By.xpath("//a[@href='/personalservice']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(personalserviceByXpath).perform();
//        Thread.sleep(2000);
//        WebElement lifepaywaterByXpath = driver.findElement(By.xpath("//a[@href='/appcenter/lifepay/water']"));
//        lifepaywaterByXpath.click();



//        WebElement phoneNoByXpath1 = driver.findElement(By.xpath("//input[@id='phoneNo']"));
//        WebElement phoneNoByXpath2 = driver.findElement(By.xpath("//input[@name='productNo']"));
//        WebElement phoneNoByXpath3 = driver.findElement(By.xpath("//input[@class='ui-txtinput01']"));
//        WebElement loginByXpath1 = driver.findElement(By.xpath("//a[contains(@href, 'javascript')]"));
//        WebElement loginByXpath2 = driver.findElement(By.xpath("//a[starts-with(@class,'ui-button')]"));
//        loginByXpath1.click();
//        List<WebElement> buttons = driver.findElements(By.tagName("button"));
//        List<WebElement> inputs = driver.findElements(By.tagName("input"));
//        List<WebElement> aLinks = driver.findElements(By.tagName("a"));
//        System.out.println(buttons.size());  //打印出button的个数

    }

    @Test
    public void testFindElement() throws IOException,Exception {
        driver.get("https://www.bestpay.com.cn/");

        // <input name="productNo" id="phoneNo"  type="text" maxlength="11" class="ui-txtinput01" autocomplete="off" value="请输入手机号"/>
        //1.通过id查找是最有效、最方便的方法
        WebElement phoneNoById = driver.findElement(By.id("phoneNo"));
        //2.通过name查找，跟id类似的方法
        WebElement phoneNoByName = driver.findElement(By.name("productNo"));
        //3.通过class name查找，对某些具有相同类的元素一网打尽的好方法，如果整个页面只有一个元素使用了该class也可以使用。
        WebElement phoneNoByClassname = driver.findElement(By.className("ui-txtinput01"));
        phoneNoByClassname.sendKeys("13900770088");

        WebElement phoneNoByXpath1 = driver.findElement(By.xpath("//input[@id='phoneNo']"));
        WebElement phoneNoByXpath2 = driver.findElement(By.xpath("//input[@name='productNo']"));
        WebElement phoneNoByXpath3 = driver.findElement(By.xpath("//input[@class='ui-txtinput01']"));
        WebElement loginByXpath1 = driver.findElement(By.xpath("//a[contains(@href, 'javascript')]"));
        WebElement loginByXpath2 = driver.findElement(By.xpath("//a[starts-with(@class,'ui-button')]"));
        WebElement moneybillsByCssSelector = driver.findElement(By.cssSelector("a.indexheadernav-a.index-moneybills"));
        WebElement moneybillsByXPath = driver.findElement(By.xpath("//a[@href='/moneybills/index']"));
        log.info(moneybillsByXPath.getLocation().getX());
        log.info(moneybillsByXPath.getLocation().getY());
        log.info(moneybillsByCssSelector.getLocation().toString());
        loginByXpath2.click();

        /**
         * <li class="login-btn01">
         <a class="ui-button ui-button-morange ui-loginbutton" id="telLoginButtn" href="javascript:void(0);">登&nbsp;&nbsp;录</a>
         </li>
         */
        WebElement loginById = driver.findElement(By.id("telLoginButtn"));
        WebElement loginByCssSelector = driver.findElement(By.cssSelector("a.ui-button.ui-button-morange.ui-loginbutton"));
        WebElement loginByLinkedText = driver.findElement(By.linkText("登  录"));
        WebElement loginByPartialLinkText = driver.findElement(By.partialLinkText("登"));

    }

    @Test
    public void testHoover() throws Exception{
        driver.get("https://www.bestpay.com.cn/");
        Thread.sleep(1000);
        WebElement personalserviceByXpath = driver.findElement(By.xpath("//a[@href='/personalservice']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String myjs="var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        js.executeScript(myjs, personalserviceByXpath);
        Thread.sleep(1000);
//        WebElement lifepaywaterByXpath = driver.findElement(By.xpath("//a[@href='/appcenter/lifepay/water']"));
//        lifepaywaterByXpath.click();
    }

    @AfterTest
    public void closeDriver(){
        if(driver != null){
            driver.quit();
        }
    }

    public static WebElement waitForPresenceOfElement(WebDriver driver, WebElement element){
        return new WebDriverWait(driver, 120).until(presenceOfElement(element));
    }

    public static ExpectedCondition<WebElement> presenceOfElement(final WebElement element) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                if(element != null){
                    if(element.isDisplayed()){
                        return element;
                    }
                }
                return null;
            }
        };
    }
}
