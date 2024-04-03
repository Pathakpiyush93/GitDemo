package UdemyClass;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import UdemyClass.pageObjectModel.CartPage;
import UdemyClass.pageObjectModel.ProductCatalogue;
import testComponents.BaseClass;
import testComponents.Retry;

public class ErrorValidationTest extends BaseClass{

	@Test(retryAnalyzer = Retry.class)
	
	public void loginErrorValidation() throws IOException {

		landingPage.loginApplication("pathakpiyush9@gmail.com", "Piyush123@");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	

	@Test
	
	public void productErrorValidation() throws IOException {
		String desireProduct ="IPHONE 13 PRO";
		ProductCatalogue productCatalogue =landingPage.loginApplication("pathakpiyush93@gmail.com", "Piyush123@");
		productCatalogue.elementToVisible(By.cssSelector(".mb-3"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(desireProduct);
		CartPage cartPage = productCatalogue.goToCartPage();		
		Boolean match = cartPage.verifyProductDisplay("IPHONE 13 PRO");
		Assert.assertTrue(match);
	}
}
//Incorrect email or password.