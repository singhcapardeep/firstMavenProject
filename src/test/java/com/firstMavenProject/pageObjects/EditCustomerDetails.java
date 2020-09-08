package com.firstMavenProject.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerDetails {

	WebDriver ldriver;

	public EditCustomerDetails(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Edit Customer']")
	@CacheLookup
	WebElement lnkEditCustomerDetails;
	
	@FindBy(how = How.NAME, using = "cusid")
	@CacheLookup
	WebElement txtcustomerId;	
	
	@FindBy(how = How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement btnnSubmit;
	
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Continue']")
	@CacheLookup
	WebElement linkContinue;
	
	public void custId(String customerId) {
		txtcustomerId.sendKeys(customerId);
		
	}
	
	public void clickEditCustomer() {
		lnkEditCustomerDetails.click();
			
	}
	public void clickOnSubmit() {
		btnnSubmit.click();
			
	}
	
	public void custaddress(String caddress) {
		txtaddress.clear();
		txtaddress.sendKeys(Keys.BACK_SPACE);
		txtaddress.sendKeys(Keys.DELETE);
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(Keys.BACK_SPACE);
		txtcity.clear();
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(Keys.BACK_SPACE);
		txtstate.clear();
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(Keys.BACK_SPACE);
		txtpinno.clear();
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(Keys.BACK_SPACE);
		txttelephoneno.clear();
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(Keys.BACK_SPACE);
		txtemailid.clear();
		txtemailid.sendKeys(cemailid);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	//click continue button
	public void clickContinue() {
		linkContinue.click();
	}
	
	 
}
