package com.sauce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.TestBase;
import com.sauce.qa.pages.CartPage;
import com.sauce.qa.pages.LoginPage;
import com.sauce.qa.pages.ProductPage;

public class ProductPageTest extends TestBase{
	
	ProductPage proudctPge;
	CartPage cartPge;
	LoginPage loginpage;
	
	public ProductPageTest()
	{
		super();
	}
	
	//Test case should be independent to each other
	//Test case - login - test - close browser
	
	@BeforeMethod
    public void setUp() {    	
    	initialization();
    	loginpage = new LoginPage(); 
    	loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
    	proudctPge = new ProductPage(); 
    }
    
    @Test(priority =1 )
    public void ProductPageTitleTest() {
    	String title = proudctPge.validateProductPageTile();
    	Assert.assertEquals(title, "Products","Product Page title not matched");
    }
    
    @Test(priority =2 )
    public void addProductTest() {
    	cartPge = proudctPge.addProduct();
    }
    
    
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
	

}
