package Test_Cases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pom.Log_out;
import Pom.Login;
import Utility.Excel_Reader;



public class Login_2 extends BaseClass  {
	
	 
	  WebDriver  driver;
	 
	 @Test(dataProvider="getdata")
	  public void login(String uname,String passwd) throws IOException
	  {   
		  driver=BaseClass.getDriver();
		  System.out.println(driver);
		  Login obj=PageFactory.initElements(driver,Login.class );
		  obj.loginMethod(uname,passwd);
		  
			 
		  
	  }
	
	 @Test(priority=1)
	public void logout() throws Throwable
	{
		// driver=BaseClass.getDriver();
		 System.out.println(driver);
		 Log_out obj=PageFactory.initElements(driver,Log_out.class );
		 obj.logout();
		 Assert.assertNotNull(obj);
		 
	}
	 @DataProvider(name="getdata")
	  public Object[][] getData() throws IOException
	  {
		 Object[][] data= Excel_Reader.getData("D:\\Selenium\\Data.xlsx","Sheet1");
		  
		  return data;
	  }
	 
	 
	 
	 

}
