package org.POM_Test_Cases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.POM_Pages.CreateNewUserpage;
import org.POM_Pages.LoginPage;
import org.ScreenShots.GetScreenShot;
import org.Utilities.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserTC {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;
	Properties prop = gm.getProp();

	@BeforeMethod
	public void initializeBrowser() {
		driver = gm.startUP(prop.getProperty("Browsername"), prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test (priority =2)
	public void verifyLoginPageFunctionality() {

		LoginPage obj = new LoginPage(driver);

		obj.ClickOnsignInOption();
		Reporter.log("clicked on sign in option");

		obj.enterUserNameCredential(prop.getProperty("Username"));
		Reporter.log("Entered Username as:" + prop.getProperty("Username"));
		obj.enterPasswordCredential(prop.getProperty("Password"));
		Reporter.log("Entered Password as:");

		obj.ClickOnsignInButton();
		Reporter.log("clicked on sign in button");

		Assert.assertEquals(driver.getTitle(), "Home Page", "Title is not verifed");
		Reporter.log("Login Page Title Verified Successfully = " + driver.getTitle());

		Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/", "URL is Not Verified");
		Reporter.log("Login Page URL Verified Successfully = " + driver.getCurrentUrl());

		Reporter.log("user is loggedin successfully");

	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException {
		CreateNewUserpage obj1 = new CreateNewUserpage(driver);
		if(ITestResult.FAILURE == result.getStatus()) {
			GetScreenShot.takesScreenShot(driver, result.getName());
		}
		
		obj1.clickOnDropdownBox();
		obj1.clickOnsignOutButton();
	//	driver.quit();

	}

}
