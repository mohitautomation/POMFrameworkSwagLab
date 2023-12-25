package com.sauce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.TestBase;
import com.sauce.qa.pages.LoginPage;
import com.sauce.qa.pages.ProductPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	ProductPage productpage;
	
	public LoginPageTest() {
		super();
	}
	
	
    @BeforeMethod
    public void setUp() {    	
    	initialization();
    	loginpage = new LoginPage(); 	   	
    }
    
    @Test(priority =1 )
    public void LoginPageTitleTest() {
    	String title = loginpage.validateLoginPageTile();
    	Assert.assertEquals(title, "Swag Labs");
    }
    
    @Test(priority =2 )
    public void LoginTest() {
    	productpage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
    }
    
    
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
    
	

}
