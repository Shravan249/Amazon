package demo;

import org.testng.annotations.Test;

import demo.pageobject.SearchVerification;
import demo.testcomponents.AmazonBase;

public class ErrorValidation extends AmazonBase {

	@Test
	public void search() throws Exception {
		
		SearchVerification search=searchVerify();
		search.noItems("asdafaugaeufh");
	
		
	}
}
