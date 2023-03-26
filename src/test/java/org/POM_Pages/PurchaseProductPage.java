package org.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PurchaseProductPage {
	
	// WebElements

	@FindBy(xpath = "/html/body/div/header/div/div/ul/li[2]/a")
	private WebElement signInOption;

	@FindBy(name = "login[username]")
	private WebElement UserNameTextField;

	@FindBy(name = "login[password]")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//span[text()='Sign In']")
	private WebElement SignInButton;
	
	@FindBy(css = ".action.showcart")
	private WebElement MyCartElement;
	
	@FindBy(id = "top-cart-btn-checkout")
	private WebElement ProceedToCheckOutElement;
	
	@FindBy(css = ".button.action.continue.primary")
	private WebElement NextButtonTab;
	
	@FindBy(css = ".action.primary.checkout")
	private WebElement PlaceOrderTab;
	
	@FindBy(css = ".action.print")
	private WebElement PrintReceiptHyperLink;
	
	

	// constructor

	public PurchaseProductPage(WebDriver driver) {
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
	
	public void ClickOnMyCartElement() {
		MyCartElement.click();
	}
	
	public void ClickOnProceedToCheckOutElement() {
		ProceedToCheckOutElement.click();
	}
	
	public void ClickOnNextButtonTab() {
		NextButtonTab.click();
	}
	
	public void ClickOnPlaceOrderTab() {
		PlaceOrderTab.click();
	}
	
	public boolean isPrintReceiptHyperlinkDisplayed() {
		return PrintReceiptHyperLink.isDisplayed();
	}
	
}
