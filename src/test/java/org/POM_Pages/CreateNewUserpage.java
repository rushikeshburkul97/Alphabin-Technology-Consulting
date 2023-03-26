package org.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUserpage {

	// WebElements

	@FindBy(xpath = "/html/body/div/header/div/div/ul/li[3]/a")
	private WebElement createAnAccountOption;

	@FindBy(id = "firstname")
	private WebElement firstNameTextField;

	@FindBy(id = "lastname")
	private WebElement lastNameTextField;

	@FindBy(id = "email_address")
	private WebElement emailTextField;

	@FindBy(id = "password")
	private WebElement passwordTextField;

	@FindBy(id = "password-confirmation")
	private WebElement confirmPasswordTextField;

	@FindBy(xpath = "//span[text()='Create an Account']")
	private WebElement createAnAccountButton;
	
	@FindBy(css = ".action.switch")
	private WebElement dropdownBox;
	
	@FindBy(css = "li[class='authorization-link']>a")
	private WebElement signOutButton;
	

	// constructor

	public CreateNewUserpage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// page action methods.

	public void clickOnCreateAccountOption() {
		createAnAccountOption.click();
	}

	public void enterFirstNameCredential(String fName) {
		firstNameTextField.sendKeys(fName);
	}

	public void enterLastNameCredential(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}

	public void enterEmailAddress(String email) {
		emailTextField.sendKeys(email);
	}

	public void enterEmailPassword(String ePassword) {
		passwordTextField.sendKeys(ePassword);
	}

	public void confirmEmailPassword(String confirmEPassword) {
		confirmPasswordTextField.sendKeys(confirmEPassword);
	}

	public void clickOnCreateAccountButton() {
		createAnAccountButton.click();
	}
	
	public void clickOnDropdownBox() {
		dropdownBox.click();
	}
	
	public void clickOnsignOutButton() {
		signOutButton.click();
	}
	
}
