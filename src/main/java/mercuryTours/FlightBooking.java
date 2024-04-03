package mercuryTours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UdemyClass.abstractComponent.AbstractComponent;

public class FlightBooking extends AbstractComponent{
	
	WebDriver driver;
	public FlightBooking(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Flights")
	WebElement flightBooking;

	@FindBy(xpath = "//input[@value='oneway']")
	WebElement onewayTrip;
	
	@FindBy(name = "passCount")
	WebElement passengers;
	
	@FindBy(name = "fromPort")
	WebElement departure;
	
	@FindBy(name = "fromMonth")
	WebElement departureMonth;
	
	@FindBy(name = "fromDay")
	WebElement departurDay;
	
	@FindBy(name = "toPort")
	WebElement arrival;
	
	@FindBy(name = "toMonth")
	WebElement returnMonth;
	
	@FindBy(name = "toDay")
	WebElement returnDay;
	
	@FindBy(name = "servClass")
	WebElement passengerClass;
	
	@FindBy(name = "airline")
	WebElement airline;
	
	@FindBy(name = "findFlights")
	WebElement buttonContinue;
	
	By element = By.name("findFlights");
	By element1 = By.linkText(" sign-in ");
	
	public void goToFlightBooking() {

		flightBooking.click();
	}
	
	public void bookFlight(String value, String departurCountryName, String monthVal, String day,
			String arrCountry, String arrMonth, String arrDay, String airNa) {

		onewayTrip.click();
		Select select = new Select(passengers);
		select.selectByValue(value);
//		elementToVisibleWebElement(passengers);
		Select select1 = new Select(departure);
		select1.selectByValue(departurCountryName);
		Select select2 = new Select(departureMonth);
		select2.selectByValue(monthVal);
		Select select3 = new Select(departurDay);
		select3.selectByValue(day);
		Select select4 = new Select(arrival);
		select4.selectByValue(arrCountry);
		Select select5 = new Select(returnMonth);
		select5.selectByValue(arrMonth);
		Select select6 = new Select(returnDay);
		select6.selectByValue(arrDay);
		passengerClass.click();
		Select select7 = new Select(airline);
		select7.selectByVisibleText(airNa);
		buttonContinue.click();
	}
	
	
	
	

}
