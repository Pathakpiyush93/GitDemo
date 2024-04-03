package UdemyClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import UdemyClass.pageObjectModel.CartPage;
import UdemyClass.pageObjectModel.CheckOutPage;
import UdemyClass.pageObjectModel.ConfirmationPage;
import UdemyClass.pageObjectModel.ProductCatalogue;
import testComponents.BaseClass;

public class SubmitOrderTest extends BaseClass{

	@Test(dataProvider = "getData")
	
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
//		String desireProduct ="IPHONE 13 PRO";
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();	
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		ProductCatalogue productCatalogue =landingPage.loginApplication(input.get("email"), input.get("password"));
//		driver.get("https://rahulshettyacademy.com/client");
//		driver.findElement(By.id("userEmail")).sendKeys("pathakpiyush93@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Piyush123@");
//		driver.findElement(By.id("login")).click();
//		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.elementToVisible(By.cssSelector(".mb-3"));
		productCatalogue.getProductList();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		productCatalogue.addProductToCart(input.get("productName"));
//		WebElement prod = products.stream().filter(s->s.findElement
//				(By.cssSelector("b")).getText().equals(desireProduct)).findFirst().orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		CartPage cartPage = productCatalogue.goToCartPage();		
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//		CartPage cartPage = new CartPage(driver);
		
		Boolean match = cartPage.verifyProductDisplay(input.get("productName"));
//		List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));
//		Boolean match = cartProduct.stream().anyMatch(s->s.getText().equalsIgnoreCase(desireProduct));
		Assert.assertTrue(match);
		
		CheckOutPage checkOutPage = cartPage.goToCheckOutPage();	
//		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		checkOutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-item")));
//		a.click(driver.findElement(By.cssSelector(".ta-item:last-of-type"))).build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Place Order')]")));
//		a.sendKeys(Keys.PAGE_DOWN).build().perform();
//		driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
		
		confirmationPage.confirmOrder();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String confirmationMessage = confirmationPage.confirmOrder();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"pathakpiyush93@gmail.com", "Piyush123@", "IPHONE 13 PRO"},{"shetty@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}};
//	}
	
	
	
//	By using Hash Map
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "pathakpiyush93@gmail.com");
//		map.put("password", "Piyush123@");
//		map.put("productName", "IPHONE 13 PRO");

//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("productName", "ADIDAS ORIGINAL");
//		return new Object[][] {{map},{map1}};
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\dataForJson\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
