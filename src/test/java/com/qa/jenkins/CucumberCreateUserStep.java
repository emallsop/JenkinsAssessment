package com.qa.jenkins;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberCreateUserStep {
	
	public WebDriver driver = null;
	public static ExtentReports report = new ExtentReports("C:\\Users\\Admin\\Documents\\Emily\\Test Reports\\JenkinsReport.html", true);
	public ExtentTest test;
	public static int testCount = 1;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() {
		//start report
		if (testCount == 1) {
			 	test = report.startTest("Manual User Creation");
			 	testCount++;
		 } else if (testCount == 2) {
			 	test = report.startTest("Parameterised User Creation 1");
			 	testCount++;
		 } else if (testCount == 3) {
			 	test = report.startTest("Parameterised User Creation 2");
			 	testCount++;
		 } else if (testCount == 4) {
			 	test = report.startTest("Parameterised User Creation 3");
			 	testCount++;
		 } else if (testCount == 5) {
			 	test = report.startTest("Parameterised User Creation 4");
			 	testCount = 1;
		 }
				
		//enter site
		driver.get(Constants.homepage);
		test.log(LogStatus.INFO, "Entered Jenkins homepage");
			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//login
		homePage.enterUsername("root");
		homePage.enterPassword("root");
		test.log(LogStatus.INFO, "Login");
		test.log(LogStatus.INFO, "Logged in");
							
		//click manage Jenkins button
		homePage.getManage().click();
		test.log(LogStatus.INFO, "Click 'Manage Jenkins' button");

		ManagePage managePage = PageFactory.initElements(driver, ManagePage.class);
		test.log(LogStatus.INFO, "Entered 'Manage Jenkins' page");	
		
		//click manage users button
		managePage.manageUsers().click();
		test.log(LogStatus.INFO, "Click 'Manage Users'");
		
		ManageUsersPage manageUsersPage = PageFactory.initElements(driver, ManageUsersPage.class);
		test.log(LogStatus.INFO, "Entered 'Manage Users' page");
			
		//click add new user
		manageUsersPage.addUser().click();
		test.log(LogStatus.INFO, "Click 'Create User'");
			
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		//check on manage users page
				if (createUserPage.getHeader().getText().equals("Create User")) {
				test.log(LogStatus.PASS, "Create User page loaded successfully");
			}
			else {
				test.log(LogStatus.FAIL, "Create User page not loaded");
				report.endTest(test);
			    report.flush();
			}
			
			assertEquals("Create User Page Loaded", "Create User", createUserPage.getHeader().getText());
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		
		//add new user
		createUserPage.enterUsername("test");
		test.log(LogStatus.INFO, "Username entered");
		createUserPage.enterPassword("test");
		test.log(LogStatus.INFO, "Password entered");
		createUserPage.confirmPassword("test");
		test.log(LogStatus.INFO, "Password entered in confirmation");
		createUserPage.fullName("test");
		test.log(LogStatus.INFO, "Full name entered");
		createUserPage.enterEmail("test@gmail.com");
		test.log(LogStatus.INFO, "Email entered");
		
		
		
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
	    createUserPage.createButton().click();
	    test.log(LogStatus.INFO, "Clicked 'Create User' button");
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		ManageUsersPage manageUsersPage = PageFactory.initElements(driver, ManageUsersPage.class);
		
	    System.out.print(manageUsersPage.getResults(driver));
	    
	    test.log(LogStatus.INFO, "Reentered 'Manage User' Page");
	 
	    //check if new user is in search results
	    boolean userPresent;
	    
	    if (manageUsersPage.getResults(driver).contains("test")) {
	    	userPresent = true;
	    } else {
	    	userPresent = false;
	    }
	    
	    //log whether user is present
	    if (userPresent) {
	    	test.log(LogStatus.PASS, "User Creation Successful");
	    }
	    else {
	    	test.log(LogStatus.FAIL, "User Creation Unsuccessful");
	    	report.endTest(test);
		    report.flush();

	    }
	    
	    assertEquals(true, userPresent);
	    
	    test.log(LogStatus.INFO, "Test Complete");
	    report.endTest(test);
 
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		
		//add new user
		createUserPage.enterUsername(arg1);
		createUserPage.enterPassword(arg2);
		createUserPage.confirmPassword(arg3);
		createUserPage.fullName(arg4);
		createUserPage.enterEmail("test2@gmail.com");
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		ManageUsersPage manageUsersPage = PageFactory.initElements(driver, ManageUsersPage.class);
		
	    System.out.print(manageUsersPage.getResults(driver));
	    
	  //check if new user is in search results
	    boolean userPresent;
	    
	    if (manageUsersPage.getResults(driver).contains(arg1)) {
	    	userPresent = true;
	    } else {
	    	userPresent = false;
	    }
	    
	    //log whether user is present
	    if (userPresent) {
	    	test.log(LogStatus.PASS, "User Creation Successful");
	    }
	    else {
	    	test.log(LogStatus.FAIL, "User Creation Unsuccessful");
	    	report.endTest(test);
		    report.flush();

	    }
	    
	    assertEquals(true, userPresent);
	    
	    test.log(LogStatus.INFO, "Test Complete");
	    report.endTest(test);
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
	
		test = report.startTest("Display Profile " + arg1);
		
		driver.get(Constants.userPage);
		test.log(LogStatus.INFO, "Entered User page");
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//login
		homePage.enterUsername("root");
		homePage.enterPassword("root");
		test.log(LogStatus.INFO, "Logged in");
		
		ManageUsersPage manageUsersPage = PageFactory.initElements(driver, ManageUsersPage.class);
		
	    System.out.print(manageUsersPage.getResults(driver));
	    
	  //check if new user is in search results
	    boolean userPresent;
	    
	    if (manageUsersPage.getResults(driver).contains(arg1)) {
	    	userPresent = true;
	    } else {
	    	userPresent = false;
	    }
	    
	    //log whether user is present
	    if (userPresent) {
	    	test.log(LogStatus.PASS, "User Creation Successful");
	    }
	    else {
	    	test.log(LogStatus.FAIL, "User Creation Unsuccessful");
	    	report.endTest(test);
		    report.flush();

	    }
	    
	    assertEquals(true, userPresent);
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		
		//click username
		ManageUsersPage manageUsersPage = PageFactory.initElements(driver, ManageUsersPage.class);
		manageUsersPage.user(driver, arg1).click();
		
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		
		ProfilePage profilePage = PageFactory.initElements(driver,ProfilePage.class);
		
		//check if on correct user profile page
		boolean correctProfile = profilePage.getProfile().getText().contains(arg1);
		
		if (correctProfile) {
			test.log(LogStatus.PASS, "User profile opened");
		} else {
			test.log(LogStatus.FAIL, "User profile not opened");
	    	report.endTest(test);
		    report.flush();
		}
		
		assertEquals(true, correctProfile);
		report.endTest(test);
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		
		test = report.startTest("Change Name " + arg1);
		
		//get to the profile page
		driver.get(Constants.userPage);
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.enterUsername("root");
		homePage.enterPassword("root");
		test.log(LogStatus.INFO, "Logged in");
		
		ManageUsersPage manageUsersPage = PageFactory.initElements(driver, ManageUsersPage.class);

	    System.out.print(manageUsersPage.getResults(driver));
	    
	    manageUsersPage.user(driver, arg1).click();
		
	    ProfilePage profilePage = PageFactory.initElements(driver,ProfilePage.class);
		
		boolean correctProfile = profilePage.getProfile().getText().contains(arg1);
		
		if (correctProfile) {
			test.log(LogStatus.PASS, "User profile opened");
		} else {
			test.log(LogStatus.FAIL, "User profile not opened");
	    	report.endTest(test);
		    report.flush();
		}
		
		assertEquals(true, correctProfile);
		
	
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		
		ProfilePage profilePage = PageFactory.initElements(driver,ProfilePage.class);
		profilePage.configure().click();
		test.log(LogStatus.INFO, "Clicked configure button");
	
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
	   
		ConfigurePage conPage = PageFactory.initElements(driver,ConfigurePage.class);	
		//change the name on the profile
		conPage.changeName(arg1);
		test.log(LogStatus.INFO, "Name changed");
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		ConfigurePage conPage = PageFactory.initElements(driver,ConfigurePage.class);
		//save the changes
		conPage.saveChanges().click();
		test.log(LogStatus.INFO, "Save clicked");
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
		
		ProfilePage profilePage = PageFactory.initElements(driver,ProfilePage.class);
		
		//check profile is now showing new name
		boolean correctProfile = profilePage.getProfile().getText().contains(arg1);
		
		if (correctProfile) {
			test.log(LogStatus.PASS, "User profile opened");
		} else {
			test.log(LogStatus.FAIL, "User profile not opened");
	    	report.endTest(test);
		    report.flush();
		}
		
		assertEquals(true, correctProfile);
		report.endTest(test);
	    report.flush();
	}
}
