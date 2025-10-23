package com.pom.Sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id="user-name")
	private WebElement unTf;
	
	@FindBy(id="password")
	private WebElement pwTf;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getLogin(String username, String password) {
        unTf.sendKeys(username);
        pwTf.sendKeys(password);
        loginBtn.click();
	}

	

}
