package com.Skillrary.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {
	public WebDriver driver;
	
	@FindBy(id="add")
	private WebElement addbtn;
	
	@FindBy(xpath="//button[text()=' Add to Cart']")
	private WebElement addtocat;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contaactus;
	
	public AddtoCartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
	
	public ContactUsPage contactUsbtn() {
		contaactus.click();
		return new ContactUsPage(driver) ;
	}

	
	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getAddtocat() {
		return addtocat;
	}

	public WebElement getContaactus() {
		return contaactus;
	}
	

}
