package com.pom.Sauce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	private List<WebElement> products;
	
	@FindBy(id="checkout")
	private WebElement checkout;
	
	public Cart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public List<WebElement> getCartItems()
	{
		return products;
	}
	public WebElement getCheckout()
	{
		return checkout;
	}
	
}
