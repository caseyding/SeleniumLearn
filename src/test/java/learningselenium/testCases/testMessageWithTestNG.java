package learningselenium.testCases;

import learningselenium.pages.MainPage;
import learningselenium.pages.MessagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class testMessageWithTestNG {
	private WebDriver driver = new FirefoxDriver();
	MainPage mainPage = new MainPage(driver);
	MessagePage messagePage = new MessagePage(driver);
	
	@BeforeClass(alwaysRun = true)
	public void maxmizeBrowser() {
		driver.manage().window().maximize();
	}
	
	@Test(groups="test1")
	public void SendMessage() {	
		mainPage.openMainPage("http://www.cnblogs.com");
		mainPage.login("hamona", "336336");
		messagePage.sendMessage("seleniumpageobject", "testSendingMessage1", "text messages 1");
		messagePage.sendMessage("seleniumpageobject", "testSendingMessage2", "text messages 2");
		mainPage.logout();
	}
	
	@Test
	public void DelMessage(){
		mainPage.openMainPage("http://www.cnblogs.com");
		mainPage.login("hamona", "336336");
		messagePage.sendMessage("seleniumpageobject", "testSendingMessage3", "text messages 3");
		messagePage.deleteAllMessage();
		mainPage.logout();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
