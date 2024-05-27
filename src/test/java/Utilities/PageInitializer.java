package Utilities;

import Pages.LoginPage;
import Pages.SplashPage;

public class PageInitializer extends BaseClass{

	public static SplashPage splashPage; 
	public static LoginPage loginPage;
	
	public static void initialize() {
		splashPage = new SplashPage();
		loginPage = new LoginPage();
	}
}
