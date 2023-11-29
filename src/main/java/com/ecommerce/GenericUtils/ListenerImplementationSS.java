package com.ecommerce.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationSS extends BaseClassSS implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+name+".png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

}
