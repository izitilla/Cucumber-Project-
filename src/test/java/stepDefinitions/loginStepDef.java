package stepDefinitions;

import org.junit.Assert;

import Utilities.BaseClass;
import Utilities.commonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginStepDef extends commonMethods{
// day 82 33.51
	
	
	@Given("the user has navigated to the login page")
	public void the_user_has_navigated_to_the_login_page() {
	    
	    
	    splashPage.clickLoginLogoutOrRegister("login");
	    loginPage.assertLoginFeatures();
	   
	   
	}

	@When("the user enters the correct username and password")
	public void the_user_enters_the_correct_username_and_password() {
	  commonMethods.sendKey(loginPage.inputEmainBox, BaseClass.getProperty("userName"));
	  commonMethods.sendKey(loginPage.inputPasswordBox, BaseClass.getProperty("password"));
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		commonMethods.click(loginPage.loginButton);
	}

	@Then("the user is redirected to the homepage")
	public void the_user_is_redirected_to_the_homepage() {
	   Assert.assertEquals( BaseClass.getProperty("titleOfTheHomePage"),BaseClass.getDriver());
	}

	@Then("a welcome message is displayed")
	public void a_welcome_message_is_displayed() {
	   System.out.println("This test case going to fail");
	}
	
	@When("the user enters an incorrect username or password")
	public void the_user_enters_an_incorrect_username_or_password() {
		commonMethods.sendKey(loginPage.inputEmainBox, BaseClass.getProperty("incorrectUserName"));
		commonMethods.sendKey(loginPage.inputPasswordBox, BaseClass.getProperty("incorrectPassword"));
	
	}

	@Then("an error message is displayed")
	public void an_error_message_is_displayed() {
	
		Assert.assertTrue(loginPage.errorMessage.isDisplayed());
	}

	@When("the user clicks on the {string}")
	public void the_user_clicks_on_the(String string) {
	    commonMethods.click(loginPage.forgotPasswordLink);
	}

	@Then("the user is redirected to the password recovery page")
	public void the_user_is_redirected_to_the_password_recovery_page() {
	    Assert.assertEquals(BaseClass.getProperty("titleOfTheForgotYourPasswordPage"), BaseClass.getDriver().getTitle());
	}
}
