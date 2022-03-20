package com.Skillrary.GenericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtiles {
	
	public void dropDown(WebElement ele,String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	
	public void mouseHover(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public void draganddrop(WebDriver driver,WebElement source,WebElement target)  {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	public void rightClick(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
		
	}
	public void frames(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	
	public void framesswitchBack(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void alertPopupOk(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertPopupCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchTabs(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
		}
	}
	
	public void scrollBar(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		
	}
	
	public void getSceenshot(WebDriver driver,String name) throws IOException {
		Date d=new Date();
		String currentDate = d.toString().replaceAll(":","-");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(AutoConstant.photoPath+currentDate+name+".png");
		FileUtils.copyFile(src, dest);
	}
	

}
