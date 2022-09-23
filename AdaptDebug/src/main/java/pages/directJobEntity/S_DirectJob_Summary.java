package pages.directJobEntity;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class S_DirectJob_Summary {

    private By directJobId =  By.xpath("");

    public SelenideElement fdirectJobId() {return $(directJobId);}

}
