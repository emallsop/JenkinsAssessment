package com.qa.jenkins;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


	public class ExcelUtils {

		private static XSSFSheet ExcelWSheet;
		private static XSSFWorkbook ExcelWBook;
		private static XSSFCell Cell;
		private static XSSFRow Row;

		//Set file path and open file

		public static void setExcelFile(String Path, int sheetIndex) {

			try {
				FileInputStream ExcelFile = new FileInputStream(Path);
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheetAt(sheetIndex);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static XSSFSheet getExcelWSheet() {
			return ExcelWSheet;
		}
		// read test data
		 public static String getCellData(int RowNum, int ColNum) {

			try {

				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();
				return CellData;
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}

		} 

		 //write 
		public static void setCellData(String Result, int RowNum, int ColNum) {

			try {

				Row = ExcelWSheet.getRow(RowNum);
				Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

				if (Cell == null) {
					Cell = Row.createCell(ColNum);
					Cell.setCellValue(Result);
					
				} else {
					Cell.setCellValue(Result);
				}
				
				FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);
				ExcelWBook.write(fileOut);			
				fileOut.close();			
				fileOut.flush();
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
