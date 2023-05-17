package webelementUtilities;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtilities {
	
	WebDriver driver;
	WebDriverWait wait ;
	
	public WebElementUtilities(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickElement(WebElement ele ,int secs)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(secs) );
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();		
	}
	
	public void enterText(WebElement ele ,String str,int secs)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(secs) );
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		ele.clear();
		ele.sendKeys(str);
	}

}
