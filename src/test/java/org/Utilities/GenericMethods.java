package org.Utilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	// Generic Method for To initialized browser.
	
	public WebDriver startUP(String browserName, String url) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			option.addArguments("start-maximized");
			option.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(option);

		} else if (browserName.equalsIgnoreCase("edge") || browserName.equalsIgnoreCase("ed")) {
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--disable-notification");
			option.addArguments("start-maximized"); 

			driver = new EdgeDriver(option);

		} else if(browserName.equalsIgnoreCase("firefox") || browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--disable-notification");
			option.addArguments("start-maximized"); 

			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser name !!");
		}
			
		
		driver.get(url);
		return driver;
	}
//	Generic Methods for Properties file details.
	
	public Properties getProp() {
		try {
			FileInputStream fis = new FileInputStream("./Properties_Files/Config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop;
		}catch(Exception e) {
			e.printStackTrace();
			return null ;
		}
	}
	
// GM for wait for visibility of element.
	
	public void waitForVisibilityOfElement(WebDriver driver, long time, WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));
	}
}
