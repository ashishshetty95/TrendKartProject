package com.trendkart.admin;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecommerce.GenericUtils.BaseClass;
@Listeners (com.ecommerce.GenericUtils.ListenenerImplementation.class)
public class VerifyUserLoginTest extends BaseClass {
	@Test(groups="smoke")
	public void verifyUserLoginTest() throws IOException {
	}
}

