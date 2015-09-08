package learningselenium.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {
	private WebDriver driver;
	

	public void main() {
		driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize(); 
		driver.findElement(By.id("kw")).sendKeys("HoneyWellaaaa");
		driver.findElement(By.id("su")).click();
		//driver.quit();
	}
	

	//@Test
	public void loginCSDN() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://passport.csdn.net/account/login");

		driver.findElement(By.id("username")).sendKeys("lu.19890106@163.com");
		driver.findElement(By.id("password")).sendKeys("336lulu336");
		driver.findElement(By.xpath("//input[@value='µÇ Â¼']")).click();
		driver.quit();

	}
//	@Test
//	public void regularQuery(){
////        System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
////        DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
////        desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
////        WebDriver driver = new InternetExplorerDriver(desiredCapabilities);
////
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability("chrome.binary", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
//		capabilities.setCapability("chrome.switches", Arrays.asList("--disable-extensions"));
//		WebDriver driver = new ChromeDriver(capabilities);
//
////        WebDriver driver = new FirefoxDriver();
//
//		driver.get("http://116.228.55.189:7090/PCPF_INF/dp/SVC_100005_test.jsp");
//		driver.findElement(By.name("AGENTCODE")).clear();
//		driver.findElement(By.name("AGENTCODE")).sendKeys("000041700000");
//		driver.findElement(By.name("CARDNO")).clear();
//		driver.findElement(By.name("CARDNO")).sendKeys("160008427124");
//		driver.findElement(By.name("CARDPWD")).clear();
//		driver.findElement(By.name("CARDPWD")).sendKeys("735250");
//		driver.findElement(By.name("submit")).click();
//	}

}
