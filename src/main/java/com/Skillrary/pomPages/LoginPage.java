package com.Skillrary.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	@FindBy(id="email")
	private WebElement emailtb;
	
	@FindBy(name="password")
	private WebElement passwordtb;
	
	@FindBy(name="login")
	private WebElement loginbtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public UserPage userlogin(String email,String pwd) {
		emailtb.sendKeys(email);
		passwordtb.sendKeys(pwd);
		loginbtn.click();
		return new UserPage(driver);
	}
	
	

}
