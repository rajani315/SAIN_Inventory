package com.generic.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.generic.webdriverUtility.UtilityClassObject;
/**
 * Provides implementation for ITestListener Interface's default methods and ISuiteListener Interface's abstract methods.
 * @author Rajani
 *
 */
public class ListenerImpClass implements ITestListener, ISuiteListener {

	ExtentSparkReporter spark;
	ExtentReports report;
	public static ExtentTest test;

	/* ISuiteListener methods implementation */
	@Override
	public void onStart(ISuite suiteInfo) {
		Reporter.log("report configuration",true);
		// configure the report
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("SAIN Test Suite Results");
		spark.config().setReportName("SAIN report");
		spark.config().setTheme(Theme.STANDARD);

		// add environment info
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-128");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		report.flush();
	}

	// ITestListener methods implementation

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = report.createTest(result.getMethod().getMethodName());
		
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName()+" ---> STARTED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" ---> FAILED");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" ---> FAILED");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" ---> FAILED");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		UtilityClassObject.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" ---> SKIPPED");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName()+" ---> SUCCESS");
	}

}
