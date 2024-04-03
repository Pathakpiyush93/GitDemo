package mercuryTours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MercuryTours {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SignUp signUp = new SignUp(driver);
		signUp.goTo();
		FlightBooking flightBooking = signUp.signUp("Sam", "Bahadur", "9876543210", 
				"abcd@gmail.com", "Karve Nagar", "Pune", "Maharashtra", 
				"411052", "INDIA", "SamBahadur93", "Sam@123", "Sam@123");
		flightBooking.goToFlightBooking();
		flightBooking.bookFlight("4", "Paris", "11", "11", "New York", "12", "12", 
				"Blue Skies Airlines");
	}
}
