package Utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	// singleton class
	
		private static WebDriver driver;
		
		
		public static WebDriver getDriver() {
			
			if(driver==null) {
			
			switch(BaseClass.getProperty("browser")) {		
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "safari":
				if(!System.getProperty("os.name").toLowerCase().contains("mac")) {
					throw new WebDriverException("Your OS doesn't support Safari");
				}
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			case "edge":
				if(!System.getProperty("os.name").toLowerCase().contains("windows")) {
					throw new WebDriverException("Your OS doesn't support Edge");
				}
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "opera":
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				break;		
			}
			driver.get(BaseClass.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constants.implicit_wait_time, TimeUnit.SECONDS);
			PageInitializer.initialize();
		}
			return driver;
		}
		
		
		public static void tearDown() {
			if(BaseClass.getDriver() != null) {
				BaseClass.getDriver().close();
				BaseClass.getDriver().quit();
				driver = null;
			}
		}
		
		// declare properties file
		private static Properties configFile;
		// get 1stConfigFile.properties
		
		static {
			try {
				// config reader function
				String filePath =  Constants.configProperty_filePath;
				// open a connection to a file
				FileInputStream inputStream = new FileInputStream(filePath);
				
				// initializing config file to a Properties data type
				configFile = new Properties();
				// load config file
				configFile.load(inputStream);
				inputStream.close();		
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static String getProperty(String keyName) {
			return configFile.getProperty(keyName);
		}
}
