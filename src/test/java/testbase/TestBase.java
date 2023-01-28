package testbase;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String getbrowser;
	public static WebDriver getInstance() throws IOException
	{
	
		String file="./src/main/java/config/config.properties";
		FileInputStream instream=new FileInputStream(new File(file));
		prop= new Properties();
		prop.load(instream);
		getbrowser=prop.getProperty("browser");
		System.out.println(getbrowser);
		
		if(getbrowser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
		driver = new ChromeDriver();
		}
		else if(getbrowser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoagent"));
			driver = new FirefoxDriver();	
			
		}
		else if(getbrowser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgeagent"));
			driver = new EdgeDriver();
		}else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		//driver.manage().window().setSize(new Dimension(820,1180));
		//driver.manage().window().setPosition(new Point(100,100));
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//implicit wait
		return driver;
	}
}
