package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class LoginPage extends Base{
	
	//PageFactory/OR(Object Repository)
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;
	
	@FindBy(id="btnSignIn")
	WebElement signInBtn;
	
	@FindBy(xpath="//div[@class=\"navbar-header pull-left\"]//a")
	WebElement logo;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validateLoginTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage validatelogin(String un, String pwd) {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		signInBtn.click();
		return new HomePage();
	}
	
	
	
	
	
}
