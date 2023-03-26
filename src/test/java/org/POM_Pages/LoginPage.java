package org.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// WebElements

	@FindBy(xpath = "/html/body/div/header/div/div/ul/li[2]/a")
	private WebElement signInOption;

	@FindBy(name = "login[username]")
	private WebElement UserNameTextField;

	@FindBy(name = "login[password]")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//span[text()='Sign In']")
	private WebElement SignInButton;
	
	@FindBy(css = ".action.switch")
	private WebElement dropdownBox;
	
	@FindBy(css = "li[class='authorization-link']>a")
	private WebElement signOutButton;
	

	// constructor

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// page action methods.

	public void ClickOnsignInOption() {
		signInOption.click();
	}

	public void enterUserNameCredential(String uName) {
		UserNameTextField.sendKeys(uName);
	}

	public void enterPasswordCredential(String PW) {
		PasswordTextField.sendKeys(PW);
	}

	public void ClickOnsignInButton() {
		SignInButton.click();
	}
	
	public void clickOnDropdownBox() {
		dropdownBox.click();
	}
	
	public void clickOnsignOutButton() {
		signOutButton.click();
	}
}
