package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;
import Utilities.commonMethods;

public class SplashPage {

	public SplashPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath="//li[@class='nav-item dropdown dropdown-hoverable']//span[contains(text(),'My account')]")
	public WebElement myAccountButton;
	
	@FindBy(xpath="//ul[@class='mz-sub-menu-96 dropdown-menu show']//span[contains(text(),'Login')]")
	public WebElement loginInDropDown;
	
	@FindBy(xpath="//ul[@class='mz-sub-menu-96 dropdown-menu']//span[contains(text(),'Register')]")
	public WebElement registerInDropDown;
	
	@FindBy(xpath="//ul[@class='mz-sub-menu-96 dropdown-menu show']/li[6]")
	public WebElement logoutInDropDown;
	
	
	public void clickLoginLogoutOrRegister(String option) {
		commonMethods.hoverOverMouse(myAccountButton);
		if(option.equalsIgnoreCase("Login")) {
			commonMethods.click(loginInDropDown);
		}else if(option.equalsIgnoreCase("Logout")) {
			commonMethods.click(logoutInDropDown);
		}else {
			commonMethods.click(registerInDropDown);
		}
	}
}
