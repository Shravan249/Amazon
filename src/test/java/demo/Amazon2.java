package demo;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demo.data.excel.DataDriven;
import demo.pageobject.Amazonsearch;
import demo.testcomponents.AmazonBase;

public class Amazon2 extends AmazonBase{

	
	@Test(dataProvider = "getData")
	public void search(String email,String password,String searchtext,String brandname) throws Exception{
		
	    Amazonsearch as = website();
	    as.login(email,password);
		as.order(searchtext,brandname);
		as.buyProduct();
		

	}
	
	
	@DataProvider
	public String[][] getData() throws Exception {
		String pathFile="./data/data.xlsx";
		String sheetName="testdata";
		DataDriven datadriven=new DataDriven();
	    String[][] data=datadriven.getExcelData(pathFile, sheetName);
		return data;
		
}
	
}
