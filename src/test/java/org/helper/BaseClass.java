package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	protected static WebDriver driver;
	static Alert alert;
	static JavascriptExecutor js;
	static TakesScreenshot ts;
	static Actions actions;
	static Robot robot;
	static Select select;
	static WebDriverWait wait;

	// browserLaunch
	public static void browserLaunch() {
		driver = new ChromeDriver();
	}

	// launchUrl
	public static void launchUrl(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}

	// pageTitle
	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	// currentUrl
	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// closeBrowserTab
	public static void closeBrowserTab() {
		driver.close();
	}

	// quitBrowser
	public static void quitBrowser() {
		driver.quit();
	}

	public WebElement elementClickableWait(WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	// textBoxValues
	public static void textBoxValues(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	// click
	public static void click(WebElement ele) {
		ele.click();
	}

	// getText
	public static String getText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	// getAttribute
	public static String getAttribute(WebElement ele, String value) {
		String attribute = ele.getAttribute(value);
		return attribute;
	}

	// switchAlert
	public static void switchAlert() {
		alert = driver.switchTo().alert();
	}

	// cancelAlert
	public static void dismiss() {
		alert.dismiss();
	}

	// okAlert
	public static void accept() {
		alert.accept();
	}

	// sendKeysJavaScriptExecutor
	public static void sendKeysJavaScriptExecutor(String value, WebElement ref) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + value + "')", ref);
		// js.executeScript("arguments[0].setAttribute('value','[1]')", value, ref);
	}

	// clickJavaScriptExecutor
	public static void clickJavaScriptExecutor(WebElement ref) {
		js.executeScript("arguments[0].click()", ref);
	}

	// getAttributeJavaScriptExecutor
	public static Object getAttributeJavaScriptExecutor(WebElement ref, String attributeName) {
		// String value="test value";
		Object o = js.executeScript("return arguments[0].getAttribute('" + attributeName + "')", ref);
		return o;
	}

	// scrollUp
	public static void scrollUp(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
	}

	// scrollDown
	public static void scrollDown(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	// screenShot
	public static void takeSnap(String name) throws IOException {
		ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\MavenProject2\\Screen\\" + "name" + ".png");
		FileUtils.copyFile(src, f);
	}

	// iframe using name
	public static void frame(String name) {
		driver.switchTo().frame(name);
	}

	// iframe using id
	public static void iframe(String id) {
		driver.switchTo().frame(id);
	}

	// iframe using Webelement ref
	public static void frame(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	// parentFrame
	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	// mouseHover
	public static void mouseHover(WebElement ele) {
		actions = new Actions(driver);
		actions.moveToElement(ele).perform();
	}

	// dragandDrop
	public static void dragandDrop(WebElement src, WebElement des) {
		actions.dragAndDrop(src, des).perform();
	}

	// doubleClick
	public static void doubleClick(WebElement ele) {
		actions.doubleClick(ele).perform();
	}

	// contextClick
	public static void contextClick(WebElement ele) {
		actions.contextClick(ele).perform();
	}

	// keyDown
	public static void keyDown(WebElement ele, CharSequence c) {
		actions.keyDown(ele, c).perform();
	}

	// keyUp
	public static void keyUp(WebElement ele, CharSequence c) {
		actions.keyDown(ele, c).perform();
	}

	// ControlC
	public static void copy() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
	}

	// ControlV
	public static void paste() throws AWTException {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	}

	// switchintowindowsHandling
	public static void switchwindows(String windowsID) {
		String parentId = driver.getWindowHandle();
		Set<String> AllwindowsId = driver.getWindowHandles();
		for (String eachId : AllwindowsId) {
			if (!eachId.equals(parentId)) {
				driver.switchTo().window(windowsID);
			}
		}
	}

	// dropDownByIndex
	public static void dropDownByIndex(WebElement ref, int index) {
		select = new Select(ref);
		select.selectByIndex(index);
	}

	// dropDownByVisibleText
	public static void dropDownByVisibleText(WebElement ref, String text) {
		select.selectByVisibleText(text);
	}

	// dropDownByValue
	public static void dropDownByValue(WebElement ref, String value) {
		select.selectByVisibleText(value);
	}

	// deselectByindex
	public static void deselectByindex(WebElement ele, int index) {
		select.deselectByIndex(index);
	}

	// deselectByVisibleText
	public static void deselectByVisibleText(WebElement ele, String text) {
		select.deselectByVisibleText(text);
	}

	// deselectByValue
	public static void deselectByValue(WebElement ele, String value) {
		select.deselectByValue(value);
	}

	// deselectAll
	public static void deselectAll(WebElement ele) {
		select.deselectAll();
	}

	// getOptions
	public static void getOptions(WebElement ele) {
		List<WebElement> allOptions = select.getOptions();
		for (WebElement options : allOptions) {
			String text = options.getText();
			System.out.println(text);
		}
	}

	// allSelectedOptions
	public static void allSelectedOptions(WebElement ele) {
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (WebElement alloptions : allSelectedOptions) {
			String text = alloptions.getText();
			System.out.println(text);
		}
	}

	// ismultiple
	public static boolean ismultipleDropdown(WebElement ele) {
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// firstSelectedOption
	public static String firstSelectedOption(WebElement ele) {
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}

	// excelsheet
	public static String getExcelData(int rowIndex, int cellIndex) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\FacebookCucumber\\Excel\\FaceBook.xlsx");
		FileInputStream fileInputStream = new FileInputStream(f);

		Workbook book = new XSSFWorkbook(fileInputStream);

		Sheet sheet = book.getSheet("FaceBook");

		Row row = sheet.getRow(rowIndex);

		Cell cell = row.getCell(cellIndex);

		int cellType = cell.getCellType();
		String data;
		if (cellType == 1) {
			data = cell.getStringCellValue();
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			data = String.valueOf(l);
		}
		return data;
	}

	// exceldataWrite
	public static void writeData(int rowIndex, int cellIndex, String sheetName, String value) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\DataDriven\\facebook\\FaceBook.xlsx");
		FileInputStream fileInputStream = new FileInputStream(f);

		Workbook book = new XSSFWorkbook(fileInputStream);
		Sheet sheet = book.getSheet(sheetName);

		Row row = sheet.getRow(rowIndex);
		Cell createCell = row.createCell(cellIndex);
		createCell.setCellValue(value);

		FileOutputStream fileOutputStream = new FileOutputStream(f);
		book.write(fileOutputStream);
	}
}
