package com.Skillrary.Ecommerce;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.Skillrary.GenericLib.BaseClass;
import com.Skillrary.GenericLib.Excelutilies;
import com.Skillrary.GenericLib.FileUtilies;
import com.Skillrary.pomPages.LoginPage;
import com.Skillrary.pomPages.ProfilePage;
import com.Skillrary.pomPages.SkillraryDemoApp;
import com.Skillrary.pomPages.SkillraryLoginPage;
import com.Skillrary.pomPages.UserPage;

public class Testcase2 extends Excelutilies{
	
	@Test(dataProvider = "readData")
	public void tc2(String fn,String ln,String email,String pwd,String contact) throws SQLException, IOException, InterruptedException {
	SkillraryLoginPage s=new SkillraryLoginPage(driver);
	SkillraryDemoApp d = s.skillrarydemoapplication();
	driverutilies.switchTabs(driver);
    LoginPage u = d.logindetails();
    String query="select * from logindetails";
    UserPage qw = u.userlogin(FileUtilies.queryExecution(query,1,"user"),FileUtilies.queryExecution(query,2,"user"));
ProfilePage ed = qw.edit();
ed.profiledetails(fn, ln, email, pwd, contact);


ed.photobtn();
Thread.sleep(3000);
driverutilies.fileupload();
Thread.sleep(10000);





	}
	

}
