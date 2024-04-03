package UdemyClass.pageObjectModel;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UdemyClass.abstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProduct;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutPage;
	
	public void cartProducts() {
		goToCartPage();
	}
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProduct.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckOutPage() {
		checkoutPage.click();
		CheckOutPage checkOutPage=  new CheckOutPage(driver);
		return checkOutPage;
	}
	
	
	

}
