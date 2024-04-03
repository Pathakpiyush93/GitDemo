package groceryApplication;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModelGroceryApp.CountrySelectionForGrocery;
import pageObjectModelGroceryApp.GrocerySelectionForGrocery;
import pageObjectModelGroceryApp.VerifyTheProductForGrocery;



public class GroceryApp {

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		GrocerySelectionForGrocery selectGroceries = new GrocerySelectionForGrocery(driver);
		selectGroceries.goTo();
		VerifyTheProductForGrocery verifyTheProductForGrocery=  selectGroceries.selectGroceries();
			
		verifyTheProductForGrocery.discountCoupon("rahulshettyacademy");
		CountrySelectionForGrocery countrySelectionForGrocery = verifyTheProductForGrocery.placeOrder();
		
		countrySelectionForGrocery.countrySelection("India");
		
		
		
			
		
	}

}
