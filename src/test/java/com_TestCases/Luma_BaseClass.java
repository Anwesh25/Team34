package com_TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import com_Utilities.Reading_Luma_Data;

public class Luma_BaseClass {
	
	// Implement thecommon functionality open application, close application,screenshot,)
	
	public Logger log;
	public static WebDriver driver;
	
	Reading_Luma_Data rld =new Reading_Luma_Data();
	
	public String FName = rld.getFirstName();
	public String LName = rld.getLastName();
	public String EmailAdd = rld.getEmailAddress();
	public String Password = rld.getpassword();
	public String CPassword = rld.getconfirmpassword();
	
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void openApplication(String br, String URL) {
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver = new EdgeDriver() ;
		}
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		log= Logger.getLogger("Hyb_pos_34");
		PropertyConfigurator.configure("Log4j.properties");
	}
	


/*
	@AfterClass
	public void CloseApplication() {
		driver.close();
	}
*/
	
	public String captureScreen(String tname) throws IOException {
		String timestamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
				
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir")+"\\Screenshot\\"+tname+"_"+timestamp+".png";
		try {
			FileUtils.copyFile(source, new File(Destination));
		}catch(Exception e) {
			e.getMessage();
		}
		
		return Destination;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
