package dummy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://samltest.aires.com/mobilityx/faces/jsf/Login.jsf");
		
		driver.findElement(By.id("username::content")).sendKeys("VInodMallah");
		driver.findElement(By.id("nextButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10L);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password::content")));
		
		driver.findElement(By.id("password::content")).sendKeys("Test123");
		driver.findElement(By.id("loginButton")).click();

	}

}
