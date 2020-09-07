package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utilities.WebEventListener;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	
	
	public Base() {
		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream("C:\\Users\\SING110\\Documents\\JAVARELATEDITEMS\\POMWorkspace\\"
					+ "SeleniumGRIDConcept\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SING110\\Documents\\JAVARELATEDITEMS\\BrowserEXE\\Chrome85\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
			
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		} 
	}
}
