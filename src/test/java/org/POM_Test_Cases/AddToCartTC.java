package org.POM_Test_Cases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.POM_Pages.AddToCartPage;
import org.POM_Pages.CreateNewUserpage;
import org.ScreenShots.GetScreenShot;
import org.Utilities.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTC {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;
	Properties prop = gm.getProp();

	@BeforeMethod
	public void initializeBrowser() {
		driver = gm.startUP(prop.getProperty("Browsername"), prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test (priority =3)
	public void verifyAddToCartFunctionality() {

		AddToCartPage obj = new AddToCartPage(driver);

		obj.ClickOnsignInOption();
		Reporter.log("User Successfully clicked on sign in option");

		obj.enterUserNameCredential(prop.getProperty("Username"));
		Reporter.log("Entered Username as: = " + prop.getProperty("Username"));
		obj.enterPasswordCredential(prop.getProperty("Password"));
		Reporter.log("Entered Password as:");

		obj.ClickOnsignInButton();
		Reporter.log("clicked on sign in button");

		obj.enterProductName(prop.getProperty("ProductName"));
		Reporter.log("enter product name successfully as = "+prop.getProperty("ProductName"));
		obj.ClickOnSearchButton();
		Reporter.log("User Successfully clicks on Search button");
		obj.ClickOnAddToCartElement();
		Reporter.log("User Successfully clicks on Add to Cart Element");
		obj.ClickOnSizeOfProductElement();
		Reporter.log("User Successfully clicks on size of Product Element");
		obj.ClickOnColourOfProductElement();
		Reporter.log("User Successfully clicks on colour of Product Element");
		obj.ClickOnAddToCartOption();
		Reporter.log("User Successfully clicks on Add to Cart option");
		
		// Verify user is able to add a product to cart.
		
		String textOfNotifinMessage = obj.getTextOfNotificationMessage();
		Assert.assertEquals(textOfNotifinMessage, "You added Selene Yoga Hoodie to your shopping cart.");
		Reporter.log("User is Successfully Added a Product to Shooping Cart");
		
		

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
