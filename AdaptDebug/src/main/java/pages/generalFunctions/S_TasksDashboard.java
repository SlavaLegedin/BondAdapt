package pages.generalFunctions;

import _helpers.TestBase;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class S_TasksDashboard extends TestBase{
	
	
	public By ifTaskFrame				= By.xpath("");
	//top panel
	public By rbUserTask				= By.xpath("");
	public By ddlUserList				= By.xpath("");
	public By rbGroupTask				= By.xpath("");
	
	public By bReschedule				= By.xpath("");
	public By ddlReschedule				= By.xpath("");
	public By bComplete					= By.xpath("");
	public By bBatchMenu				= By.xpath("");
	
	public By bAdd						= By.xpath("");
	public By bReformat					= By.xpath("");
	public By bRefresh					= By.xpath("");
	public By bFilter					= By.xpath("");
	
	
	//bottom panel
	
	
	//initialization
	SelenideElement rbUserTask() {
		return $(rbUserTask);
	}

}
