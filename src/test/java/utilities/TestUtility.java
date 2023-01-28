package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase {

	public static void scrollToElement(WebElement ele)
	{
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", ele); //default value as True
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
	}

	public static void clickOnElementJS(WebElement ele)
	{
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele); //default value as True
	}
	
	public static void waitForElementClickable(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); //Explicit Wait
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForElementVisible(WebElement ele)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); //Explicit Wait
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void captureScreenshot() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(getDate()+"_image.png"));
	}
	
	public static void attachScreenshot() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		String file = ts.getScreenshotAs(OutputType.BASE64);
		String str = "<img src=\"data:image/png;base64," + file + "\" height=\"600\" width=\"800\" />";
		Reporter.log(str);
	}
	public static String getDate()
	{
		Date dt = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("Y_MMM_dd_HH_mm_ss_SSS");
		String s = sdf.format(dt);
		System.out.println(s);
		return s;
	}
}
