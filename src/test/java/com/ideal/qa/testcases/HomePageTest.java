package com.ideal.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ideal.qa.base.TestBase;
import com.ideal.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	//create HomePage variable at the class level 
	//so that i can use it through out my program 
	HomePage homePage;
	
	//create one constructor of HomePageTest
	//Super keyword - to call Super class constructor
	//super class is TestBase class constructor
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		//to initialize browser, property file.
		//call initialisation method()
		initialisation();
		//create HomePage class object
		homePage=new HomePage();
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title=homePage.validateLoginPageTitle();
		Assert.assertEquals(title, "Anderson Power English");
	}
	
	@Test(priority=2)
	public void homePageLogoImageTest() {
		boolean flag=homePage.validateHeaderLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
