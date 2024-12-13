package POMClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	
		
		//used for the UI
		public ExtentSparkReporter sparkReport;
		//used for TesterName ,Environment Name, Common Details
		public ExtentReports extent;
		//used to Update the results in Report
		public ExtentTest text;
		
		public void onStart(ITestContext context) {
		   sparkReport=new ExtentSparkReporter(System.getProperty("user.dir")+"/Report/myReport.html");
		   sparkReport.config().setDocumentTitle("Automation Report");
		   sparkReport.config().setReportName("OrangeReport");
		   sparkReport.config().setTheme(Theme.STANDARD);
		   
		   
		   extent=new ExtentReports();
		   extent.attachReporter(sparkReport);//combine the UI
		   
		   extent.setSystemInfo("CodedBy", "Naveen");
		   
		   
		  }
		
		public void onTestSuccess(ITestResult result) {
		    
			text=extent.createTest(result.getName());
			text.log(Status.PASS, "The method is "+result.getName());
		  }
		public void onTestFailure(ITestResult result) {
			text=extent.createTest(result.getName());
			text.log(Status.FAIL, "The method is "+result.getName());
			text.log(Status.FAIL, "The method is "+result.getThrowable());
		  }
		public void onTestSkipped(ITestResult result) {
			text=extent.createTest(result.getName());
			text.log(Status.SKIP, "The method is "+result.getName());
			
		  }
		
		public void onFinish(ITestContext context) {
		   
			extent.flush();
		  }

	}


