package com.ecomerce.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper {
	public static final String URL_BASE = "http://ecommerce-coti.s3-website-us-east-1.amazonaws.com";

	public static WebDriver create() {

		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		return driver;
	}

}
