package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class commonMethods extends PageInitializer{

	public static void sendKey(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void paolaWait(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void TINY_WAIT() {
		try {
			Thread.sleep(1000*1);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void SMALL_WAIT() {
		try {
			Thread.sleep(1000*5);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void MEDIUM_WAIT() {
		try {
			Thread.sleep(1000*15);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void LARGE_WAIT() {
		try {
			Thread.sleep(1000*30);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void EXTRA_LARGE_WAIT() {
		try {
			Thread.sleep(1000*60);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void MAJOR_WAIT() {
		try {
			Thread.sleep(1000*120);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void HUGE_WAIT() {
		try {
			Thread.sleep(1000*360);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void ULTIMATE_WAIT() {
		try {
			Thread.sleep(1000*600);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void clickRadioOrCheckbox(List<WebElement> radioOrChekbox, String value) {
		String actualValue;
		for (WebElement eachElement : radioOrChekbox) {
			actualValue = eachElement.getText();
			if (eachElement.isEnabled() && actualValue.equals(value)) {
				eachElement.click();
				break;
			}
		}
	}

	// select drop downs
	public static void selectDropDownByVisibleText(WebElement element, String textToSelect) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement eachOption : options) {
				if (eachOption.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	
	public static void selectDropDownByIndex(WebElement element, int indexToSelect) {
		   try {
		        Select select = new Select(element); // Creating a Select object to interact with dropdown
		        select.selectByIndex(indexToSelect); // Selecting by index
		    } catch (UnexpectedTagNameException e) {
		        e.printStackTrace(); // This exception is thrown if the WebElement is not <select>
		    } catch (IndexOutOfBoundsException e) {
		        e.printStackTrace(); // This exception is thrown if the index is out of bounds of the option list size
		    }
	}
	
	// alerts
	public static void acceptAlert() {
		try {
		Alert alert = BaseClass.getDriver().switchTo().alert();
		alert.accept();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	public static void dismissAlert(WebDriver driver) {
	    try {
	        Alert alert = driver.switchTo().alert(); // Switch to the alert
	        alert.dismiss(); // Dismiss the alert (clicks the 'Cancel' button)
	    } catch (NoAlertPresentException e) {
	        System.out.println("No alert present to dismiss."); // Handle case where no alert is present
	    } catch (WebDriverException e) {
	        System.out.println("WebDriver error occurred while trying to dismiss alert: " + e.getMessage());
	    }
	}
	
	public static void alertGetText(WebDriver driver) {
	    try {
	        Alert alert = driver.switchTo().alert(); // Switch to the alert
	        String alertText = alert.getText(); // Get the text of the alert
	        System.out.println("Alert text is: " + alertText); // Print the alert text
	    } catch (NoAlertPresentException e) {
	        System.out.println("No alert present to get text from."); // Handle case where no alert is present
	    } catch (WebDriverException e) {
	        System.out.println("WebDriver error occurred while trying to get text from alert: " + e.getMessage());
	    }
	}
	
	// switching iframe by index
	public static void switchToIFrameByIndex(int iFrameIndex) {
			try {
				BaseClass.getDriver().switchTo().frame(iFrameIndex);
			}catch(NoSuchFrameException e) {
				e.printStackTrace();
			}
	}
	
	public static void switchToIFrameByElement(WebElement iFrameElement) {
		   try {
		        BaseClass.getDriver().switchTo().frame(iFrameElement); // Switch to the iframe using the WebElement	       
		    } catch (WebDriverException e) {
		        e.printStackTrace();
		    }
	}
	
	public static void switchToIFrameByName(String iframeName) {
	    try {
	        BaseClass.getDriver().switchTo().frame(iframeName); // Switch to the iframe using its name
	    } catch (NoSuchFrameException e) {
	       e.printStackTrace();
	    } catch (WebDriverException e) {
	        System.out.println("WebDriver error occurred while trying to switch to iframe: " + e.getMessage());
	    }
	}
	
	// switch to child window
	// The user should have already opened or have clicked a link where a new tab/window opened
	public static void switchToChildWindow(String parentWindowHandle) {
		try {
			//get all window handles
			Set<String> windowHandles = BaseClass.getDriver().getWindowHandles();
			//switch to the child window
			for(String handle : windowHandles) {
				if(!handle.equals(parentWindowHandle)) {
					BaseClass.getDriver().switchTo().window(handle);
					break;
				}
			}
		}catch(Exception e) {
			System.out.println("Exception occured while switching to child window " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(),Constants.explicit_wait_time);
		return wait;		
	}
	
	public static WebElement waitForClickability(WebElement element) {		
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}
	
	public static void sendKeyDynamically(String keys, WebElement element) {
		waitForVisibility(element).sendKeys(keys);
	}
	
	public static void hoverOverMouse(WebElement element) {
		Actions action = new Actions(BaseClass.getDriver());
		action.moveToElement(element).build().perform();
	}
	
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(BaseClass.getDriver());
		action.dragAndDrop(source, target).build().perform();
	}
	
	public static void doubleClick(WebElement element) {
		Actions action = new Actions(BaseClass.getDriver());
		action.doubleClick(element).build().perform();
	}
	
	public static void takeScreenShot(WebDriver driver) {
		try {
		//create object of simple date format class and decide format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		//get the current date time with local date time
		LocalDateTime now = LocalDateTime.now();
		//convert the date into the string with the specified format
		String dateString = now.format(formatter);
		//casting webDriver to takescreenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		//get the screenshot as an output file
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		//defind destination path with the unique name
		String destFilePath = "src/test/resources/screenshots/eachScreenShot"+dateString+".png";
		
		File destFile = new File(destFilePath);
		// use the fileUtils to copy the screenshot to the destination
		FileUtils.copyFile(srcFile, destFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("argument[0].scrollIntoView(true)", element);
	}
	
	public static String generateEmail() {		
		FakeValuesService fakeValuesService = new FakeValuesService(
			      new Locale("en-GB"), new RandomService());		  		 
			    return fakeValuesService.bothify("????##@gmail.com");
	}
	
	public static Faker getFakerObject() {
		Faker faker = new Faker();
		return faker;
	}
	
	public static String generateAddress() {
		Faker faker = new Faker();

		String streetName = getFakerObject().address().streetName();
		String number = getFakerObject().address().buildingNumber();
		String city = getFakerObject().address().city();
		String country = getFakerObject().address().country();

		return String.format("%s\n%s\n%s\n%s",
		  number,
		  streetName,
		  city,
		  country);
	}
	
	public static String generateBeer() {
		return getFakerObject().beer().name();
	}
	
	public static String chuckNorriesFact() {
		return getFakerObject().chuckNorris().fact();
	}
}
