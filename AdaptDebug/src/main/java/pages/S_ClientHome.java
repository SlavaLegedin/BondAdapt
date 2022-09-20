package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import _helpers.TestBase;

public class S_ClientHome extends TestBase{
	
	private By  	frameRoleSearchFrame 	= By.xpath(".//iframe[@id = 'roleSearchFrame']");
	private By		frameRootCompanies		= By.xpath(".//iframe[@id = 'tabframe-root-_S_COMPANIES']");
	private By		frameLegacyContainer	= By.xpath(".//iframe[@id = 'legacyContainer']");
	private By 		frameSearchResults		= By.xpath(".//iframe[@id = 'qfHomeResultsFrame__S_COMPANIES']");
	
	private By 		chClientRole 			= By.xpath(".//td[@id = 'ROLE_116']//input[@type = 'checkbox']");
	private By		bFind					= By.xpath(".//input[@id = 'find' and @name = 'find']");
	private By		bCreate					= By.xpath(".//input[@id = 'create' and @name = 'create']");
	
	
	
	/*initialization of elements*/
	public SelenideElement frameLegacyContainer () {
		return $(frameLegacyContainer);
	}
	
	public SelenideElement frameRootCompanies () {
		return $(frameRootCompanies);
	}
	
	public SelenideElement frameRoleSearchFrame () {
		return $(frameRoleSearchFrame);
	}
	
	public SelenideElement frameSearchResults () {
		return $(frameSearchResults);
	}
	
	public SelenideElement chClientRole () {
		return $(chClientRole);
	}
	
	public SelenideElement bCreate () {
		return $(bCreate);
	}
	
	public SelenideElement bFind () {
		return $(bFind);
	}
	
	/*Assertions*/
	

}
