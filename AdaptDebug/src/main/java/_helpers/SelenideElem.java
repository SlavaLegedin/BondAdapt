package _helpers;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class SelenideElem {
	private SelenideElement element;

	public SelenideElem(By by) {
		element = $(by);
	}

	public void click() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.click();
	}

	public SelenideElement shouldBe(Condition... conditions) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element.should(conditions);
	}

}
