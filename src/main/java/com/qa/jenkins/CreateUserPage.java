package com.qa.jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/h1")
	private WebElement pageHeader;
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullName;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement email;
	
	@FindBy(id = "yui-gen1-button")
	private WebElement createButton;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/span/a[2]")
	private WebElement logout;
	
	public WebElement getHeader() {
		return pageHeader;
	}
	
	public void enterUsername(String text) {
		username.sendKeys(text);	
	}
	
	public void enterPassword(String text) {
		password.sendKeys(text);
	}
	
	public void confirmPassword(String text) {
		confirmPassword.sendKeys(text);
	}
	
	public void fullName(String text) {
		fullName.sendKeys(text);
	}
	
	public void enterEmail(String text) throws InterruptedException {
		email.sendKeys(text);
	}
	
	public WebElement createButton() {
		return createButton;
	}
	
	public WebElement logout() {
		return logout;
	}

}
