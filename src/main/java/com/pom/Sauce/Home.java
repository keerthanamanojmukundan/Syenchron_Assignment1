package com.pom.Sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	private WebElement cartBtn1;
	
	@FindBy(xpath= "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement cartBtn2;
	
	@FindBy(xpath= "//button[@id=\"react-burger-menu-btn\"]")
	private WebElement burger;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	private WebElement logout;
	
	@FindBy(xpath="//div[@id=\"shopping_cart_container\"]")
	private WebElement openCart;
	
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart()
	{
		cartBtn1.click();
		cartBtn2.click();
		openCart.click();
		
	}
	public void logOut()
	{
		burger.click();
		logout.click();
	}
	
	

}
