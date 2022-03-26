package com.Skillrary.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryDemoApp {
	public WebDriver driver;
	@FindBy(id="course")
	private WebElement coursebtn;
	
	@FindBy(xpath="//a[text()='Selenium Training']")
	private WebElement seleniumtaring;
	
	@FindBy(xpath="//a[text()='LOGIN']")
	private WebElement usrimg;
	
	
	
	public WebElement getUsrimg() {
		return usrimg;
	}

	
	
	

	public SkillraryDemoApp(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public AddtoCartPage seleniumtariningtab() {
		seleniumtaring.click();
		return new AddtoCartPage(driver);
		
	}
	

	public WebElement getCoursebtn() {
		return coursebtn;
	}

	public WebElement getSeleniumtaring() {
		return seleniumtaring;
	}
	
	public LoginPage logindetails() {
		usrimg.click();
return new LoginPage(driver);
		
	}
	

}
