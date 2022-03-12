package org.test.testnng.base;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

public static WebDriver driver;

public static void browser(String Browsername) {
	switch(Browsername) {
	case"chrome":
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();
		break;
	case"edge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		default:
			System.out.println("Invalid Browser");
	}

}
public static void browserLaunch(String browsername) {
	if(browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}else if(browsername.equalsIgnoreCase("edge")){
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
	}

}
	
public static void chromeLaunch() {
	WebDriverManager.chromedriver().setup();
	 driver =new ChromeDriver();  
}
public static void urlLaunch(String url) {
	driver.get(url);
	driver.manage().window().maximize();

}
public static  void sendKeys(WebElement e,String data) {
	e.sendKeys(data);
}
public static void click(WebElement e) {
	e.click();

}
public static String getUrl() {
	 String title = driver.getTitle();
	 return title;
}
public static String getCurrentUrl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
}
public static void impWait(int sec) {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
public static void staticWait(int millie) throws InterruptedException {
	Thread.sleep(millie);
}
public static void quitBrowser() {
	driver.quit();

}
public static WebDriver switchToWindowIds(int index) {
	Set<String> st = driver.getWindowHandles();
	List<String> li=new ArrayList();
    li.addAll(st);
    WebDriver window = driver.switchTo().window(li.get(index));
	return window;

}
public static  void switchToWindowUrl( String getUrl ) {
     driver.switchTo().window(getUrl);
}
public static void switchToWindowTitle(String title) {
	driver.switchTo().window(title);

}
public static String getText(WebElement e) {
	return e.getText();
}
public static String getAttribute(WebElement b) {
return b.getAttribute("value");

}
public static void moveToElement(WebElement e) {
	Actions a=new Actions(driver);
	a.moveToElement(e).perform();
	
}
public static void drogAndDrop(WebElement from,WebElement to) {
	Actions a=new Actions(driver);
a.dragAndDrop(from,to).perform();
}
public static void contextClick(WebElement e) {
		Actions a=new Actions(driver);
     a.contextClick(e).perform();
}
public static void doubleClick(WebElement e) {
	 Actions a=new Actions(driver);
	 a.doubleClick(e).perform();
}
public static void clickAndHoldRelease(WebElement from,WebElement to) {
	 Actions a=new Actions(driver);
	 a.clickAndHold(from).release(to).perform();
}
public static void clickHoldAndMoveToRelease(WebElement from,WebElement to) {
	 Actions a=new Actions(driver);
	 a.clickAndHold(from).moveToElement(to).release().perform();

}public static void clickAct(WebElement e) {
	 Actions a=new Actions(driver);
     a.click(e).perform();
}
public static void selectByIndex(WebElement e,int index) {
	 Select s=new Select(e);
     s.selectByIndex(index);
}
public static void selectByValue(WebElement e,String value) {
	 Select s=new Select(e);
	 s.selectByValue(value);
}
public static void SelectByText(WebElement e,String text) {
	 Select s=new Select(e);
	 s.selectByVisibleText(text);

}

public static List<String> getOptions(WebElement e) {
	 Select s=new Select(e);
	 List<WebElement> options = s.getOptions();
	 for(int i=0;i<options.size();i++) {
		 WebElement we = options.get(i);
		 String text = we.getText();
	 }
	return null;

	

}
public static void deSelectAll(WebElement e) {
	 Select s=new Select(e);
	s.deselectAll(); 

}
public static void deSelectByIndex(WebElement e,int Index) {
	 Select s=new Select(e);
	s.deselectByIndex(Index);

}
public static void deSelectByValue(WebElement e,String value) {
	 Select s=new Select(e);
	s.deselectByValue(value);

}
public static String getFirstSelectedOption(WebElement e,String value) {
	 Select s=new Select(e);
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	String attribute = firstSelectedOption.getAttribute(value);
	return attribute;
}
public static void deSelectByText(WebElement e,String text) {
	 Select s=new Select(e);
	 s.deselectByVisibleText(text);
}
public static boolean isMultiple(WebElement e) {
	 Select s=new Select(e);
boolean multiple = s.isMultiple();
return multiple;
}
public static  void simpleAlert() {
	Alert alert = driver.switchTo().alert();
	alert.accept();
}
public static void confirmAlert() {
	Alert alert = driver.switchTo().alert();
	alert.dismiss();

}
public static Alert promptAlert(String data) {
	Alert alert = driver.switchTo().alert();
	alert.sendKeys(data);
	alert.accept();
	return alert;
}
 public static void switchToFrameIndex(int index) {
	   driver.switchTo().frame(index);
}
 public static void switchToDefaultContent() {
	driver.switchTo().defaultContent();
 }
 public static void switchToFrameId(String idandname) {
	  driver.switchTo().frame(idandname);
}
 public static void switchToFrameWebElement(WebElement e) {
	  driver.switchTo().frame(e);

}
public static String takeScreenShot(String filename) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File from= ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(from, new File("D:\\New folder\\SeleniumDriver\\src\\library\\new\\"+filename+".png"));
	return filename;
	
}
public static void scrollDown(WebElement e) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true)", e);
}
public static void javaScriptClick(WebElement e) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click()", e);
}
public static void scrollUp(WebElement e) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(false)", e);
	
}public static Object jsSendKeys(WebElement e,String data) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Object executeScript = js.executeScript("arguments[0].setAttribute('value','"+data+"')" ,e);
	return executeScript;
	
}
public static Object jsGetAttribute(WebElement e) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Object executeScript = js.executeScript("return arguments[0].getAttribute('value')",e );
	return executeScript;

}
public static void EnterKey() throws AWTException {
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
    r.keyRelease(KeyEvent.VK_ENTER);
}	
public static void DownArrow(int index) throws AWTException {
	Robot r=new Robot();
	for(int i=0;i<index;i++) {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
}
//public static String excel(String filename,String Sheetname,int row,int cel) throws IOException {
//File li=new File("D:\\New folder\\Mavenn\\src\\test\\resources\\"+filename+".xlsx");
//	
//	FileInputStream fi=new FileInputStream(li);
//	
//	Workbook w=new XSSFWorkbook(fi);
//	
//	Sheet sheet = w.getSheet(Sheetname);
//	Row r = sheet.getRow(row);
//	Cell cell = r.getCell(cel);
////	String Value = cell.getStringCellValue();
////	System.out.println(Value);
//	int Type = cell.getCellType();
//	String value=null;
//	if(Type==1) {
//		 value = cell.getStringCellValue();
//	
//	}else {
//		if(DateUtil.isCellDateFormatted(cell)) {
//			Date dd= cell.getDateCellValue();
//			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
//			value = sf.format(dd);
//		
//		}else {
//			double ss = cell.getNumericCellValue();
//			Long s= (long) ss;
//			 value= String.valueOf(s);
//			
//		}
//	}
//	return value;
} 


    
    




