package com_Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com_TestCases.Luma_BaseClass;

public class Registration_Report implements ITestListener{

	public ExtentSparkReporter rp; //(document name,report name,theme)
	public ExtentReports er; //(username,hostname,Os,browser,environment)
	public ExtentTest et; //(Pass,fail,shpped)
	
	//per-defined methods(onStart,onTestSuccess,onTestFailure,onTestSkipped,onFinish)
	
	public void onStart(ITestContext tr) {
		
	//	rp = new ExtentSparkReporter("C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\TestNGFrameWork_POS_34\\adactin_Report\\adactin01-03.html");
		
		String Timestamp = new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());
		String reportname = "Luma_Test_Report "+Timestamp+".html";
		rp=new ExtentSparkReporter("C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\Hyb_pos_34\\TestReport\\"+reportname);

		
		rp.config().setDocumentTitle("Luma-Report");
		rp.config().setReportName("Registration test");
		rp.config().setTheme(Theme.DARK);
		
		
		er = new ExtentReports();
		er.attachReporter(rp);
		
		er.setSystemInfo("username", "anwesh");
		er.setSystemInfo("Hostname", "LocalHost");
		er.setSystemInfo("OS", "Window10");
		er.setSystemInfo("Browser", "chrome,Edge,Firefox");
		er.setSystemInfo("Environment", "QA");
		
	}	
		
	public void onTestSuccess(ITestResult tr) {
		et = er.createTest(tr.getName());
		et.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr) {
		et = er.createTest(tr.getName());
		et.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		try {
		String imppath = new Luma_BaseClass().captureScreen(tr.getName());
		et.addScreenCaptureFromPath(imppath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult tr) {
		et = er.createTest(tr.getName());
		et.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREY));
		
	}
	
	public void onFinish(ITestContext context) {
		er.flush();
	}

}
