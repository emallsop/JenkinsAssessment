package com.qa.jenkins;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUsersPage {
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/h1")
	private WebElement usersHeader;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement addNew;
	
	@FindBy(id = "people")
	private WebElement userTable;
	
	public WebElement getHeader() {
		return usersHeader;
	}
	
	public WebElement addUser() {
		return addNew;
	}
	
	public WebElement userTable() {
		return userTable;
	}

	public List<String> getResults(WebDriver driver) {
		
		//xpath of search results
		WebElement userList = driver.findElement(By.id("people"));
		
		//create list of product names within search results
	    List<String> userName = new ArrayList<String>();
	    List<WebElement> allUsersNames = userList.findElements(By.tagName("td"));
	    
	    
	    for(WebElement w : allUsersNames) {
	        userName.add(w.getText());
	    }
	
	    return userName;
	}
	
	public WebElement user(WebDriver driver, String username) {
		
		//xpath of search results
		WebElement userList = driver.findElement(By.id("people"));
		WebElement user = userList.findElement(By.partialLinkText(username));
		
		return user;
		
		
	}
}