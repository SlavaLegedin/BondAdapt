package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class M_configurations {
	public By	lControlPanelSettings	= By.xpath(".//a[contains(text(),'Control Panel Settings')]");
	public By	lPrinter				= By.xpath(".//a[contains(text(),'Printer')]");
	public By	lLanguage				= By.xpath(".//a[contains(text(),'Language')]");
	public By	lPassword				= By.xpath(".//a[contains(text(),'Password')]");
	public By	lViewMode				= By.xpath(".//a[contains(text(),'View Mode')]");
	public By	lProfile				= By.xpath(".//a[contains(text(),'Profile')]");
	public By	lInstallers				= By.xpath(".//a[contains(text(),'Installers')]");
	public By	lMyDetails				= By.xpath(".//a[contains(text(),'My Details')]");
	public By	lEmailSignature			= By.xpath(".//a[contains(text(),'Email Signature')]");
	public By	CPL_Header				= By.cssSelector("#modalHeading");
	public By	CPL_bOk					= By.xpath(".//button[contains(text(),'OK')]");
	public By	CPL_Message				= By.xpath(".//p[@data-bind = 'text:labels.LABEL_CONTROLPANEL_RESTOREDEF_CONF_MESSAGE']");
	public By	Lang_header				= By.cssSelector("#modalHeading");
	public By	Lang_selectMenu			= By.cssSelector(".dropdown-arrow");
	public By	Lang_quantity			= By.xpath(".//div[@class ='btn-group bootstrap-select normal-line-height open']//a");
	public By	Lang_bClose				= By.cssSelector("#closeButton");
	public By	Pwd_header				= By.cssSelector("#modalHeading");
	public By	Pwd_fCurrentPwd			= By.xpath(".//input[@type='password' and @id='inputEmail']");
	public By	Pwd_fNewPwd				= By.xpath(".//input[@id='inputPassword']");
	public By	Pwd_fConfirmPwd			= By.xpath(".//input[@id='confirmPassword']");
	public By	Pwd_bClose				= By.cssSelector("#closeButton");
	public By	Pwd_frame				= By.xpath(".//iframe[@src='usersettings/changepassword/changepassword.html']");
	public By	Details_header			= By.cssSelector("#modalHeading");
	public By	Details_domain			= By.cssSelector("[data-bind='text: $root.domainName']");
	public By	Details_profile			= By.cssSelector("[data-bind='text:domainProfileName']");
	public By	Details_language		= By.cssSelector("[data-bind='text:languageName']");
	public By	Details_close			= By.cssSelector("#closeButton");

	public SelenideElement Details_close() {
		return $(Details_close);
	}

	public SelenideElement Details_header() {
		return $(Details_header);
	}

	public SelenideElement Details_domain() {
		return $(Details_domain);
	}

	public SelenideElement Details_profile() {
		return $(Details_profile);
	}

	public SelenideElement Details_language() {
		return $(Details_language);
	}

	public SelenideElement Pwd_frame() {
		return $(Pwd_frame).should(exist);
	}

	public SelenideElement Pwd_bClose() {
		return $(Pwd_bClose);
	}

	public SelenideElement Pwd_header() {
		return $(Pwd_header);
	}

	public SelenideElement Pwd_fCurrentPwd() {
		return $(Pwd_fCurrentPwd);
	}

	public SelenideElement Pwd_fNewPwd() {
		return $(Pwd_fNewPwd);
	}

	public SelenideElement Pwd_fConfirmPwd() {
		return $(Pwd_fConfirmPwd);
	}

	public SelenideElement Lang_header() {
		return $(Lang_header);
	}

	public SelenideElement Lang_close() {
		return $(Lang_bClose);
	}

	public SelenideElement Lang_selectMenu() {
		return $(Lang_selectMenu);
	}

	public String Lang_quantity() {
		return Integer.toString($$(Lang_quantity).size());
	}

	public SelenideElement CPL_Header() {
		return $(CPL_Header);
	}

	public SelenideElement CPL_bOk() {
		return $(CPL_bOk);
	}

	public SelenideElement CPL_Message() {
		return $(CPL_Message);
	}

	public SelenideElement lControlPanelSettings() {
		return $(lControlPanelSettings);
	}

	public SelenideElement lPrinter() {
		return $(lPrinter);
	}

	public SelenideElement lLanguage() {
		return $(lLanguage);
	}

	public SelenideElement lPassword() {
		return $(lPassword);
	}

	public SelenideElement lViewMode() {
		return $(lViewMode);
	}

	public SelenideElement lProfile() {
		return $(lProfile);
	}

	public SelenideElement lInstallers() {
		return $(lInstallers);
	}

	public SelenideElement lMyDetails() {
		return $(lMyDetails);
	}

	public SelenideElement lEmailSignature() {
		return $(lEmailSignature);
	}
}