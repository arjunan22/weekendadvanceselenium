package com.Skillrary.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	public WebDriver driver;
	@FindBy(xpath="(//img[@alt='User Image'])[2]")
	private WebElement img;
	
	@FindBy(xpath="//a[text()='Profile']")
	private WebElement profileimg;
	
	@FindBy(xpath="//a[text()=' Edit']")
	private WebElement editprofile;
	
	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public ProfilePage edit() {
		img.click();
		profileimg.click();
		editprofile.click();
		return new ProfilePage(driver);
	}
	

}
