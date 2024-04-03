package pageObjectModelGroceryApp;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UdemyClass.abstractComponent.AbstractComponent;

public class GrocerySelectionForGrocery extends AbstractComponent{
	WebDriver driver;
	public GrocerySelectionForGrocery(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[@class='product-name']")
	List<WebElement> productList;
	
	@FindBy(xpath = "//img[@alt='Cart']")
	WebElement cart;
	
	@FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
	WebElement checkoutButton;
	
	
	public VerifyTheProductForGrocery selectGroceries() {
		String[] expectedItems = {"Tomato", "Mushroom", "Banana", "Mango"};
		int j=0;

		List<String> expectedItemsList = Arrays.asList(expectedItems);
		for(int i=0; i<productList.size(); i++) {
			
			String[] name = productList.get(i).getText().split("-");productList.get(i).getText().split("-");
			String formatedItems = name[0].trim();
			
			if(expectedItemsList.contains(formatedItems)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
			if(j==expectedItems.length) {
				break;
			}
		}
		
		cart.click();
		checkoutButton.click();
		VerifyTheProductForGrocery verifyTheProductForGrocery= new VerifyTheProductForGrocery(driver);
		return verifyTheProductForGrocery;

	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	}
	

}
