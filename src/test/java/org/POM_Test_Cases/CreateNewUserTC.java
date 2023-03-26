package org.POM_Test_Cases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.POM_Pages.CreateNewUserpage;
import org.ScreenShots.GetScreenShot;
import org.Utilities.GenericMethods;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewUserTC {

	GenericMethods gm = new GenericMethods();
	WebDriver driver;
	Properties prop = gm.getProp();

	@BeforeMethod
	public void initializeBrowser() {
		driver = gm.startUP(prop.getProperty("Browsername"), prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@Test (priority = 1)
	public void verifyCreateUserFunctionality() {

		CreateNewUserpage obj = new CreateNewUserpage(driver);

		try {
		obj.clickOnCreateAccountOption();
		Reporter.log("clicked on create account option successfully");
		
		FileInputStream fis = new FileInputStream("./Excel_File_Handling/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("UserDetails");
		

		obj.enterFirstNameCredential(s.getRow(1).getCell(0).getStringCellValue());
		Reporter.log("Entered First Name details successfully");
		obj.enterLastNameCredential(s.getRow(1).getCell(1).getStringCellValue());
		Reporter.log("Entered Last Name details successfully");
		obj.enterEmailAddress(s.getRow(1).getCell(2).getStringCellValue());
		Reporter.log("Entered email address successfully");
		
		obj.enterEmailPassword(s.getRow(1).getCell(4).getStringCellValue());
		Reporter.log("Entered email address successfully");
		obj.confirmEmailPassword(s.getRow(1).getCell(4).getStringCellValue());
		Reporter.log("Entered Password Credentials successfully");
		
		Thread.sleep(3000);
		
		obj.clickOnCreateAccountButton();
		Reporter.log("clicked on create account button successfully");
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.getTitle(), "My Account", "Title is not verifed");
		Reporter.log("My Account Page Title Verified Successfully = " + driver.getTitle());

		Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/",
				"URL is Not Verified");
		Reporter.log("My Account Page URL Verified Successfully = " + driver.getCurrentUrl());

		Reporter.log("New user Created successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException {
		CreateNewUserpage obj1 = new CreateNewUserpage(driver);
		
		if(ITestResult.FAILURE == result.getStatus()) {
			GetScreenShot.takesScreenShot(driver, result.getName());
		}
		obj1.clickOnDropdownBox();
		obj1.clickOnsignOutButton();
		
	//	 driver.quit();

	}

}
