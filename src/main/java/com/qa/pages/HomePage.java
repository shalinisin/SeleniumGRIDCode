package com.qa.pages;

import com.qa.base.Base;

public class HomePage extends Base{
		
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
}
