package com.ecommerce.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"--- Test execution start ---");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"-->Passed");
		Reporter.log(methodName+"--- Success ---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("2");
		String FS = result.getMethod().getMethodName();
		String FScript=FS+ new JavaUtils().systemDateInFormat();
		test.addScreenCaptureFromPath(FScript);
		try {
			new WebDriverUtils().takesScreenShot(BaseClass.sdriver, FScript);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, FScript+"---> Failed");
		Reporter.log(FScript+"--> Execution failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"--- Skipped ---");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"--- Skipped ---");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET-52");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-browser", "Chrome");
		report.setSystemInfo("url", "http://rmgtestingserver/domain/Online_Shopping_Application/");
		report.setSystemInfo("Reporter name", "Ashish Shetty");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
