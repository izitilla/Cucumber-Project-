package stepDefinitions;

import Pages.SplashPage;
import Utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

	SplashPage splashPage = new SplashPage();
	
	
	@Before
	public void setUp() {
		BaseClass.getDriver();
	}
	
	@After
	public void tearDown() {
		BaseClass.tearDown();
	}
}
