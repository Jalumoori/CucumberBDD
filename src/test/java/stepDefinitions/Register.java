package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.UtilityClass;
import driverfactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	WebDriver driver;
	
	@Given("I am on the AUT Homepage")
	public void i_am_on_the_aut_homepage() {
	    driver = DriverFactory.getDriver();
	    driver.get("https://tutorialsninja.com/demo/");
	    
	}

	@When("I navigate to Register page")
	public void i_navigate_to_register_page() {
	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.linkText("Register")).click();
//	    driver.findElement(By.linkText("Login")).click();
	    
	}

	@When("I enter all the valid details")
	public void i_enter_all_the_valid_details(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class,String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(data.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(data.get("lastName"));
		driver.findElement(By.id("input-telephone")).sendKeys(data.get("phone"));
		driver.findElement(By.id("input-password")).sendKeys(data.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(data.get("Password_Confirm"));
	}
	
	@When("I enter valid {string}")
	public void i_enter_valid(String email_id) {
		email_id = UtilityClass.getUniqueEmail();
		driver.findElement(By.id("input-email")).sendKeys(email_id);

	}
	
	@When("I enter duplicate {string}")
	public void i_enter_duplicate(String email) {
		System.out.println(email);
		driver.findElement(By.id("input-email")).sendKeys(email);

	}

	@When("click on privacy policy {string}")
	public void click_on_privacy_policy(String string) {
		driver.findElement(By.name("agree")).click();

	}

	@When("I click on continue")
	public void i_click_on_continue() {
		driver.findElement(By.xpath("//input[contains(@class,'btn-primary')]")).click();
	}

	@Then("I should see account created success message")
	public void i_should_see_accouunts_created_success_message() {		
		String actualMsg=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		String expectedMsg="Your Account Has Been Created!";
		assertTrue(actualMsg.equals(expectedMsg));	    
	}
	
	@Then("I should see email already registered message")
	public void i_should_see_email_already_registered_message() {
		String actualMsg=driver.findElement(By.xpath("//div[contains(text(),'Warning')]")).getText();
		String expectedMsg="Warning: E-Mail Address is already registered!";
		assertTrue(actualMsg.equals(expectedMsg));	
	}
	
	@Then("I should see warning message")
	public void i_should_see_warning_message() {
		String actualMsg=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText().trim();
		String expectedMsg="First Name must be between 1 and 32 characters!";
		assertTrue(actualMsg.equals(expectedMsg));
	}
	
	


}
