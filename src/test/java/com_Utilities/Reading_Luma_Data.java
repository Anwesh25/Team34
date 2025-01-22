package com_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reading_Luma_Data {
	
	Properties pro;
	
	public Reading_Luma_Data() {
		
		File fle = new File("C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\Hyb_pos_34\\configuration\\Data.properties");
	  try {
		FileInputStream fis = new FileInputStream(fle);
		pro = new Properties();
		pro.load(fis);  ///It will load the properties 
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
		
	}
	
	
	public String getFirstName() {
		String FName = pro.getProperty("FirstName");
		return FName;
	}
	
	public String getLastName() {
		String LName = pro.getProperty("LastName");
		return LName;
	}
	
	public String getEmailAddress() {
		String EmailAdd = pro.getProperty("Email");
		return EmailAdd;
				
	}
	
	public String getpassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getconfirmpassword() {
		String CPassword = pro.getProperty("confirmpassword");
		return CPassword;
	}

}
