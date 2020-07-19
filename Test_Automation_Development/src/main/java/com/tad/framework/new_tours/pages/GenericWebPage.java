package com.tad.framework.new_tours.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edgehtml.EdgeHtmlDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class GenericWebPage {

	public static int stepId = 0;
	public static String result = null;
	public static String stepDesc = null;
	public static String PASS = "PASS", FAIL = "FAIL";
	public static ArrayList<String> resultArray = new ArrayList<String>();

	public static RemoteWebDriver driver = null;
	public static WebElement element = null;
	public static FluentWait<RemoteWebDriver> wait = null;

	/**
	 * 
	 */
	public static void main(String[] args) {

		GenericWebPage app = new GenericWebPage();
		try {
			app.laucnApp("firefox", "http://testleaf.herokuapp.com/home.html");

			HashMap<String, String> categories = new HashMap<String, String>();
			categories.put("Edit", "Work with Edit Fields");
			categories.put("Button", "Bond with Buttons");
			categories.put("HyperLink", "Play with HyperLinks");
			categories.put("Image", "Interact with Images");
			categories.put("Drop down", "Learn Listboxes");
			categories.put("Radio Button", "Play with Radio Buttons");
			categories.put("Checkbox", "Interact with Checkboxes");
			categories.put("Table", "Toy with Tables");
			categories.put("Alert", "Handle Alerts");
			categories.put("Frame", "Fun with frames");
			categories.put("Window", "Work with Windows");
			categories.put("Calendar", "Get Started With Calendars");
			for (String linkName : categories.keySet()) {
				app.findElement("xpath", "//*[contains(text(), '" + linkName + "')]");
				app.clickElement();

				app.verifyText(categories.get(linkName));
				app.takeScreenShot();

				app.findElement("xpath", "//a[contains(@href, 'home.html')]");
				app.clickElement();
				app.verifyText("Locators and Selenium Interactions");
				app.takeScreenShot();
			}
			
			app.findElement("xpath", "//*[contains(text(), 'Drop down')]");
			app.clickElement();
			app.selectListItem("Appium");
			app.takeScreenShot();

		} catch (Exception e) {
			app.printException(e, stepDesc);
		} finally {
			String finalResult = (resultArray.contains(FAIL) ? FAIL : PASS);
			app.closeApp();
			app.reportResult(finalResult, "=== Final Result ===");
		}

	}

	/**
	 * Use this method to launch the web application.
	 * 
	 * @param browser pass the value to choose the browser to automate the app
	 * @param url     pass the application url her.
	 */
	public void laucnApp(String browser, String url) throws Exception {
		stepDesc = "Launching web application: " + url;
		switch (browser) {
		case "chrome":
//			System.setProperty("webdriver.chorme.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
			driver = new EdgeHtmlDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			throw new InvalidArumentExceptions(browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait = new FluentWait<RemoteWebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5));

//		driver.switchTo().window(nameOrHandle);
		
		
		driver.get(url);
		reportResult(PASS, stepDesc);
	}

	/**
	 * Closes the browser
	 */
	public void closeApp() {
		driver.close();
	}

	/**
	 * finds the web element
	 * 
	 * @param locatorType id, css, class, link, tag, xpath
	 * @param url         pass the application url here.
	 */
	public void findElement(String locatorType, String locatorValue) throws Exception {
		stepDesc = "WebElement: [" + locatorType + ","+ locatorValue + "]";
		By by = null;
		switch (locatorType) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "css":
			by = By.cssSelector(locatorValue);
			break;
		case "class":
			by = By.className(locatorValue);
			break;
		case "link":

			// use of partial link text can address the dual requirements of link and
			// partial link
			by = By.partialLinkText(locatorValue);
			break;
		case "tag":
			by = By.tagName(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;
		default:
			throw new InvalidArumentExceptions(locatorType);
		}
		element = driver.findElement(by);
	}

	/**
	 * This method can be used to type text
	 * 
	 * @param fieldName  the label name of the field
	 * @param textToType text to be entered into the field
	 */
	public void typeText(String textToType) throws Exception {
		stepDesc = "Type text: '" + textToType + "'";
		element.sendKeys(textToType);
		reportResult(PASS, stepDesc);
	}

	public void clickElement() {
		stepDesc += " | Click on web element";
		element.click();
		reportResult(PASS, stepDesc);
	}

	public boolean isElementClickable() {
		stepDesc += " | Checking element clickable state";
		return (wait.until(ExpectedConditions.elementToBeClickable(element)) != null);
	}

	public boolean isElementEnabled() {
		stepDesc += " | Checking whether element enabled";
		return element.isEnabled();
	}

	public boolean isElementVisible() {
		stepDesc += " | Checking whether element visible";
		return element.isDisplayed();
	}

	public void selectListItem(String dropDownText) throws Exception {
		findElement("id", "dropdown1");
		stepDesc += " | Selecting dd option: '" + dropDownText + "'";
		Select dd = new Select(element);
		dd.selectByVisibleText(dropDownText);
		reportResult(PASS, stepDesc);
	}
	
	public void printException(Throwable e, String errorMessage) {
		stepDesc += "\tError: " + e.getMessage();
		reportResult(FAIL, stepDesc);
	}

	public void takeScreenShot() {
		String imageName = "" + System.currentTimeMillis() + "";
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("./target/" + imageName + ".png"));

		} catch (IOException e) {
			printException(e, "Failed to take Screen Shot: " + imageName);
		}

	}

	public void verifyText(String expText) throws Exception {
		findElement("xpath", "//*[contains(text(), '" + expText + "')]");
		stepDesc = "Verifying for text: '" + expText + "'";
		reportResult(PASS, stepDesc);
	}

	private void reportResult(String result, String stepDesc) {

		resultArray.add(result);

		String resultMsg = "[" + result + "]::" + stepDesc;

		if (result != PASS) {
			System.err.println(resultMsg);
		} else {
			System.out.println(resultMsg);
		}
	}

}

@SuppressWarnings("serial")
class InvalidArumentExceptions3 extends Exception {

	public InvalidArumentExceptions3(String argument) {
		super("Invalid Arugument: '" + argument + "'");
	}
}