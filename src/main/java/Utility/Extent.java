package Utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent {
	
	public static void report()
	{
		
	
	ExtentReports reports=new ExtentReports("D:\\Maven_Project\\src\\main\\java\\Reports\\report.html",true);
	ExtentTest test=reports.startTest("report");
	test.log(LogStatus.PASS, "Pass");
	
	
	
}
}