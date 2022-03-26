package com.Skillrary.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	@FindBy(id="firstname")
	private WebElement firstnametb;
	
	@FindBy(id="lastname")
	private WebElement lastnametb;
	
	public WebElement getUpdatebtn() {
		return updatebtn;
	}
	
	@FindBy(xpath="//input[@id='photo']")
	private WebElement photo;

	@FindBy(id="email")
	private WebElement emailtb;
	
	@FindBy(id="password")
	private WebElement passwordtb;
	
	@FindBy(id="contact")
	private WebElement contacttb;
	
	@FindBy(xpath="(//input[@class='chosen-search-input'])[2]")
	private WebElement serachaddress;
	
	public WebElement getSerachaddress() {
		return serachaddress;
	}

	public WebElement getContacttb() {
		return contacttb;
	}

	public WebElement getCurrentpassword() {
		return currentpassword;
	}

	public WebElement getAddrestype() {
		return addrestype;
	}

	public WebElement getAddresstb() {
		return addresstb;
	}

	public WebElement getBirthday() {
		return birthday;
	}

	@FindBy(id="curr_password")
	private WebElement currentpassword;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updatebtn;
	
	@FindBy(xpath="//span[text()='Home']")
	private WebElement addrestype;
	
	@FindBy(name="address")
	private WebElement addresstb;
	
	@FindBy(id="birthday")
	private WebElement birthday;
	
	
	
	
	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void profiledetails(String fn,String ln,String email,String pwd,String contact) {
		firstnametb.sendKeys(fn);
		lastnametb.sendKeys(ln);
		emailtb.sendKeys(email);
		passwordtb.sendKeys(pwd);
		contacttb.sendKeys(contact);

}
	
	public void photobtn() {
		photo.click();
	}
	
	
	

}
