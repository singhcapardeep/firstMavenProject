package com.firstMavenProject.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.firstMavenProject.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	public String baseUrl = readConfig.getApplicationURL();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public String chromeDriverPath = readConfig.getChromePath();
	public String geckoDriverPath = readConfig.getGeckoPath();
	public String ieDriverPath = readConfig.getIEPath();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			logger.info("Entered in chrome browser");
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();
			logger.info("Entered in firefox browser");
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", ieDriverPath);
			driver = new InternetExplorerDriver();
			logger.info("Entered in internet explorer browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		logger.info("Entered in application url");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screeshot taken");
	}

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
