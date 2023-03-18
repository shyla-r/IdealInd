package com.ideal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ideal.qa.base.TestBase;

public class HomePage extends TestBase {
	//Page factory or Object Repository:
		//HeaderLogo
		@FindBy(xpath="(//a[@class='cmp-image__link'])[1]")
		WebElement headerLogo;
		
		//SignIn CTA on HomePage Header
		@FindBy(xpath="//a[@id='sign-in-penicl-link']")
		WebElement signInHeaderCTA;
		
		//userName field
		@FindBy(name="login[username]")
		WebElement userName;
		
		//password field
		@FindBy(name="login[password]")
		WebElement password;
		
		//Signin CTA
		@FindBy(id="send2")
		WebElement signinCTA;
		
		//Language selector
		@FindBy(xpath="//a[@href=\"javascript:void(0)\"]")
		WebElement languageSelector;
		
		
		//Initialize constructor - to initialize the 
		//elements using this keyword
		//Initializing the Page Objects: 
		public HomePage() {
			PageFactory.initElements(driver, this);
			//this keyword - all the above WebElements 
			//will be initialized with this driver
			//this means its pointing to the current class object
			
			//method 1 on Login page
			
		}
		
		//Actions:
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		//method to validate if HeaderLogo is present
		public boolean validateHeaderLogo() {
			return headerLogo.isDisplayed();
		}
		
		//method to click on Sign In CTA in Header
		public void clickHeaderSignin() {
			signInHeaderCTA.click();
		}
		
		//method to sign-in on Sign In page
		public void login(String un, String pwd) {
			userName.sendKeys(un);
			password.sendKeys(pwd);
			signinCTA.click();
			
		}

}
