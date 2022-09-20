package _helpers;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideTargetLocator;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.testng.TextReport;

import pages.S_LogIn;

@Listeners({ SoftAsserts.class, TextReport.class })
public class TestBase {
	protected PropsReader	config				= new PropsReader("config.properties");
	protected PropsReader	variablesProp		= new PropsReader("variables.properties");
	protected MySoftAssert	softAssert			= new MySoftAssert();
	protected Timing		time				= new Timing();
	protected WebDriver		driver				= null;
 
	@BeforeSuite
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws MalformedURLException, InterruptedException {
		if (browser.equalsIgnoreCase("chrome")) {
			Configuration.timeout = 15000;

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--disable-infobars");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--user-data-dir=" + config.getChromeProfile());
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver(chromeOptions);
			WebDriverRunner.setWebDriver(driver);
			open(config.getUrl());
			try {
				Configuration.assertionMode = AssertionMode.STRICT;
				new S_LogIn().logIn(config.getUserName(), config.getUserPassword());
			} catch (Exception e) {
			} finally {
				Configuration.assertionMode = AssertionMode.SOFT;
			}
			Thread.sleep(15000);
		} else if (browser.equalsIgnoreCase("firefox")) {
			Configuration.timeout = 5000;
			System.setProperty("webdriver.gecko.driver", "D:\\WorkSpace2\\PheonUix\\src\\main\\resources\\geckodriver.exe");
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.addArguments("--start-maximized");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			WebDriverRunner.setWebDriver(driver);
			open(config.getUrl());
		} else if (browser.equalsIgnoreCase("ie")) {
			Configuration.timeout = 5000;
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), ieOptions);
			driver.manage().window().maximize();
			WebDriverRunner.setWebDriver(driver);
			open(config.getUrl());

		} else if (browser.equalsIgnoreCase("edge")) {
			Configuration.timeout = 5000;
			EdgeOptions eOptions = new EdgeOptions();
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), eOptions);
			driver.manage().window().maximize();
			WebDriverRunner.setWebDriver(driver);
			open(config.getUrl());
		}

	}

	@AfterSuite
	public void tearDown() {
		WebDriverRunner.closeWebDriver();
	}

	public void sendKeysDely(SelenideElement element, String text) {
		element.shouldBe(exist).clear();
		for (char a : text.toCharArray()) {

			try {
				element.sendKeys(String.valueOf(a));
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isElementPresent(By by) {
		try {
			$(by).should(exist);
			return true;
		} catch (ElementNotFound e) {
			return false;
		}
	}

	public boolean isElementNotPresent(By by) {
		try {
			$(by).shouldNot(exist);
			return true;
		} catch (ElementNotFound e) {
			return false;
		}
	}

	public void waitPage(int dely) {
		try {
			int del = dely * 1000;
			Thread.sleep(del);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void switchToFrame(By iframe, By element)  {
		int i = 0;
		while (!$(element).is(exist) && i < 150) {
			i++;
			switchTo().defaultContent();
			switchTo().frame($(iframe));
		}
	}

	
	public void switchToFrame(By iframe, By iframe2, By element) {
		int i = 0;
		while (!$(element).is(exist) && i < 150) {
			i++;
			switchTo().defaultContent();
			switchTo().frame($(iframe));
			switchTo().frame($(iframe2));
		}
	}

	public void switchToFrame(By iframe, By iframe2, By iframe3, By element) {
		int i = 0;
		while (!$(element).is(exist) && i < 150) {
			i++;
			switchTo().defaultContent();
			switchTo().frame($(iframe));
			switchTo().frame($(iframe2));
			switchTo().frame($(iframe3));
		}
	}

	public SelenideElement frameLegacyContainer() {
		return $("#legacyContainer");
	}

	public SelenideElement frameStudioCaptionFrame() {
		return $("#studioCaptionFrame");
	}

	public void waitAdaptLoad() {
		frameLegacyContainer().should(exist);
		Selenide.switchTo().frame(frameLegacyContainer());
		frameStudioCaptionFrame().should(exist);
		Selenide.switchTo().frame(frameStudioCaptionFrame());
		Selenide.switchTo().defaultContent();
	}

	public SelenideTargetLocator switchTo() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Selenide.switchTo();
	}

//	public TargetLocator switchTo() {
//	    return driver.switchTo();
//	}
}
