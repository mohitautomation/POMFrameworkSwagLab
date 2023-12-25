package com.sauce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR
	
	 @FindBy(name="user-name")
	 WebElement username;	
	
	 @FindBy(name="password")
	 WebElement password;	
	
	@FindBy(xpath="//input[@type=\"submit\"][@id='login-button']")
	WebElement submitBtn;

	public LoginPage() {
		//initialize driver and current class this
		PageFactory.initElements(driver, this);
	}
	
	//action
	public String validateLoginPageTile() {
		return driver.getTitle();
		
	}
	
	public ProductPage Login(String un , String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitBtn.click();
		
		return new ProductPage();
	}
}
