package com.firstMavenProject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.firstMavenProject.pageObjects.LoginPage;

public class TC_firstMavenProject_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		logger.info("Url is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickButton();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

	}

}
