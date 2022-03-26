package com.Skillrary.GenericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author QSP
 *
 */
public class FileUtilies {
	public static Connection con;

	public String getDataPropertyfile(String key) throws FileNotFoundException, IOException 
	{
		Properties p=new Properties();
		p.load(new FileInputStream(AutoConstant.propertyFilePath));
		return p.getProperty(key);
		
	}
	
	
	public String getDataExcel(String Sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
String s="";
FileInputStream fis=new FileInputStream(AutoConstant.excelFilePath);
Workbook wb = WorkbookFactory.create(fis);
return s = wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	}
	


public static Connection getdataBase() throws SQLException {
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sr","root","root");
	
}

public static String queryExecution(String query,int i,String ExcepteData) throws SQLException {
Statement statement = con.createStatement();
ResultSet result = statement.executeQuery(query);
while(result.next()) {
	if(result.getString(i).equals(ExcepteData)) {
		break;
	}
	else
	{
		System.out.println("Data not found");
	}
}
return ExcepteData;
}

public static void closedb() throws SQLException {
	con.close();
}







}