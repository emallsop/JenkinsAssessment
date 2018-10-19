package com.qa.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	/*@FindBy(xpath = "//*[@id=\"main-panel\"]/div[2]/h1")
	private WebElement welcome;*/
	
	@FindBy(id = "j_username")
	private WebElement username;
	
	@FindBy(xpath = "/html/body/div/div/form/div[2]/input")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageButton;
	
	public void enterUsername(String text) {
		username.sendKeys(text);	
	}
	
	public void enterPassword(String text) {
		password.sendKeys(text);
		password.submit();
	}
	
	public WebElement getWelcome(WebDriver driver) {
		WebElement welcome = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-panel\"]/div[2]/h1")));
		return welcome;
	}
	
	public WebElement getManage() {
		return manageButton;
	}

}
