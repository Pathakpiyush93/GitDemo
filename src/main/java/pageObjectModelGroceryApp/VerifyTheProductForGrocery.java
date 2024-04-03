package pageObjectModelGroceryApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UdemyClass.abstractComponent.AbstractComponent;

public class VerifyTheProductForGrocery extends AbstractComponent{
	
	WebDriver driver;
	public VerifyTheProductForGrocery(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@class='promoCode']")
	WebElement couponCode;
	
	@FindBy(xpath = "//button[@class='promoBtn']")
	WebElement verifyCoupon;
	
	@FindBy(xpath = "//div/following-sibling::button")
	WebElement orderPlace;
	
	By verfyingCoupon = By.xpath("//input[@class='promoCode']");
	By verificationMessage = By.xpath("//span[@class='promoInfo']");
	
	public void discountCoupon(String coupon) {
		
		elementToVisible(verfyingCoupon);
		couponCode.sendKeys(coupon);
		verifyCoupon.click();
		elementToVisible(verificationMessage);

	}
	
	public CountrySelectionForGrocery placeOrder() {
		orderPlace.click();
		CountrySelectionForGrocery countrySelectionForGrocery = new CountrySelectionForGrocery(driver);
		return countrySelectionForGrocery;
	}

}
