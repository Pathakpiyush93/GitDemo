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



public class EndToEndGroceryApp {

	public static void main(String[] args) {
//		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] expectedItems = {"Tomato", "Mushroom", "Banana", "Mango"};
//		All the items on the page
		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
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
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		driver.findElement(By.xpath("//div/following-sibling::button")).click();
		
		
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='wrapperTwo']/div/select")));
		WebElement element=  driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select"));
		Select select = new Select(element);
		select.selectByValue("India");
		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		
		
		
			
		
	}

}
