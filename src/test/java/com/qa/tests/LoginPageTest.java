package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends Base  {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void validateLoginTitleTest() {
		String title = loginPage.validateLoginTitle();
		Assert.assertEquals(title, "CounselLin","Wrong title observed");
	}
	
	
	@Test(priority=2)
	public void validateLogoTest() {
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void validateLoginTest() {
		homePage = loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	
	
	
	
	
	
	
	
	
}
