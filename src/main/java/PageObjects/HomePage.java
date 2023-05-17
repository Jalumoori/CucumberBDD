package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webelementUtilities.WebElementUtilities;

public class HomePage {
	WebDriver driver;
	WebElementUtilities eleUtilts;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
/*	This ensures that the elements of the HomePage class are initialized using the provided driver object.*/
		PageFactory.initElements(driver, this);	
		eleUtilts = new WebElementUtilities(driver);
	}
	
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountDropdown;
	
	public void clickonMyAccount() {	
		System.out.println(MyAccountDropdown);
		eleUtilts.clickElement(MyAccountDropdown, 15);
		
	}
	
	
}
