package com.qa.jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {
	
	@FindBy(id = "main-panel")
	private WebElement profile;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configure;
	
	public WebElement getProfile() {
		return profile;
	}
	
	public WebElement configure() {
		return configure;
	}
	

}
