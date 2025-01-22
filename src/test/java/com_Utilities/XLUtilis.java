package com_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilis {
	
	//data driven testing supporting file
	// It is applicable for each and every Excell sheet
	public static FileInputStream fi;  //it will convert into reading mode
	public static FileOutputStream fo; //it will convert into Writing mode
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
	//get the row count of the Excell Sheet
	public static int getRowcount(String XLfile, String XLsheet) throws IOException {
		fi = new FileInputStream(XLfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(XLsheet);
		int rowCount = sheet.getLastRowNum(); // last row num
		
		wb.close();
		fi.close();
		return rowCount;
 	}
	
	//get the Cell count
	public static int getCellCount(String XLfile,String XLsheet,int rownum) throws IOException {
		fi = new FileInputStream(XLfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(XLsheet);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum(); //find the cell count
		return cellcount;
	}
	
	//get the cell data
	public static String getCelldata(String XLfile,String XLsheet,int rownum, int cellnum) throws IOException {
		fi = new FileInputStream(XLfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(XLsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		String data;
		try {
			
			DataFormatter format = new DataFormatter(); //syntax
			String celldata = format.formatCellValue(cell);
			return celldata;
		}catch(Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public void setcellData(String XLfile,String XLsheet,int rownum, int cellnum, String data) throws IOException {
		fi = new FileInputStream(XLfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(XLsheet);
		row = sheet.getRow(rownum);
		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		
		fo= new FileOutputStream(XLfile); // writig the data
		wb.write(fo);  
		fi.close();
		fo.close();
		
	}
	
	
	
	
	

}
