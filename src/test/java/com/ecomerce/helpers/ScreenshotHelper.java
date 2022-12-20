package com.ecomerce.helpers;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {

	public static void create(String fileName, WebDriver driver) {
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("screenshots/" + fileName + ".png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
}

