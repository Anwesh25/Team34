package com_TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_Luma_Pageobject.Luma_Login;
import com_Utilities.XLUtilis;

public class Tc_02_Luma_Login  extends Luma_BaseClass{
	
	@Test(dataProvider="LumaLoginData")
	public void loginTest(String email, String password) throws InterruptedException {
		Luma_Login ll = new Luma_Login(driver);
		
		ll.setEmail(email);
		ll.setpassword(password);
		Thread.sleep(3000);
		ll.clicksinginbtn();
		ll.ClearEmail();
		ll.ClearPassword();
		Thread.sleep(3000);
	}
	
	@DataProvider(name="LumaLoginData")
	String [][] getData() throws IOException {
		
		String path = "C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\Hyb_pos_34\\src\\test\\java\\com_Testdata\\LumaLoginData.xlsx";
		
		//identify the row count
		int rownum = XLUtilis.getRowcount(path, "Sheet1");  //3
		
		//identify the cell count
		int colcell = XLUtilis.getCellCount(path, "Sheet1", 1); //1
										//	3		1
		String Logindata[][] = new String[rownum][colcell];
		for (int i=1; i<=rownum ;i++) { //it will represent the rows
			for(int j=0; j<colcell;j++) { //it will represent the cell
				Logindata[i-1][j] = XLUtilis.getCelldata(path, "Sheet1", i, j);
				
			}
		}
		return Logindata;
	}

}
