package pages;

import _helpers.MySoftAssert;
import _helpers.TestBase;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class W_DirectJob_NewJobOrder extends TestBase {

    public String windowTitle  =   "New Direct Job Order";

    private By ClientName = By.xpath("//*[@id=\"CLIENT$W_US_NewDirectJobOrder$W_US_NewDirectJobOrder\"]");

    private By ContactName = By.xpath("//*[@id=\"REQUESTOR$W_US_NewDirectJobOrder$W_US_NewDirectJobOrder\"]");

    private By JobTitle = By.xpath("//*[@id=\"JOBTITLE$W_US_NewDirectJobOrder$W_US_NewDirectJobOrder\"]");

    public SelenideElement fJobTitle() {return $(JobTitle);}

    public SelenideElement ClientNameField () {return $(ClientName);}

    public SelenideElement ContactNameField() {return $(ContactName);}

    public void verifyClientName (MySoftAssert softAssert, String title) {

        softAssert.assertEquals(title,  ClientNameField().getText());
    }

    public void verifyContactName (MySoftAssert softAssert, String title) {

        softAssert.assertEquals(title,  ContactNameField().getText());
    }

}
