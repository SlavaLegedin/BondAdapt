package pages;import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
public class M_configurations {
private By lControlPanelSettings = By.xpath("");
private By lPrinter = By.xpath("");
private By lLanguage = By.xpath("");
private By lPassword = By.xpath("");
private By lView Mode = By.xpath("");
private By lProfile = By.xpath("");
private By lInstallers = By.xpath("");
private By lMyDetails = By.xpath("");
private By lEmailSignature = By.xpath("");
 public SelenideElement lControlPanelSettings(){
        return $(lControlPanelSettings);}
 public SelenideElement lPrinter(){
        return $(lPrinter);}
 public SelenideElement lLanguage(){
        return $(lLanguage);}
 public SelenideElement lPassword(){
        return $(lPassword);}
 public SelenideElement lView Mode(){
        return $(lView Mode);}
 public SelenideElement lProfile(){
        return $(lProfile);}
 public SelenideElement lInstallers(){
        return $(lInstallers);}
 public SelenideElement lMyDetails(){
        return $(lMyDetails);}
 public SelenideElement lEmailSignature(){
        return $(lEmailSignature);}
}