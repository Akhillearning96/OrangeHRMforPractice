package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = lp.getPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	
	
}
