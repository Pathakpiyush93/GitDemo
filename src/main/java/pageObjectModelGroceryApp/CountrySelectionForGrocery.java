package pageObjectModelGroceryApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import UdemyClass.abstractComponent.AbstractComponent;

public class CountrySelectionForGrocery extends AbstractComponent{
	
	WebDriver driver;
	public CountrySelectionForGrocery(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='wrapperTwo']/div/select")
	WebElement element;
	
	@FindBy(className = "chkAgree")
	WebElement checkbox;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement proceed;
	
	By newPage = By.xpath("//div[@class='wrapperTwo']/div/select");
	
	public void countrySelection(String country) {
		
		elementToVisible(newPage);
		Select select = new Select(element);
		select.selectByValue(country);
		checkbox.click();
		proceed.click();
		
	}

}

//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='wrapperTwo']/div/select")));
//WebElement element=  driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select"));
//Select select = new Select(element);
//select.selectByValue("India");
//driver.findElement(By.className("chkAgree")).click();
//driver.findElement(By.xpath("//button[text()='Proceed']")).click();
