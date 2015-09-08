package learningselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MessagePage {
	WebDriver driver;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "����Ϣ")
	WebElement messageBox;
	@FindBy(how = How.LINK_TEXT, linkText = "׫д�¶���Ϣ")
	WebElement newMessage;
	@FindBy(how = How.LINK_TEXT, linkText = "�ռ���")
	WebElement receivedMessage;

	public MessagePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterMessageBox() {
		messageBox.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void sendMessage(String toUser, String titleContent,
			String textContent) {
		enterMessageBox();
		newMessage.click();
		SendMessagePage2 sendMessagePage = PageFactory.initElements(driver, SendMessagePage2.class);
		sendMessagePage.sendNewMessage(toUser, titleContent, textContent);
	}

	public void deleteAllMessage() {
		enterMessageBox();
		receivedMessage.click();
		ReceivedMessagePage2 receivedMessagePage = PageFactory.initElements(driver, ReceivedMessagePage2.class);
		receivedMessagePage.deleteAllMessages();
	}
}
