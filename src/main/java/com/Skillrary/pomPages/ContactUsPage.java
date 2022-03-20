package com.Skillrary.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	@FindBy(name="name")
	private WebElement nametb;
	
	@FindBy(name="sender")
	private WebElement emailtb;
	
	@FindBy(name="subject")
	private WebElement subjecttb;
	
	@FindBy(name="message")
	private WebElement messagetb;
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendemailtb;
	
	
	@FindBy(xpath="(//i[@class='fa fa-twitter'])[2]")
	private WebElement twitter;
	
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	public void twitterbtn(String name,String email,String sub,String msg,String sendemail) {
		nametb.sendKeys(name);
		emailtb.sendKeys(email);
		subjecttb.sendKeys(sub);
		messagetb.sendKeys(msg);
		sendemailtb.sendKeys(sendemail);
		twitter.click();
	}


	public WebElement getNametb() {
		return nametb;
	}


	public WebElement getEmailtb() {
		return emailtb;
	}


	public WebElement getSubjecttb() {
		return subjecttb;
	}


	public WebElement getMessagetb() {
		return messagetb;
	}


	public WebElement getSendemailtb() {
		return sendemailtb;
	}


	public WebElement getTwitter() {
		return twitter;
	}
	
	
	
	

}
