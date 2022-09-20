package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class M_WorkStack {
	public By	lCloseAll	= By.cssSelector("a.notification-link");
	public By	msgNoItems	= By.cssSelector("span.workstack-span-no-item-label");

	public SelenideElement lCloseAll() {
		return $(lCloseAll);
	}

	public SelenideElement msgNoItems() {
		return $(msgNoItems);
	}
}