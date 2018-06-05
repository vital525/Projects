package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	@FindBy(id="txtUsername")
	 WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement button;
	
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
	  this.driver=driver;
	}
	
	public void username(String uname)
	{
		username.sendKeys(uname);
	}
	public void password(String pass)
	{
		password.sendKeys(pass);
	}
	public void button()
	{
		button.click();
	}
	
	public void loginMethod(String uname,String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		button.click();
	}

}
