package com.firstMavenProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception ex) {
			System.out.println("Exception is " + ex.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseUrl");
		return url;
	}

	public String getUserName() {
		String userName = pro.getProperty("userName");
		return userName;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chromePath = pro.getProperty("chromedriverPath");
		return chromePath;
	}

	public String getGeckoPath() {
		String geckoPath = pro.getProperty("firefoxdriverPath");
		return geckoPath;
	}

	public String getIEPath() {
		String iePath = pro.getProperty("iePath");
		return iePath;
	}

	
}
