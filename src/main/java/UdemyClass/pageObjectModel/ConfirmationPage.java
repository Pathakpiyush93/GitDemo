package UdemyClass.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UdemyClass.abstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	By hero = By.cssSelector(".hero-primary");
	
	public String confirmOrder() {
		elementToVisible(hero);
//		String confirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		return confirmationMessage.getText();

	}
	

}
