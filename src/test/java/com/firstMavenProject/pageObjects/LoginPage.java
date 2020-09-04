package com.firstMavenProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	@CacheLookup
	WebElement textName;

	@FindBy(name = "password")
	@CacheLookup
	WebElement textPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;

	public void setUsername(String username) {
		textName.sendKeys(username);
	}

	public void setPassword(String pass) {
		textPassword.sendKeys(pass);
	}

	public void clickLogout() {
		lnkLogout.click();
	}
	public void clickButton() {
		btnLogin.click();
	}

}
