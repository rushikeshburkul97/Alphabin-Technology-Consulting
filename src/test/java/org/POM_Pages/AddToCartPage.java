package org.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	// WebElements
	
	@FindBy(xpath = "/html/body/div/header/div/div/ul/li[2]/a")
	private WebElement signInOption;
	
	@FindBy(name = "login[username]")
	private WebElement UserNameTextField;

	@FindBy(name = "login[password]")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//span[text()='Sign In']")
	private WebElement SignInButton;
	
	@FindBy(css = "input[placeholder='Search entire store here...']")
	private WebElement SearchTextField;
	
	@FindBy(css = ".action.search")
	private WebElement SearchButton;
	
	@FindBy(css = "div[class='product-item-info']")
	private WebElement addToCartElement;
	
	
	@FindBy(id = "option-label-size-143-item-166")
	private WebElement sizeOfProductEle;
	
	@FindBy(id = "option-label-color-93-item-59")
	private WebElement colourOfProductEle;
	
	@FindBy(id = "product-addtocart-button")
	private WebElement addToCartOption;
	
	
	@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement NotificationMessage;
	
	@FindBy(css = ".action.switch")
	private WebElement dropdownBox;
	
	@FindBy(css = "li[class='authorization-link']>a")
	private WebElement signOutButton;
	
	
	

	// constructor

	public AddToCartPage(WebDriver driver) {
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
	
	public void enterProductName(String pName) {
		SearchTextField.sendKeys(pName);
	}
	
	public void ClickOnSearchButton() {
		SearchButton.click();
	}
	
	public void ClickOnAddToCartElement() {
		addToCartElement.click();
	}
	
	public void ClickOnSizeOfProductElement() {
		sizeOfProductEle.click();
	}
	
	public void ClickOnColourOfProductElement() {
		colourOfProductEle.click();
	}
	
	public void ClickOnAddToCartOption() {
		addToCartOption.click();
	}
	
	public String getTextOfNotificationMessage() {
		return NotificationMessage.getText();
	}
	
	public void clickOnDropdownBox() {
		dropdownBox.click();
	}
	
	public void clickOnsignOutButton() {
		signOutButton.click();
	}
	
}
