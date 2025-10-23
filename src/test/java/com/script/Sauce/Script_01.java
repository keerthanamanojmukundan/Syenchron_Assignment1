package com.script.Sauce;


import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.gen.Sauce.Base;
import com.gen.Sauce.ExcelReader;
import com.pom.Sauce.Cart;
import com.pom.Sauce.CheckOut;
import com.pom.Sauce.Confirmation;
import com.pom.Sauce.Home;
import com.pom.Sauce.Summary;

public class Script_01 extends Base {
	@Test
	public void testScript() throws EncryptedDocumentException, IOException
	{
		ExcelReader reader=new ExcelReader();
		String homePageUrl= reader.getData("SauceData", 10 , 0);
		String currentUrl=driver.getCurrentUrl();
		if(homePageUrl.equals(currentUrl))
		{
			Reporter.log("logged in and home page is  displayed", true);
		}
		else
		{
			Reporter.log("Hone page is not displayed hence not validated", true);
			Assert.fail();
		}
		Home hpage=new Home(driver);
		hpage.addToCart();
		
		Cart c=new Cart(driver);
		List<WebElement> products=c.getCartItems();
		String expected1 = reader.getData("SauceData", 13, 0);
	    String expected2 = reader.getData("SauceData", 13, 1);
		
		String prod1=products.get(0).getText();
		String prod2=products.get(1).getText();
		if(!(expected1.equals(prod1) && expected2.equals(prod2)))
		{
			 Reporter.log("Cart contains unexpected item ", true);
		     Assert.fail("Cart validation failed");		}
		else
		{
			Reporter.log("Cart validation passed", true);
			
		}

		c.getCheckout().click();
		
		CheckOut checkout=new CheckOut(driver);
		String firstname=reader.getData("SauceData", 7, 0);
		String lastname=reader.getData("SauceData", 7, 1);
		String zip=reader.getData("SauceData", 16, 0);
		
		checkout.fillCheckoutDetails(firstname, lastname, zip);
		
		
		Summary sum=new Summary(driver);
		List<WebElement> purchasedprod=sum.getPurchasedItems();

		String purchasedExp1 = reader.getData("SauceData", 13, 0);
	    String purchasedExp2 = reader.getData("SauceData", 13, 1);
		
		String purchasedAct1=products.get(0).getText();
		String purchasedAct2=products.get(1).getText();
		if(!(purchasedExp1.equals(purchasedAct1) && purchasedExp2.equals(purchasedExp2)))
		{
			 Reporter.log("Summary Validation failed", true);
		     Assert.fail();		}
		else
		{
			Reporter.log("Summary validation passed", true);
			
		}
		sum.getFinish().click();
		
		
		Confirmation conf=new Confirmation(driver);
		String confirmMsg=conf.fetchConfirmationMsg().getText();
		Reporter.log(confirmMsg, true);
		
		
		
	}

}
