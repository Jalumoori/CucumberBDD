package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webelementUtilities.WebElementUtilities;

public class RegisterPage {
	
	WebDriver driver;
	WebElementUtilities eleUtils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eleUtils = new WebElementUtilities(driver);

	}
	
	@FindBy(linkText="Register")
	private WebElement Register;
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirm;
	
	@FindBy(name="agree")
	private WebElement privacy_policy;
	
	@FindBy(xpath="//input[contains(@class,'btn-primary')]")
	private WebElement continue_button;
	
	
	
	public void clickOnRegister()
	{
		eleUtils.clickElement(Register, 15);
	}
	
	public void clickOnPrivacyPolicy()
	{
		eleUtils.clickElement(privacy_policy, 15);
	}
	
	public void clickOnContinue()
	{
		eleUtils.clickElement(continue_button, 15);
	}
	
	public void enterFirstName(String str)
	{
		eleUtils.enterText(firstname, str ,15);
	}
	public void enterLastName(String str)
	{
		eleUtils.enterText(lastname, str ,15);
	}
	public void enterTelephone(String str)
	{
		eleUtils.enterText(telephone, str ,15);
	}
	public void enterPassword(String str)
	{
		eleUtils.enterText(password, str ,15);
	}
	public void enterPasswordConfirmation(String str)
	{
		eleUtils.enterText(confirm, str ,15);
	}	
	public void enterEmail(String str)
	{
		eleUtils.enterText(email, str ,15);
	}
	

}
