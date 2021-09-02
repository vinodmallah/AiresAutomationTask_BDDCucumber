package com.intsof.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.intsof.util.ElementUtil;

public class ForgotPasswordPage {

	private WebDriver driver;

	// Object Repositories
	private By securityQuestionsText = By.className("RXText");

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean IsSecurityQuestionTextDisplayed() {

		try {

			ElementUtil.waitForVisibilityOfElement(securityQuestionsText);
			return driver.findElement(securityQuestionsText).isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

}
