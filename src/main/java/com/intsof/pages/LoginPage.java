package com.intsof.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.intsof.util.ElementUtil;

public class LoginPage {

	private WebDriver driver;

	// Object Repositories
	private By userName = By.id("username::content");
	private By nextButton = By.id("nextButton");
	private By password = By.id("password::content");
	private By loginButton = By.id("loginButton");
	private By forgotPasswordLink = By.id("dpl2s::text");
	private By validationMessage = By.xpath("//div[@id='growls']//div[@class='growl-xsmall-message']");
	private By blankValidationMessage = By.className("af_message_detail");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkExist() {
		ElementUtil.waitForVisibilityOfElement(password);
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void clickOnForgotPasswordLink() {
		driver.findElement(forgotPasswordLink).click();
	}

	public void enterUsername(String name) {
		driver.findElement(userName).sendKeys(name);
	}

	public void enterPassword(String pwd) {
		ElementUtil.waitForVisibilityOfElement(password);
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickNext() {
		driver.findElement(nextButton).click();
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public boolean validateUsernameTextFieldPresent() {

		try {
			ElementUtil.waitForVisibilityOfElement(userName);
			boolean isUserNameFieldPresent = driver.findElement(userName).isDisplayed();
			return isUserNameFieldPresent;
		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}

	}

	public boolean isLoginFailedValidationMessageDisplayed() {
		ElementUtil.waitForVisibilityOfElement(validationMessage);
		return driver.findElement(validationMessage).isDisplayed();
	}

	public String getLoginFailedValidationMessage() {
		return driver.findElement(validationMessage).getText();
	}

	public boolean validatePasswordTextFieldPresent() {
		try {
			boolean isPasswordFieldsPresent = driver.findElement(password).isDisplayed();
			return isPasswordFieldsPresent;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isBlankValidationMessageDisplayed() {
		return driver.findElement(blankValidationMessage).isDisplayed();
	}

	public String getBlankValidationMessage() {
		return driver.findElement(blankValidationMessage).getText();
	}

}
