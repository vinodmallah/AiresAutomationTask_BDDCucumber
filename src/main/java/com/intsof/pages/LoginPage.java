package com.intsof.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
	// Object Repositories
	private By userName = By.id("username::content");
	private By nextButton = By.id("nextButton");	
	private By password = By.id("password::content");
	private By loginButton = By.id("loginButton");
	private By forgotPasswordLink = By.id("dpl2s::text");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void enterUsername(String name) {
		driver.findElement(userName).sendKeys(name);
	}
	
	public void enterPassword(String pwd) {		
		WebDriverWait wait = new WebDriverWait(driver,10L);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password::content")));
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickNext() {
		driver.findElement(nextButton).click();		
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();		
	}
	
	

}
