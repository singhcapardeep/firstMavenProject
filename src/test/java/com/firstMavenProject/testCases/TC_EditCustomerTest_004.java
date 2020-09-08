package com.firstMavenProject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.firstMavenProject.pageObjects.EditCustomerDetails;
import com.firstMavenProject.pageObjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass {

	@Test
	public void editCustomerDetails() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickButton();

		Thread.sleep(3000);
		EditCustomerDetails editCustomerDetails = new EditCustomerDetails(driver);
		editCustomerDetails.clickEditCustomer();
		editCustomerDetails.custId("11244");
		editCustomerDetails.clickOnSubmit();

		if (driver.getTitle().equals("Guru99 Bank Edit Customer Entry Page")) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
		} else {
			logger.info("test case failed....");
			captureScreenshot(driver, "customerId is not valid");
		}
		
		editCustomerDetails.custaddress("Canada");
		editCustomerDetails.custcity("YNP");
		editCustomerDetails.custstate("HARYANA");
		editCustomerDetails.custpinno("135001");
		editCustomerDetails.custtelephoneno("9949589451");
		editCustomerDetails.custemailid("testest@gmail.com");
		editCustomerDetails.custsubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Customer Registration Page")) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
		} else {
			logger.info("test case failed....");
			captureScreenshot(driver, "customerId is not valid");
		}
		editCustomerDetails.clickContinue();
		  
	}


}
