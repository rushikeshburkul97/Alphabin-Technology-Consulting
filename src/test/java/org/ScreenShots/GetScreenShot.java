package org.ScreenShots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class GetScreenShot {
	
	public static void takesScreenShot(WebDriver driver, String screenShotName) throws IOException {
		
		File ScreenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ScreenShotFile, new File("./Screenshots"+screenShotName+".png"));
	}


}
