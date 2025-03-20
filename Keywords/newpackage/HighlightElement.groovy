package newpackage

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.text.SimpleDateFormat
import java.util.Date
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.logging.KeywordLogger



public class HighlightElement {
	
	@Keyword
	def static void printWelcomeMessage() {
		println("Welcome to Katalon Studio Automation!")
	}
	
	@Keyword
	def static void clearCookies() {
		WebUI.deleteAllCookies()
		println("All browser cookies have been cleared.")
	}
	
	@Keyword
	def static void printMessage() {
		println("This is a custom keyword without parameters!")
	}
	
	@Keyword
	def static void closeBrowser() {
		WebUI.closeBrowser()
		println("Browser closed successfully.")
	}
	
	@Keyword
	def getTextFromElement(TestObject testObject) {
		return WebUI.getText(testObject)
	}
	
	@Keyword
	def generateRandomEmail() {
		int randomNum = (int) (Math.random() * 10000)
		return "user" + randomNum + "@testmail.com"
	}
	
	@Keyword
	def waitForElementAndClick(TestObject testObject, int timeout) {
		WebUI.waitForElementClickable(testObject, timeout)
		WebUI.click(testObject)
	}
	
	
	@Keyword
	def static boolean checkElementExists(String locator) {
		try {
			WebElement element = WebUI.findWebElement(locator)
			return element != null
		} catch (Exception e) {
			return false
		}
	}
	
	@Keyword
	def static void waitForElementVisible(String locator, int timeout) {
		WebUI.waitForElementVisible(locator, timeout)
	}
	
	@Keyword
	def static void scrollToElement(String locator) {
		WebElement element = WebUI.findWebElement(locator)
		WebUI.scrollToElement(element, 0)
	}
	@Keyword
	def static void enterTextIfEmpty(String locator, String text) {
		String currentValue = WebUI.getText(locator)
		if (currentValue.trim().isEmpty()) {
			WebUI.setText(locator, text)
		}
	}
	@Keyword
	def static void takeScreenshotWithTimestamp(String filePath) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
		String screenshotPath = filePath + "/screenshot_" + timestamp + ".png"
		WebUI.takeScreenshot(screenshotPath)
	}
	
	@Keyword
	def static void clickElementUsingJavaScript(String locator) {
		WebElement element = WebUI.findWebElement(locator)
		JavascriptExecutor js = (JavascriptExecutor) WebUI.getDriver()
		js.executeScript("arguments[0].click();", element)
	}
	
	@Keyword
	def static void verifyPageTitle(String expectedTitle) {
		String actualTitle = WebUI.getWindowTitle()
		assert actualTitle == expectedTitle : "Expected title: " + expectedTitle + " but got: " + actualTitle
	}
	@Keyword
	def static void verifyElementText(String locator, String expectedText) {
		String actualText = WebUI.getText(locator)
		assert actualText == expectedText : "Expected text: " + expectedText + " but got: " + actualText
	}
}