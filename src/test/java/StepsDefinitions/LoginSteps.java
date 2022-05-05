package StepsDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import Pages.LoginPageElements;
import TestBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {

	@Given("User navigated to the Application")
	public void user_navigated_to_the_application() {
		openBrowserAndLaunchApplication("chrome");
	}

	@When("user valid username and valid password")
	public void user_valid_username_and_valid_password() {
		LoginPageElements lpe = new LoginPageElements();
		lpe.usernameField.sendKeys("Admin");
		lpe.passwordField.sendKeys("admin123");
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		LoginPageElements lpe = new LoginPageElements();
		lpe.loginBtn.click();
	}

	@Then("user is successfully logged in")
	public void user_is_successfully_logged_in() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle);
		closeBrowser();
	}

	@When("user valid {string} and valid {string}")
	public void user_valid_and_valid(String username, String password) {
		LoginPageElements lpe = new LoginPageElements();
		lpe.usernameField.sendKeys(username);
		lpe.passwordField.sendKeys(password);
	}

	@When("user enters different {string} and {string}")
	public void user_enters_different_and(String username, String password) {
		LoginPageElements lpe = new LoginPageElements();
		lpe.usernameField.sendKeys(username);
		lpe.passwordField.sendKeys(password);
	}

	@Then("user verify the {string} for all the combinations")
	public void user_verify_the_for_all_the_combinations(String expectedErrormessage) {
		LoginPageElements lpe = new LoginPageElements();
		String Actualerrormessage = lpe.errorMessage.getText();
		Assert.assertEquals(Actualerrormessage, expectedErrormessage, "both error message are not equal");
	}

}
