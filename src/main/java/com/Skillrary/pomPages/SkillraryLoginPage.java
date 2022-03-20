package com.Skillrary.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryLoginPage {
	public WebDriver driver;
@FindBy(xpath="//a[text()=' GEARS ']")
private WebElement gearsbtn;

public WebElement getGearsbtn() {
	return gearsbtn;
}

public WebElement getSkillrarydemoapp() {
	return skillrarydemoapp;
}

@FindBy(xpath="(//a[text()=' SkillRary Demo APP'])[2]")
private WebElement skillrarydemoapp;

public SkillraryLoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	this.driver=driver;
}

public SkillraryDemoApp skillrarydemoapplication() {
	gearsbtn.click();
	skillrarydemoapp.click();
	return new SkillraryDemoApp(driver);
}



}
