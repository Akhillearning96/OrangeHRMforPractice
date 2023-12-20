package com.qa.orangehrm.pages;




import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.util.ElementUtil;

public class LoginPage {
	
	WebDriver driver;
	ElementUtil eleUtil;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	
	private By privacyLink = By.xpath("(//a[@target='_blank'])[5]");
	private By linkedinLink = By.xpath("(//a[@target='_blank'])[1]");
	private By fbLink = By.xpath("(//a[@target='_blank'])[2]");
	private By twitterLink = By.xpath("(//a[@target='_blank'])[3]");
	private By youtubeLink = By.xpath("(//a[@target='_blank'])[4]");
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public void checkLinksFunctionality(String windowHandle) {
		driver.findElement(privacyLink).click();
		driver.findElement(linkedinLink).click();
		driver.findElement(fbLink).click();
		driver.findElement(twitterLink).click();
		driver.findElement(youtubeLink).click();
		String parentWindowID = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		List<String> handleList = new ArrayList<String>(handles);
		
		if(switchToLink(handleList,windowHandle)) {
			System.out.println(driver.getCurrentUrl());
			switchToMainWindow(parentWindowID);
			
		
		}
			
	}
	public void switchToMainWindow(String parentWindowID) {
		driver.switchTo().window(parentWindowID);
		
	}
	public boolean switchToLink(List<String> handleList, String windowTitle) {
		
		for(String e : handleList) {
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle)) {
				return true;
			}
		}
		return false;
	}
	

}
