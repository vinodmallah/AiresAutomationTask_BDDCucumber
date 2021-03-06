package com.intsof.stepdefinitions;

import org.junit.Assert;

import com.intsof.factory.DriverFactory;
import com.intsof.pages.ForgotPasswordPage;
import com.intsof.pages.HomePage;
import com.intsof.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private ForgotPasswordPage forgotPassowrdPage = new ForgotPasswordPage(DriverFactory.getDriver());
	private String actualTitle;

	@Given("user is on Aires application login page")
	public void user_is_on_aires_application_login_page() {

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		actualTitle = loginPage.getPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}

	@When("user enters UserName {string}")
	public void user_enters_user_name(String validUserName) {
		loginPage.enterUsername(validUserName);
	}

	@When("user clicks on Next button")
	public void user_clicks_on_next_button() {
		loginPage.clickNext();
	}

	@When("user enters Password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLogin();
	}

	@Then("user should be navigated to AriesMobilityX Home Page")
	public void user_should_be_navigated_to_aries_mobility_x_home_page() {
		
		Assert.assertTrue(homePage.isUserNavigatedtoHomePage());

		/*
		 * String actualProfileName = homePage.getProfileName().toLowerCase().trim();
		 * String actualUserArray[] = validLoggedInUserName.split("[.@]"); String
		 * expectedProfileName = (actualUserArray[0] + " " + actualUserArray[1]).trim();
		 * Assert.assertEquals(expectedProfileName, actualProfileName);
		 */
	}

	@When("user logout from the application")
	public void user_logout_from_the_application() {
		homePage.clickLogoutButton();
	}

	@Then("user should be navigated to Login page having Username text field")
	public void user_should_be_navigated_to_login_page_having_username_text_field() {
		Assert.assertTrue("User not navigated to Sign In Page having Username Field",
				loginPage.validateUsernameTextFieldPresent());
	}

	@Then("validation message {string} should be displayed above Sign in section")
	public void validation_message_should_be_displayed_above_sign_in_section(
			String expectedLoginFailedValidationMessage) {
		Assert.assertTrue("Login Failed Validation Message Not Displayed",
				loginPage.isLoginFailedValidationMessageDisplayed());
		String actualLoginFailedValidationMessage = loginPage.getLoginFailedValidationMessage();
		Assert.assertEquals(expectedLoginFailedValidationMessage, actualLoginFailedValidationMessage);
	}

	@Then("user should NOT be navigated to Password page having Password text Field")
	public void user_should_not_be_navigated_to_password_page_having_password_text_field() {
		Assert.assertFalse(loginPage.validatePasswordTextFieldPresent());
	}

	@Then("validation message {string} should be displayed inside UserName text field")
	public void validation_message_should_be_displayed_inside_user_name_text_field(
			String expectedBlankValidationMessage) {
		Assert.assertTrue("Validaion message not displayed when user enter blank field in UserName TextField",
				loginPage.isBlankValidationMessageDisplayed());
		String actualBlankValidationMessage = loginPage.getBlankValidationMessage();
		Assert.assertEquals(expectedBlankValidationMessage, actualBlankValidationMessage);

	}

	@Then("user should be NOT navigated to Home page or sign in page having Username text Field")
	public void user_should_be_not_navigated_to_home_page_or_sign_in_page_having_username_text_field() {
		Assert.assertFalse(loginPage.validateUsernameTextFieldPresent());
		Assert.assertFalse(homePage.isUserNavigatedtoHomePage());
	}

	@Then("validation message {string} should be displayed inside Password text field")
	public void validation_message_should_be_displayed_inside_password_text_field(
			String expectedBlankValidationMessage) {

		Assert.assertTrue("Validaion message not displayed when user enter blank field in Password TextField",
				loginPage.isBlankValidationMessageDisplayed());
		String actualBlankValidationMessage = loginPage.getBlankValidationMessage();
		Assert.assertEquals(expectedBlankValidationMessage, actualBlankValidationMessage);
	}

	@When("user clicks on Forgot password? link")
	public void user_clicks_on_forgot_password_link() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
		loginPage.clickOnForgotPasswordLink();
	}

	@Then("user should be navigated to UserProfileIntermediate Page having security question\\(s)")
	public void user_should_be_navigated_to_user_profile_intermediate_page_having_security_question_s() {
		Assert.assertTrue(forgotPassowrdPage.IsSecurityQuestionTextDisplayed());
	}

	@Then("pop up box having message {string} should be displayed")
	public void pop_up_box_having_message_should_be_displayed(String string) {

	}

	@When("user clicks on Back To Login button")
	public void user_clicks_on_back_to_login_button() {

	}

	@Then("user should be navigated to sign in page having Username text Field")
	public void user_should_be_navigated_to_sign_in_page_having_username_text_field() {

	}

}
