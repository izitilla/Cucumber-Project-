package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	public WebElement inputEmainBox;
	
	@FindBy(xpath="//input[@id='input-password']")
	public WebElement inputPasswordBox;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement loginButton;
	
	
	
	public void assertLoginFeatures() {
		Assert.assertTrue(inputEmainBox.isDisplayed());
		Assert.assertTrue(inputPasswordBox.isDisplayed());
		Assert.assertTrue(loginButton.isDisplayed());
	}
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	public WebElement errorMessage;
	
	@FindBy(xpath="//a[text()='Forgotten Password']")
	public WebElement forgotPasswordLink;
	
}
