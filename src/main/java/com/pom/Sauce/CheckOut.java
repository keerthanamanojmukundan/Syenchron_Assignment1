package com.pom.Sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {
	  @FindBy(id = "first-name")
	    private WebElement inputFirstName;

	    @FindBy(id = "last-name")
	    private WebElement inputLastName;

	    @FindBy(id = "postal-code")
	    private WebElement inputZipCode;

	    @FindBy(id = "continue")
	    private WebElement btnContinue;

	    public CheckOut(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    public void fillCheckoutDetails(String first, String last, String zipCode) {
	        inputFirstName.sendKeys(first);
	        inputLastName.sendKeys(last);
	        inputZipCode.sendKeys(zipCode);
	        btnContinue.click();
	    }

}
