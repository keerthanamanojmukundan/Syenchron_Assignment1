package com.pom.Sauce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Summary {

	    @FindBy(className = "inventory_item_name")
	    private List<WebElement> purchasedItems;

	    @FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
	    private WebElement priceOfFirstItem;

	    @FindBy(xpath = "(//div[@class='inventory_item_price'])[2]")
	    private WebElement priceOfSecondItem;

	    @FindBy(className = "summary_total_label")
	    private WebElement overallTotal;

	    @FindBy(id = "finish")
	    private WebElement finishOrderButton;

	    public Summary(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    public List<WebElement> getPurchasedItems() {
	        return purchasedItems;
	    }

	    public WebElement getOverallTotal() {
	        return overallTotal;
	    }

	    public WebElement getFinish() {
	        return finishOrderButton;
	    }
	
}
