package com.intsof.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intsof.factory.DriverFactory;

public class ElementUtil {

	private static WebDriverWait wait;

	public static void waitForVisibilityOfElement(By locator) {

		wait = new WebDriverWait(DriverFactory.getDriver(), 10L);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public static void waitForInvisibilityOfElement(By locator) {

		wait = new WebDriverWait(DriverFactory.getDriver(), 15L);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

}
