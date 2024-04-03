package stepDefination;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import UdemyClass.pageObjectModel.CartPage;
import UdemyClass.pageObjectModel.CheckOutPage;
import UdemyClass.pageObjectModel.ConfirmationPage;
import UdemyClass.pageObjectModel.LandingPage;
import UdemyClass.pageObjectModel.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponents.BaseClass;

public class StepDefinationImp extends BaseClass {
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on ecommerce page")
	public void i_Landed_On_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")

	public void logged_In_With_Username_And_Password(String username, String password) {
		productCatalogue = landingPage.loginApplication(username, password);
	}

	@When("^I add product (.+) from cart$")

	public void i_Add_Product_From_Cart(String productName) {
		productCatalogue.elementToVisible(By.cssSelector(".mb-3"));
		productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}

	@When("^Checkout (.+) and submit the order$")

	public void checkout_and_submit_the_order(String productName) throws InterruptedException {
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOutPage();
		checkOutPage.selectCountry("india");
		confirmationPage = checkOutPage.submitOrder();
	}

//	 Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page
	@Then("{string} message is displayed on the confirmation page")
	public void message_displayed_on_confirmation_page(String message) {
		confirmationPage.confirmOrder();
		String confirmationMessage = confirmationPage.confirmOrder();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(message));
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
	}
}
