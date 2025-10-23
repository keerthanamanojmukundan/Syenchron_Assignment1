package com.pom.Sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation {
    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement confMsg;
    

    public Confirmation(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement fetchConfirmationMsg() {
        return confMsg;
    }

}
