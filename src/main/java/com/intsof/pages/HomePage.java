package com.intsof.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.intsof.util.ElementUtil;

public class HomePage {

	private WebDriver driver;

	// Object Repositories
	private By profileName = By.cssSelector("span[id$='openUserProfileText");	
	private By logoutButton = By.xpath("//span[@id='dcmjhhr:logout::text']/div");
	private By acceptCookieButton = By.id("cookiePupupButtonId");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getProfileName() {
		ElementUtil.waitForVisibilityOfElement(profileName);
		return driver.findElement(profileName).getText();
	}

	public boolean isUserNavigatedtoHomePage() {

		try {
			acceptCookie();
			ElementUtil.waitForInvisibilityOfElement(acceptCookieButton);
		} catch (Exception e) {
		}

		ElementUtil.waitForVisibilityOfElement(profileName);
		return driver.findElement(profileName).isDisplayed();

	}

	public void clickLogoutButton() {

		if (isUserNavigatedtoHomePage()) {			

			ElementUtil.waitForVisibilityOfElement(profileName);
			driver.findElement(profileName).click();
			ElementUtil.waitForVisibilityOfElement(logoutButton);
			driver.findElement(logoutButton).click();
		}

	}

	public void acceptCookie() {

		ElementUtil.waitForVisibilityOfElement(acceptCookieButton);
		driver.findElement(acceptCookieButton).click();

	}
}
