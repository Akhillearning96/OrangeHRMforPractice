package com.qa.orangehrm.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.orangehrm.driverfactory.DriverFactory;
import com.qa.orangehrm.pages.LoginPage;

public class BaseTest {
	DriverFactory df;
	LoginPage lp;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		WebDriver driver = df.init_driver();
		lp = new LoginPage(driver);
		
		
	}
	@AfterTest
	public void teardown() {
		
	}

}
