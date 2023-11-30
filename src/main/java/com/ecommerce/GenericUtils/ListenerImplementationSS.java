package com.ecommerce.GenericUtils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationSS implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		try {
			new WebDriverUtils().takesScreenShot(BaseClassSS.sdriver, name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
