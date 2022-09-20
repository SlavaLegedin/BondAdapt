package pages;

import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

import _helpers.SelenideElem;
import _helpers.TestBase;

public class S_PeopleHome extends TestBase {

	//public By	chCandidate					= By.cssSelector("[value = '6920556']");
	private By	frame_legacyContainer		= By.id("legacyContainer");
	//public By	frame_roleSearchFrame		= By.id("roleSearchFrame");
	public By	frame_RootPeople			= By.id("tabframe-root-_S_PEOPLE");
	public By	frame_qfHomeResultsFrame	= By.id("qfHomeResultsFrame__S_PEOPLE"); 
	//"#tabframe-root-_S_PEOPLE"
	
	private By	bFind						= By.cssSelector("[value='Find']");
	private By  bClear						= By.xpath(".//input[@id = 'clear']");
	private By	lFirstSearchResult			= By.xpath("(.//a[@id='deleteEntity'])[1]");
	private By	hRecentHistory				= By.cssSelector("#historyHeader");
	private By	hMainHeader					= By.cssSelector("span.main-header-text");
	private By	bAddToFavourites			= By.cssSelector("button#ADDFAVOURITES");
	private By	bDelToFavourites			= By.cssSelector("button#DELFAVOURITES");
	
	//added by kp 22.01.2019
	public By bCreateCand					= By.xpath(".//span[@id = 'Create']");
	//added by kp 14.03.2019
	public By	frame_roleSearchFrame		= By.xpath(".//iframe[@id = 'roleSearchFrame']");
	public By	chCandidate					= By.xpath(".//input[@value = '6920556' and @type = 'checkbox']");
	
	//added by kp 17.10.2019
	private By fFirstName					= By.xpath(".//input[@id = '10214$']");
	private By fLastName					= By.xpath(".//input[@id = '10226$']");
	private By fNickName					= By.xpath(".//input[@id = '10240$']");
	private By fState						= By.xpath(".//input[@id = '6933128$']");
	private By fPostalCode					= By.xpath(".//input[@id = '6933124$']");
	private By fEmail						= By.xpath(".//input[@id = '6936985$']");
	private By fPersonId					= By.xpath(".//input[@id = '10654$']");
	private By fJobTitle					= By.xpath(".//input[@id = '6933251$']");
	private By fBranch						= By.xpath(".//input[@id = '6933551$']");
	private By fPhoneNumber					= By.xpath(".//input[@id = '10362$']");
	private By fSsnLastDigits				= By.xpath(".//input[@id = '100014758$']");
	private By fLastContBy					= By.xpath(".//input[@id = '10272$']");
	
	
	
	public SelenideElement flastContBy () {
		return $(fLastContBy);
	}
	
	public SelenideElement fSsnLastDigits () {
		return $(fSsnLastDigits);
	}
		
	public SelenideElement fPhoneNumber () {
		return $(fPhoneNumber);
	}
		
	public SelenideElement fBranch () {
		return $(fBranch);
	}
		
	public SelenideElement fJobTitle () {
		return $(fJobTitle);
	}
		
	public SelenideElement fPersonId () {
		return $(fPersonId);
	}
	
	public SelenideElement fEmail () {
		return $(fEmail);
	}
	
	public SelenideElement fPostalCode () {
		return $(fPostalCode);
	}
		
	public SelenideElement fState () {
		return $(fState);
	}
	
	public SelenideElement fNickName () {
		return $(fNickName);
	}
		
	public SelenideElement fLastName () {
		return $(fLastName);
	}
	
	public SelenideElement fFirstName () {
		return $(fFirstName);
	}
	
	public SelenideElement bClear () {
		return $(bClear);
	}
	
	public SelenideElement lRecentHistoryText(String text) {
		return $(By.xpath(".//*[contains(text(),'" + text + "')]"));
	}

	public SelenideElement lFavorText(String text) {
		return $(By.xpath(".//div[@id = 'favouritesDiv']//a[contains(text(),'" + text + "')]"));
	}

	public SelenideElement lFavouriteName(String name) {
		switchTo().frame($("#legacyContainer").shouldBe(exist));
		switchTo().frame($("#tabframe-root-_S_PEOPLE").shouldBe(exist));
//		switchTo().frame($("#favouritesFrame").shouldBe(exist));
		return $(By.xpath(".//*[@id='favouritesDiv']//*[contains(text(),\"" + name + "\")]"));
	}

	public void switchToHeader() throws InterruptedException {
		switchToFrame(frame_legacyContainer, hMainHeader);
	}

	public void switchToPersonAdvansedLookup() {
		switchToFrame(frame_legacyContainer, frame_RootPeople, frame_roleSearchFrame, chCandidate);
	}

	public void swithToLookupResults() {
		switchTo().defaultContent();
		switchToFrame(frame_legacyContainer, frame_RootPeople, frame_qfHomeResultsFrame, lFirstSearchResult);
	}

	public void swithToRecentHystory() {
		switchToFrame(frame_legacyContainer, frame_RootPeople, hRecentHistory);
	}

	public void swithToRootPeople() {
		switchTo().defaultContent();
		switchTo().frame("legacyContainer");
		switchTo().frame("tabframe-root-_S_PEOPLE");
	}

	public SelenideElement lFirstSearchResult() {
		return $(lFirstSearchResult);
	}

	public SelenideElem lFirstSearchResult2() {
		return new SelenideElem(lFirstSearchResult);
	}

	public SelenideElement bAddToFavourites() {
		return $(bAddToFavourites);
	}

	public SelenideElement bDelToFavourites() {
		return $(bDelToFavourites);
	}

	public SelenideElement hMainHeader() {
		return $(hMainHeader);
	}

	public SelenideElement bFind() {
		return $(bFind);
	}

	public SelenideElement chCandidate() {
		return $(chCandidate);
	}

	public SelenideElement frame_roleSearchFrame() {
		return $("#roleSearchFrame");
	}

	public SelenideElement frame_S_PEOPLE() {
		return $(frame_RootPeople);
	}
	
	//added by kp 22.01.2019
	public SelenideElement bCreateCand () {
		return $(bCreateCand);
	}

}