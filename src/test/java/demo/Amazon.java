package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demo.data.DataFile;
import demo.pageobject.Amazonsearch;
import demo.testcomponents.AmazonBase;

public class Amazon extends AmazonBase{

	@Test(dataProvider = "getValues")
	public void search(HashMap<String,String> input) throws IOException {
		
	    Amazonsearch as = website();
	    as.login(input.get("email"),input.get("password"));
		as.order(input.get("searchText"), input.get("brandName"));
		as.buyProduct();
		

	}
	
	@DataProvider
	public Object[][] getValues() throws IOException {
		String pathFile="D:\\Testing\\flipkart\\src\\test\\java\\demo\\data\\Amazondata.json";
		DataFile data=new DataFile();
		List<HashMap<String,String>>values=data.getData(pathFile);
		return new Object[][] {{values.get(0)},{values.get(1)}};
		
}
}
