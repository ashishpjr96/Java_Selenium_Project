package SeleniumJava.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject() {
		
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomation Test Report");
		reporter.config().setDocumentTitle("Automation Test Results");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ashish Poojary");
		extent .createTest(path);
		return extent;
	}	

}
