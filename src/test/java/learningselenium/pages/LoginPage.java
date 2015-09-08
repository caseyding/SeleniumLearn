package learningselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver pagedriver) {
		this.driver = pagedriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, id = "tbUserName")
	WebElement username;
	@FindBy(how = How.ID, id = "tbPassword")
	WebElement password;
	@FindBy(how = How.ID, id = "btnLogin")
	WebElement loginbutton;

	public void login(String userName, String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		loginbutton.click();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
}
