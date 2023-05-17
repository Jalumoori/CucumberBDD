package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	static WebDriver driver;
	
	public static void initializeBrowser(String browsername) {
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}		
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	
	}
	

}
