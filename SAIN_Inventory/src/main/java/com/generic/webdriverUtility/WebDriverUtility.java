package com.generic.webdriverUtility;

/**
 * Contains WebDriver reusable actions
 * @author Rajani
 */
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * wait for specified duration
	 * 
	 * @param driver
	 */
	// Implicitly wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	/**
	 * Wait for element visibility
	 * 
	 * @param driver
	 * @param element
	 */
	// explicit wait
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait for element tobe clickable
	 * @param driver
	 * @param element
	 */
	// explicit wait
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * To launch the specified browser
	 * @param browser
	 * @return
	 */
	// launch browser
	public WebDriver launchBrowser(String browser) {
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		return driver;
	}

	/**
	 * Switch the window based on URL of the page
	 * @param driver
	 * @param partialUrl
	 */
	// switch window based by URL
	public void switchToWindowOnURL(WebDriver driver, String partialUrl) {
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> iterate1 = allWin1.iterator();
		while (iterate1.hasNext()) {
			String win = iterate1.next();
			driver.switchTo().window(win);

			String winUrl = driver.getCurrentUrl();
			if (winUrl.contains(partialUrl)) {
				break;
			}
		}
	}

	/**
	 * Switch the window based on title of the page
	 * @param driver
	 * @param partialTitle
	 */
	// switch window based by title
	public void switchToWindowOnTitle(WebDriver driver, String partialTitle) {
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> iterate1 = allWin1.iterator();
		while (iterate1.hasNext()) {
			String win = iterate1.next();
			driver.switchTo().window(win);

			String winUrl = driver.getTitle();
			if (winUrl.contains(partialTitle)) {
				break;
			}
		}
	}

	/**
	 * Switch the frame based on index
	 * @param driver
	 * @param index
	 */
	// switch to frame by index
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * Switch the frame based on name
	 * @param driver
	 * @param name
	 */
	// switch to frame by name
	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * Switch the frame based on element
	 * @param driver
	 * @param element
	 */
	// switch to frame by WebElement
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * Switch the alert and accept
	 * @param driver
	 */
	// switch to alert and accept
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Switch the alert and dismiss
	 * @param driver
	 */
	// switch to alert and dismiss
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Switch the alert, enter the data and accept
	 * @param driver
	 * @param value
	 */
	// send value to alert
	public void enterValueToAlertAndAccept(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);// pass input
		driver.switchTo().alert().accept();
	}

	/**
	 * select value from the dropdown based on visible text
	 * @param element
	 * @param visibleText
	 */
	// select by visible text
	public void select(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * select value from the dropdown based on value attribute
	 * @param element
	 * @param value
	 */
	// select by value
	public void selectFromValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * select value from the dropdown based on index
	 * @param element
	 * @param index
	 */
	// select by index
	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * Move the cursor to specified element
	 * @param driver
	 * @param element
	 */
	// mouse over
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * Move the cursor to specified element and click
	 * @param driver
	 * @param element
	 */
	// mouse over and click
	public void mouseOverAndClickOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}

	/**
	 * Move the cursor to specified element and click
	 * @param driver
	 * @param element
	 */
	// mouse click
	public void mouseClickOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	/**
	 * Move the cursor to specified element and double click on the element
	 * @param driver
	 * @param element
	 */
	// double click
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * Mouse action to drag and drop
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	// drag and drop
	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions act = new Actions(driver);
		act.clickAndHold(drag).release(drop).perform();
		// or
		// act.dragAndDrop(drag, drop).perform();
	}

	/**
	 * Move the cursor to specified element and right click on the element
	 * @param driver
	 * @param element
	 */
	// mouse right click(context click)
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * Takes screenshot of the web page
	 * @param driver
	 * @param filePathWithName
	 * @throws Throwable
	 */
	// taking screenshot
	public void takepageScreenshot(WebDriver driver, String filePathWithName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(filePathWithName);
		FileUtils.copyFile(src, dest);
	}

	/**
	 * scrolls to specified element
	 * @param driver
	 * @param element
	 * @throws Throwable
	 */
	// scroll to element
	public void scrollToElementAndClickJS(WebDriver driver, WebElement element) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy("+element.getRect().getX()+","+element.getLocation().getY()+")");
		js.executeScript("arguments[0].scrollIntoView()", element);

		Thread.sleep(2000);
		element.click();
	}

	/**
	 * disbale notification alert for chrome browser
	 * @return
	 */
	// disable notification
	public WebDriver disableNotificationForChrome() {
		ChromeOptions cOpt = new ChromeOptions();
		cOpt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(cOpt);
		return driver;
	}

	/**
	 * closes the browser
	 * @param driver
	 */
	// close browser
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * maximizes the browser
	 * @param driver
	 */
	// maximize browser
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * minimizes the browser
	 * @param driver
	 */
	// minimize browser
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * refreshes the page
	 * @param driver
	 */
	// refresh page
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	/**
	 * go to forward page
	 * @param driver
	 */
	// forwardPage
	public void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	/**
	 * go to previous page
	 * @param driver
	 */
	// previousPage
	public void previousPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void sendKeysUsingAction(WebDriver driver, WebElement element, String value) {
		Actions act=new Actions(driver);
		act.sendKeys(element, value).perform();
	}

}
