package UdemyClass.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import UdemyClass.abstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector(".toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	public List<WebElement> getProductList() {
		elementToVisible(productBy);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		
		
		WebElement prod = getProductList().stream().filter(s->s.findElement
				(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		elementToVisible(toastMessage);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		elementToInvisible(spinner);
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
	}
	
	
	

}
