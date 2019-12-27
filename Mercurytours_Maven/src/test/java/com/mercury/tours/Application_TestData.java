package com.mercury.tours;

import org.testng.annotations.DataProvider;

public class Application_TestData {

	@DataProvider(name="Login")
	public Object[][] getDataFromDataprovider()
	{
		return new Object[][] {
			{"testing","testing"},
			{"dixit","dixit"},
			{"testabhi","testabhi"}
		};
	}
	
	@DataProvider(name="LoginDataXLS")
	public Object[][] ExcelXLS() throws Exception{
		ReadExcel_XLS excel = new ReadExcel_XLS();
		Object[][] testObjArray = excel.getExcelData("C:\\SeleniumTraining\\Workspace\\Mercurytours_Maven\\Mercury_Tours.xls", "Sign_On");
		System.out.println(testObjArray);
		return testObjArray;
		
	}

	@DataProvider(name="LoginDataXLXS")
	public Object[][] ExcelXLXS() throws Exception{
		ReadExcel_XLXS excel = new ReadExcel_XLXS();
		Object[][] testObjArray = excel.getExcelData("C:\\SeleniumTraining\\Workspace\\Mercurytours_Maven\\Mercury_Tours.xlsx", "Sign_On");
		System.out.println(testObjArray);
		return testObjArray;
		
	}

	@DataProvider(name="LoginDataXLXSXLX")
	public Object[][] ExcelXLXSXLX() throws Exception{
		ReadExcel_XLX_XLSX_Ifcond excel = new ReadExcel_XLX_XLSX_Ifcond();
		Object[][] testObjArray = excel.getExcelData("C:\\SeleniumTraining\\Workspace\\Mercurytours_Maven\\Mercury_Tours.xlsx", "Sign_On");
		System.out.println(testObjArray);
		return testObjArray;
		
	}
	
}
