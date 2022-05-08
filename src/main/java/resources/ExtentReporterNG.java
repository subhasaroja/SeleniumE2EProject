package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporterNG {
	static ExtentReports extent;
	
	
	  public static ExtentReports getReportObject() {
	  System.out.println("calling getReport method"); String
	  path=System.getProperty("user.dir")+"\\reports\\index.html";
	  System.out.println("report path"+path); 
	  ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	  reporter.config().setReportName("Web Automation Results");
	  reporter.config().setDocumentTitle("Test Results");
	  
	  extent =new ExtentReports(); 
	  extent.attachReporter(reporter);
	  extent.setSystemInfo("Tester","subha"); return extent;
	  
	  }
	 
	 
}
