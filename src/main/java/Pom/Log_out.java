package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Log_out {

	WebDriver driver;
	@FindBy(xpath="//a[@id='welcome']")

	WebElement logout;

	@FindBy(xpath="//a[text()='Logout']")

	WebElement logout_2;

	public Log_out(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void logout() throws Throwable
	{
		Thread.sleep(5000);
		logout.click();
		logout_2.click();
	}

	
}
