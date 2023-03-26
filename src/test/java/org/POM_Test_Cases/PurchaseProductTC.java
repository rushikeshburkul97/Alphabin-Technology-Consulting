package org.POM_Test_Cases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.POM_Pages.PurchaseProductPage;
import org.ScreenShots.GetScreenShot;
import org.Utilities.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseProductTC {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;
	Properties prop = gm.getProp();

	@BeforeMethod
	public void initializeBrowser() {
		driver = gm.startUP(prop.getProperty("Browsername"), prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test (priority =4)
	public void verifyPurchaseProductFunctionality() throws InterruptedException {

		PurchaseProductPage obj = new PurchaseProductPage(driver);

		obj.ClickOnsignInOption();
		Reporter.log("clicked on sign in option");

		obj.enterUserNameCredential(prop.getProperty("Username"));
		Reporter.log("Entered Username as:" + prop.getProperty("Username"));
		obj.enterPasswordCredential(prop.getProperty("Password"));
		Reporter.log("Entered Password as:");

		obj.ClickOnsignInButton();
		Reporter.log("clicked on sign in button");

		Thread.sleep(5000);
		
		obj.ClickOnMyCartElement();
		obj.ClickOnProceedToCheckOutElement();
		Thread.sleep(5000);
		obj.ClickOnNextButtonTab();
		Thread.sleep(5000);
		obj.ClickOnPlaceOrderTab();
		
		// Verify Purchase Details.
		
		boolean flag = obj.isPrintReceiptHyperlinkDisplayed();
		Assert.assertEquals(flag, true);
		Reporter.log("Print Receipt Hyperlink is Displayed Successfully");
		
		Assert.assertEquals(driver.getTitle(), "Success Page", "Title is not verifed");
		Reporter.log("Payment Page Title Verified Successfully = " + driver.getTitle());
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/checkout/onepage/success/", "URL is Not Verified");
		Reporter.log("Payment Page URL Verified Successfully = " + driver.getCurrentUrl());
		
		Reporter.log("an user is successfully placed a Purchase order");

	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException {
		if(ITestResult.FAILURE == result.getStatus()) {
			GetScreenShot.takesScreenShot(driver, result.getName());
		}
		driver.quit();

	}

}
