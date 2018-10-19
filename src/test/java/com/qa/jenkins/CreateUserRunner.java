// OLD CODE FROM BEFORE I STARTED USING THE FEATURE FILE


/*package com.qa.jenkins;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateUserRunner {

	public WebDriver driver = null;
	public static ExtentReports report;
	public ExtentTest test;


	@BeforeClass
	public static void initial() {
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Emily\\Test Reports\\JenkinsReport.html", true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void end() {
		report.flush();
	}
	
	@Test
	public void createUser() throws InterruptedException {
		//start report
		test = report.startTest("User Creation");
		
		//enter site
		driver.get(Constants.Homepage);
		test.log(LogStatus.INFO, "Entered Jenkins homepage");
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//login
		homePage.enterUsername("root");
		homePage.enterPassword("root");
		test.log(LogStatus.INFO, "Login");
		
		//check on correct homepage
		if (homePage.getWelcome(driver).getText().equals("Welcome to Jenkins!")) {
	    	test.log(LogStatus.PASS, "Home page loaded successfully");
	    }
	    else {
	    	test.log(LogStatus.FAIL, "Home page not loaded");
	    	report.endTest(test);
	    }
		

		
		//click manage Jenkins button
		homePage.getManage().click();
		test.log(LogStatus.INFO, "Click 'Manage Jenkins' button");
		
		ManagePage managePage = PageFactory.initElements(driver, ManagePage.class);
		//check on manage page
			if (managePage.getHeader().getText().equals("Manage Jenkins")) {
			test.log(LogStatus.PASS, "Manage page loaded successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Manage page not loaded");
			report.endTest(test);
		}
			
		//click manage users button
		managePage.manageUsers().click();
		test.log(LogStatus.INFO, "Click 'Manage Users'");
		
		ManageUsersPage manageUsersPage = PageFactory.initElements(driver, ManageUsersPage.class);
		//check on manage users page
			if (manageUsersPage.getHeader().getText().equals("Users")) {
			test.log(LogStatus.PASS, "Manage Users page loaded successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Manage Users page not loaded");
			report.endTest(test);
		}
			
		
		//click add new user
		manageUsersPage.addUser().click();
		test.log(LogStatus.INFO, "Click 'Create User'");
		
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		//add new user
		createUserPage.enterUsername("test");
		createUserPage.enterPassword("test");
		createUserPage.confirmPassword("test");
		createUserPage.fullName("test");
		createUserPage.enterEmail("test@gmail.com");
		createUserPage.createButton().click();
		Thread.sleep(10000);
		
		//check on manage users page
		if (manageUsersPage.getHeader().getText().equals("Users")) {
			test.log(LogStatus.PASS, "Manage Users page loaded successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Manage Users page not loaded");
			report.endTest(test);
		}
		
		//logout
		createUserPage.logout().click();
		test.log(LogStatus.INFO, "Logout");
		
		//login as new user
		driver.get(Constants.Homepage);
		test.log(LogStatus.INFO, "Login as new User");
		homePage.enterUsername("test");
		homePage.enterPassword("test");
		
		//check on homepage therefore logged in
				if (homePage.getWelcome(driver).getText().equals("Welcome to Jenkins!")) {
				test.log(LogStatus.PASS, "New User successfully added");
			}
			else {
				test.log(LogStatus.FAIL, "New User not added");
				report.endTest(test);
			}
		
		assertEquals("Homepage Loaded", "Welcome to Jenkins!", homePage.getWelcome(driver).getText());
	}
}
*/