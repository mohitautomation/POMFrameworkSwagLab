package com.sauce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.base.TestBase;

public class CartPage extends TestBase {
	
	//Page Factory - OR
	
	@FindBy(xpath="//*[text()='Your Cart']")
	WebElement cartPagetitle;
	
	@FindBy(xpath="//*[text()='CHECKOUT']")
	WebElement cartPageCheckout;
	
	@FindBy(xpath="//*[@id='first-name']")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id='last-name']")
	WebElement LastName;
	
	@FindBy(xpath="//*[@id='postal-code']")
	WebElement postalCode;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement submitBtn;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateCartPageTile() 
	{
		return cartPagetitle.getText();
	}
	
	public void checkOut() throws InterruptedException
	{
		if(cartPageCheckout.isDisplayed()) {
			cartPageCheckout.click();
			Thread.sleep(5000);
		}else
		{
			System.out.println("Product not avaialbe for checkout");
			cartPageCheckout.click();
		}
	}
	
	public void checkoutInformation(String fname,String lname, String pcode) throws InterruptedException
	{
		firstName.sendKeys(fname);
		Thread.sleep(2000);
		LastName.sendKeys(lname);
		Thread.sleep(3000);
		postalCode.sendKeys(pcode);
		submitBtn.click();
		Thread.sleep(5000);
	}
	
	

}
