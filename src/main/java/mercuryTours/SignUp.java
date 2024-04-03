package mercuryTours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UdemyClass.abstractComponent.AbstractComponent;

public class SignUp extends AbstractComponent{
	
	WebDriver driver;
	public SignUp(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='register.php']")
	WebElement register;
	
	@FindBy(name = "lastName")
	WebElement lastName;
	
	@FindBy(name = "firstName")
	WebElement firstName;
	
	@FindBy(name = "phone")
	WebElement phone;
	
	@FindBy(name = "userName")
	WebElement userName;
	
	@FindBy(name = "address1")
	WebElement address1;
	
	@FindBy(name = "city")
	WebElement city;
	
	@FindBy(name = "state")
	WebElement state;
	
	@FindBy(name = "postalCode")
	WebElement postalCode;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name = "submit")
	WebElement submit;
	
	@FindBy(name = "country")
	WebElement country;
	
	
	public FlightBooking signUp(String firstN, String lastN, String phoneNo, String emailId, 
			String add1, String cityNa, String stateNa,String postal, String countryName, 
			String userNa, String pass, String confpass) {
		register.click();
		firstName.sendKeys(firstN);
		lastName.sendKeys(lastN);
		phone.sendKeys(phoneNo);
		email.sendKeys(emailId);
		address1.sendKeys(add1);
		city.sendKeys(cityNa);
		state.sendKeys(stateNa);
		postalCode.sendKeys(postal);
		Select select = new Select(country);
		select.selectByValue(countryName);
		
		userName.sendKeys(userNa);
		password.sendKeys(pass);
		confirmPassword.sendKeys(confpass);
		submit.click();
		
		FlightBooking flightBooking = new FlightBooking(driver);
		return flightBooking;
 		
	}
	public void goTo() {
		driver.get("https://demo.guru99.com/test/newtours/");
	}
	
	

}
