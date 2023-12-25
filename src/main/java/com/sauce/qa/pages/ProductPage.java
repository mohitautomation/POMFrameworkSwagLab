package com.sauce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.base.TestBase;

public class ProductPage extends TestBase{
	
	//Page Factory - OR

	@FindBy(xpath="//div[contains(text(),'Sauce Labs Backpack')]//following::div//div[text()='29.99']//following-sibling::button[contains(text(),'ADD TO CART')]")
	WebElement addToCart;
	
	@FindBy(xpath="//div[text()='Products' and @class='product_label']")
	WebElement productPageTitle;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']//following::span[text()='1']")
	WebElement productAddedCart;
	
	public ProductPage() {
		//initialize driver and current class this
		PageFactory.initElements(driver, this);
	}
	
	public String validateProductPageTile() 
	{
		return productPageTitle.getText();
	}
	
	public CartPage addProduct()
	{
		addToCart.click();
		if(productAddedCart.isDisplayed()) {
			productAddedCart.click();	
		}else {
			System.out.println("Product not added to cart");
			productAddedCart.click();
			
		}
		
		return new CartPage();
	}
	
}
