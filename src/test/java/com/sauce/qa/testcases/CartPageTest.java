/***
 * 
 * Mohit's Automation Framework
 *
 ***S 
 * 
 *****/


package com.sauce.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sauce.qa.base.TestBase;
import com.sauce.qa.pages.CartPage;
import com.sauce.qa.pages.LoginPage;
import com.sauce.qa.pages.ProductPage;
import com.sauce.qa.util.TestUtil;

public class CartPageTest extends TestBase{
	
	CartPage cartPge;
	LoginPage loginpage;
	ProductPage productPge;
	
	String sheetName = "CheckInfo";
	
	
	public CartPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void start() throws InterruptedException
	{
		initialization();
		loginpage = new LoginPage(); 
    	loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
    	Thread.sleep(3000);
		productPge = new ProductPage();
    	productPge.addProduct();
    	Thread.sleep(3000);
    	cartPge = new CartPage();
    	
	}
	
	@Test(priority = 1)
	
	public void validateCartPageTitleTest()
	{
		
		String title = cartPge.validateCartPageTile();
		Assert.assertEquals(title, "Your Cart", "Cart Page Title not matched");
	}
	
	@Test(priority = 2)
	public void checkOutTest() throws InterruptedException
	{
		cartPge.checkOut();
		Thread.sleep(5000);
	}
	
	@DataProvider
	public Object[][] getSauceTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority = 3,dataProvider="getSauceTestData")
	public void checkoutInfoTest(String FirstName , String LastName , String PostalCode) throws InterruptedException
	{
		cartPge.checkOut();
		//cartPge.checkoutInformation("Mohit" , "Negi" , "234234");
		cartPge.checkoutInformation(FirstName,LastName,PostalCode);
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
