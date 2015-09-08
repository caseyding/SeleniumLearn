package learningselenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReceivedMessagePage2 {
	WebDriver driver;
	
	@FindBy(how = How.ID, id = "chkSelAll")
	WebElement checkBoxSelectAll;
	@FindBy(how = How.ID, id = "btnBatDel")
	WebElement deleteAllMessagesButton;
	
	public ReceivedMessagePage2(WebDriver driver) {
		this.driver = driver;
	}
	
	public void deleteAllMessages() {
		//check box
		if(!checkBoxSelectAll.isSelected()) {
			checkBoxSelectAll.click();
		}
		
		//delete all received messages
		deleteAllMessagesButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert confirmDeletePrompt = driver.switchTo().alert();
		confirmDeletePrompt.accept();
	}
}
