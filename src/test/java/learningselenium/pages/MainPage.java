package learningselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {
	WebDriver driver;
	public MainPage(WebDriver pagedriver) {
		this.driver = pagedriver;
		PageFactory.initElements(driver,this);
	}


	@FindBy(how = How.LINK_TEXT, linkText = "��¼")
	WebElement loginLink;
	@FindBy(how = How.LINK_TEXT, linkText = "�˳�")
	WebElement logoutLink;
	

	public void openMainPage(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
	
	public void login(String userName, String passWord) {
		loginLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbUserName")));
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(userName, passWord);
	}
	
	public void logout() {
		logoutLink.click();
		
		LogoutPage logoutPage = PageFactory.initElements(driver, LogoutPage.class);
		logoutPage.logout();
	}


}
