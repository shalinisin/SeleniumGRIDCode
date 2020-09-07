package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends Base{
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CounselLink","Wrong title");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
