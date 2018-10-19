package com.qa.jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagePage {
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/h1")
	private WebElement manageHeader;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[17]/a/dl")
	private WebElement manageUsers;
	
	public WebElement getHeader() {
		return manageHeader;
	}
	
	public WebElement manageUsers() {
		return manageUsers;
	}

}
