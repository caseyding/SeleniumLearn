package learningselenium.testCases;

import learningselenium.pages.MainPage;
import learningselenium.pages.MessagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


public class testMessageWithMainFunction {
	public static void main(String... args) {	
		WebDriver driver = new FirefoxDriver();
		
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		MessagePage messagePage = PageFactory.initElements(driver, MessagePage.class);

		mainPage.openMainPage("http://www.cnblogs.com");
		mainPage.login("seleniumpageobject", "pageobject123");
		messagePage.sendMessage("Hamona", "testSendingMessage1", "text messages 1");
		messagePage.sendMessage("Hamona", "testSendingMessage2", "text messages 2");
		mainPage.logout();
		
		mainPage.openMainPage("http://www.cnblogs.com");
		mainPage.login("seleniumpageobject", "pageobject123");
		messagePage.sendMessage("Hamona", "testSendingMessage3", "text messages 3");
		messagePage.deleteAllMessage();
		mainPage.logout();
		
		driver.quit();
	}
}
