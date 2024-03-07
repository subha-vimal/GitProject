package org.stepDefinition;

import java.io.IOException;

import org.helper.BaseClass;
import org.helper.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	Login login;

	@Given("user Launch the Browser and Launch Url")
	public void user_Launch_the_Browser_and_Launch_Url() {
		browserLaunch();
		launchUrl("https://www.facebook.com/");
	}

	@When("user have enter the Valid username and Invalid password")
	public void user_have_enter_the_Valid_username_and_Invalid_password() throws IOException {
		login = new Login();
		textBoxValues(login.getEmailTxt(), "subhashini23@ymail.com");
		textBoxValues(login.getPasswordTxt(), "Subha@23");
	}

	@When("user have enter the Valid username and Valid password")
	public void user_have_enter_the_Valid_username_and_Valid_password() throws IOException {
		login = new Login();
		textBoxValues(login.getEmailTxt(), getExcelData(2, 1));
		textBoxValues(login.getPasswordTxt(), getExcelData(2, 2));
	}

	@When("user have enter the {string} and  {string}")
	public void user_have_enter_the_and(String email, String password) {
		login = new Login();
		textBoxValues(login.getEmailTxt(), email);
		textBoxValues(login.getPasswordTxt(), password);
	}

	@When("user click the Login button")
	public void user_click_the_Login_button() throws InterruptedException {
		click(login.getLoginBtn());
		// elementClickableWait(login.getLoginBtn());
		Thread.sleep(5000);
	}

	@Then("user reach the Invalid Warning page")
	public void user_reach_the_Invalid_Warning_page() {

		if (currentUrl().contains("login")) {
			System.out.println("login Unsucessful");
		} else if (currentUrl().contains("first_password_failure")) {
			System.out.println("login Failure");
		}
		else {
			System.out.println("login Successful");
		}
		quitBrowser();
	}

}
