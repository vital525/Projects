package BaseClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
	
	public  static WebDriver driver;
	ExtentReports extentReports;
	protected ExtentTest test;
	
    @BeforeSuite
	public  void browser()
	{
		driver=new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void getTestCaseStatus(ITestResult result) throws IOException
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			 System.out.println("test case is Fail");
			 TakesScreenshot shot=((TakesScreenshot)driver);
			 java.io.File src= shot.getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(src, new File("D:/Maven_Project/src/main/java/Screenshots/"+result.getMethod().getMethodName()+""+System.currentTimeMillis()+"_Fail"+".png"));
			 test.log(LogStatus.FAIL, "Fail");
			 
			 
			 
		}
			else if(ITestResult.SUCCESS==result.getStatus())
			{
				System.out.println("test case is Pass");
				TakesScreenshot shot=((TakesScreenshot)driver);
				java.io.File src= shot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("D:/Maven_Project/src/main/java/Screenshots/"+result.getMethod().getMethodName()+"_Pass"+".png"));
				test.log(LogStatus.PASS, "Pass");
				
			}
			else
			{
				System.out.println("test case is Skip");
				TakesScreenshot shot=((TakesScreenshot)driver);
				java.io.File src= shot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("D:/Maven_Project/src/main/java/Screenshots/"+result.getMethod().getMethodName()+"_skip"+".png"));
				test.log(LogStatus.SKIP, "Skip");
				
			}
			
		}
	@BeforeMethod
	public void runTimeTcName(Method method) 
	{
		
		test = extentReports.startTest(method.getName());
	} 
	
	@BeforeTest
	public void initialiseReport()
	{
		String reportLoc = System.getProperty("user.dir")+"\\Reports\\report.html";
		extentReports = new ExtentReports(reportLoc);	
	}
	@AfterTest
	public void endReport()
	{
		extentReports.flush();
		
	} 
	public static WebDriver getDriver()
	{
		return driver;
	}
	@AfterSuite
	public void close()
	{
		
		driver.close();
	}

}
