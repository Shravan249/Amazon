package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demo.data.DataFile;
import demo.pageobject.Flipkartsearch;
import demo.testcomponents.FlikartBase;

public class Flipkart extends FlikartBase {

	@Test(dataProvider="getValues")
	public void search(HashMap<String,String> input) throws IOException {

      Flipkartsearch flipkartsearch =  website();
	  flipkartsearch.order(input.get("searchText"), input.get("brandName"));
		
	}
	
	@DataProvider
	public Object[][] getValues() throws IOException {
		String pathFile="D:\\Testing\\flipkart\\src\\test\\java\\demo\\data\\Flipkartdata.json";
		DataFile data=new DataFile();
		List<HashMap<String,String>>values=data.getData(pathFile);
		return new Object[][] {{values.get(0)},{values.get(1)}};
		
}
}