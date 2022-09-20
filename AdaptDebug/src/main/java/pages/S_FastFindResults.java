package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import _helpers.MySoftAssert;

public class S_FastFindResults {

	private By	iconFirstRowFav				= By.xpath(".//*[@id='38093256920556']//div[@class='sprite_image_path addToFavIcon']");
	private By	iconFirstRowDel				= By.xpath(".//*[@id='38093256920556']//div[@id='deleteDiv_0']");
	private By	iconFirstRowShortCut		= By.xpath(".//*[@id='38093256920556']//div[@id='wfImg_0_6920556']");
	private By	iconCandidateMinus			= By.xpath(".//table[@id ='roleTable6920556']//div[@class='sprite_image_path minusIcon']");
	private By	iconCandidatePlus			= By.xpath(".//table[@id ='roleTable6920556']//div[@class='sprite_image_path plusIcon']");
	private By	header						= By.cssSelector("#modalHeading");
	private By	tCandidate_plus				= By.xpath(".//table[@id = 'roleTable6920556']//div[@id='img_6920556']");
	private By	tCandidate_collapse			= By.xpath(".//table[@id = 'roleTable6920556']//div[@class='sprite_image_path minusIcon']");
	private By	tCandidate					= By.cssSelector("#roleTable6920556");
	private By	tContact					= By.cssSelector("#roleTable111");
	private By	tSupplierCandidate			= By.cssSelector("#roleTable6920887");
	private By	tSupplierContact			= By.cssSelector("#roleTable6920888");
	private By	tClient						= By.cssSelector("#roleTable116");
	private By	tProspect					= By.cssSelector("#roleTable140545");
	private By	tLead						= By.cssSelector("#roleTable6920714");
	private By	tSupplier					= By.cssSelector("#roleTable6920879");
	private By	tContractJob				= By.cssSelector("#roleTable6920557");
	private By	tContractJobOpportunity		= By.cssSelector("#roleTable6920585");
	private By	tDirectJob					= By.cssSelector("#roleTable120");
	private By	tContractAssignment			= By.cssSelector("#roleTable6920558");
	private By	tDirectPlacement			= By.cssSelector("#roleTable123");
	private By	bClose						= By.cssSelector("#closeButton");
	private By	lFirstCandidateTableName	= By.xpath(".//table[@id ='table_6920556']//tr[@class='clsRow'][1]//span");
	private By	lFirstCandidateTableAddFav	= By.xpath(".//table[@id ='table_6920556']//tr[@class='clsRow'][1]//div[@class='sprite_image_path addToFavIcon']");
	private By	lFirstCandidateTableDelFav	= By.xpath(".//table[@id ='table_6920556']//tr[@class='clsRow'][1]//div[@class='sprite_image_path delFromFavIcon']");
	private By	lWF							= By.xpath(".//table[@id ='table_6920556']//tr[@class='clsRow'][1]//div[@id='wfImg_0_6920556']");
	private By	lLogCall					= By.xpath(".//div[@id='_wf_0_6920556']//*[@class='menu_margin'][text()='Log a Call']");

	public SelenideElement lLogCall() {
		return $(lLogCall);
	}

	public SelenideElement lWF() {
		return $(lWF);
	}

	public SelenideElement tCandidate_collapse() {
		return $(tCandidate_collapse);
	}

	public SelenideElement lFirstCandidateTableName() {
		return $(lFirstCandidateTableName);
	}

	public SelenideElement lFirstCandidateTableAddFav() {
		return $(lFirstCandidateTableAddFav);
	}

	public SelenideElement lFirstCandidateTableDelFav() {
		return $(lFirstCandidateTableDelFav);
	}

	public SelenideElement bClose() {
		return $(bClose);
	}

	public SelenideElement tContact() {
		return $(tContact);
	}

	public SelenideElement tSupplierCandidate() {
		return $(tSupplierCandidate);
	}

	public SelenideElement tSupplierContact() {
		return $(tSupplierContact);
	}

	public SelenideElement tClient() {
		return $(tClient);
	}

	public SelenideElement tProspect() {
		return $(tProspect);
	}

	public SelenideElement tLead() {
		return $(tLead);
	}

	public SelenideElement tSupplier() {
		return $(tSupplier);
	}

	public SelenideElement tContractJob() {
		return $(tContractJob);
	}

	public SelenideElement tContractJobOpportunity() {
		return $(tContractJobOpportunity);
	}

	public SelenideElement tDirectJob() {
		return $(tDirectJob);
	}

	public SelenideElement tContractAssignment() {
		return $(tContractAssignment);
	}

	public SelenideElement tDirectPlacement() {
		return $(tDirectPlacement);
	}

	public SelenideElement tCandidate_plus() {
		return $(tCandidate_plus);
	}

	public SelenideElement tCandidate() {
		return $(tCandidate);
	}

	public SelenideElement header() {
		return $(header);
	}

	public SelenideElement iconCandidatePlus() {
		return $(iconCandidatePlus);
	}

	public SelenideElement iconCandidateMinus() {
		return $(iconCandidateMinus);
	}

	public SelenideElement iconFirstRowFav() {
		return $(iconFirstRowFav).shouldBe(exist);
	}

	public SelenideElement iconFirstRowDel() {
		return $(iconFirstRowDel).shouldBe(exist);
	}

	public SelenideElement iconFirstRowShortCut() {
		return $(iconFirstRowShortCut).shouldBe(exist);
	}

	public void tCandidateExpand() {
		if (!tCandidate_collapse().is(exist)) {
			tCandidate_plus().click();
		} else {
			System.out.println("Candidate tap already expanded");
		}

	}

	public void verifyResultsTabsHeaders(MySoftAssert softAssert, String... headers) {
		List<SelenideElement> listHeaders = $$(By.xpath(".//tbody//b"));
		for (int i = 0; i < listHeaders.size(); i++) {
			softAssert.assertEquals(listHeaders.get(i).getText(), headers[i], "header: ");
		}
	}

}
