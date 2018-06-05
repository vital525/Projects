package Utility;




import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseClass.BaseClass;
public class Screenshot extends BaseClass {
	
	
	
		WebDriver driver;
		
		
		@AfterMethod
		public void getTestCaseStatus(ITestResult result) throws IOException
		{
			driver=BaseClass.getDriver();
			
			if(ITestResult.FAILURE==result.getStatus())
			{
				 System.out.println("test case is Fail");
				 TakesScreenshot shot=((TakesScreenshot)driver);
				 java.io.File src= shot.getScreenshotAs(OutputType.FILE);
				 FileUtils.copyFile(src, new File("D:/Maven_Project/src/main/java/Screenshots/"+result.getMethod().getMethodName()+"_Fail"+".png"));
				 super.test.log(LogStatus.PASS, "Pass");
				 
				 
			}
				else if(ITestResult.SUCCESS==result.getStatus())
				{
					System.out.println("test case is Pass");
					TakesScreenshot shot=((TakesScreenshot)driver);
					java.io.File src= shot.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(src, new File("D:/Maven_Project/src/main/java/Screenshots/"+result.getMethod().getMethodName()+"_Pass"+".png"));
					test.log(LogStatus.FAIL, "Fail");
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
		}








