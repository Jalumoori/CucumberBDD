package hooks;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	public static Scenario currentScenario;
	Logger log;
	@Before
	public void setUpBrowser(Scenario sc)	
	{
		currentScenario = sc;
		log = LogManager.getLogger(Hooks.class.getName());
		DriverFactory.initializeBrowser("chrome");		
		driver =DriverFactory.getDriver();
		log.debug(sc.getName()+ " -- execution started");
		log.debug("Browser initiated");
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@After
	public void tearDown(Scenario sc)
	{
		if(!sc.isFailed())
		{
		    log.info(currentScenario.getName()+ " passed");		

		}
		else
		{
		    log.error(currentScenario.getName() + " failed");		

		}
		driver.quit();
		log.debug("Browser closed");
		log.debug(sc.getName()+ " -- execution completed");


	}
	
	
}
