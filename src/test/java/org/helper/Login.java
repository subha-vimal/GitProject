package org.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {
	public Login() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement emailTxt;

	@FindBy(id = "pass")
	private WebElement passwordTxt;

	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement loginBtn;

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
