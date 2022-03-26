package com.Skillrary.Ecommerce;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Skillrary.GenericLib.BaseClass;

import com.Skillrary.pomPages.AddtoCartPage;
import com.Skillrary.pomPages.ContactUsPage;
import com.Skillrary.pomPages.SkillraryDemoApp;
import com.Skillrary.pomPages.SkillraryLoginPage;




public class Testcase1 extends BaseClass{
	
	@Test
	public void tc1() throws FileNotFoundException, IOException, InterruptedException {
		test=reports.createTest("tc1");
		
	SkillraryLoginPage s=new SkillraryLoginPage(driver);
	SkillraryDemoApp sd = s.skillrarydemoapplication();
	driverutilies.switchTabs(driver);
	driverutilies.mouseHover(driver,sd.getCoursebtn());
	AddtoCartPage t = sd.seleniumtariningtab();
	driverutilies.doubleClick(driver,t.getAddbtn());
	t.getAddtocat().click();
	driverutilies.alertPopupOk(driver);
	Point loc = t.getContaactus().getLocation();
	int x=loc.getX();
	int y=loc.getY();
	
	driverutilies.scrollBar(driver, x, y);
	ContactUsPage c =t.contactUsbtn();
	
	c.twitterbtn(fileutilies.getDataPropertyfile("name"),
		fileutilies.getDataPropertyfile("email"),fileutilies.getDataPropertyfile("sub"),fileutilies.getDataPropertyfile("msg"),fileutilies.getDataPropertyfile("sendEmail"));
Thread.sleep(5000);
	Assert.assertEquals(driver.getTitle(),fileutilies.getDataPropertyfile("twittertitle"));	
	
	}

}
