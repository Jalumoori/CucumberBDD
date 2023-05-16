package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	@Before
	public void setUpBrowser()
	{
		DriverFactory.initializeBrowser("chrome");		
		driver =DriverFactory.getDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@After
	public void tearDown()
	{
		
		driver.quit();
	}
	
	
}
