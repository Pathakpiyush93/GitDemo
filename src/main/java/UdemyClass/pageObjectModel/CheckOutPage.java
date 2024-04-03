package UdemyClass.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UdemyClass.abstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:last-of-type")
	WebElement selectCountry;
	
	@FindBy(xpath = "//a[contains(text(),'Place Order')]")
	WebElement placeOrder;
	
	By countryDisplay= By.cssSelector(".ta-item");
	By countrySelect =By.xpath("//a[contains(text(),'Place Order')]");
	public void selectCountry(String countryName) {
		elementToVisible(countrySelect);
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		elementToVisible(countryDisplay);
		a.click(selectCountry).build().perform();
		elementToVisible(countrySelect);
		a.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	public ConfirmationPage submitOrder() throws InterruptedException {
		elementToVisibleWebElement(country);
		placeOrder.click();
		Thread.sleep(2000);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
}
