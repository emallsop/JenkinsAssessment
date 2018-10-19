package com.qa.jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurePage {
	
	@FindBy(name = "_.fullName")
	WebElement name;
	
	@FindBy(id = "yui-gen2-button")
	WebElement saveButton;
	
	public void changeName(String text) {
		name.clear();
		name.sendKeys(text);
	}
	
	public WebElement saveChanges() {
		return saveButton;
	}

}
