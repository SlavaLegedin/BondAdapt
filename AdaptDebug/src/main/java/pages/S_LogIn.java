package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;

public class S_LogIn {
	//asdfasdf

	//asdfasdfdsf
	public void logIn(String username, String pwd) throws InterruptedException {
		$("#adapt_login_username").shouldBe(visible).clear();
		$("#adapt_login_username").val(username);
		$("#adapt_login_password").shouldBe(visible).clear();
		$("#adapt_login_password").val(pwd);
		$("#adapt_login_submit").click();
		try {
			SelenideElement cont = $("#adapt_already_loggedin_continue");
			SelenideWait w = new SelenideWait(WebDriverRunner.getWebDriver(), 5000, 200);
			w.until(ExpectedConditions.visibilityOf(cont)).click();
		} catch (AssertionError e) {
			System.out.println("wasn't logined");
		}

	}

}