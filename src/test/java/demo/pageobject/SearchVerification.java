package demo.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;



public class SearchVerification   {

	WebDriver driver;
	
	public SearchVerification(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement submit;
	
	@FindBy(css="div[class*='outline']")
	List<WebElement> result;
	
	SoftAssert sa=new SoftAssert();
	public void noItems(String text) {
		
		searchbox.click();
		searchbox.sendKeys(text);
		submit.click();
		String msg = " ";
		for(int i=0;i<result.size();i++) {
			
			if(result.get(i).getText().contains(text)) {
				
				msg=result.get(i).getText();
			}
		}
		
		
		sa.assertEquals("No results found", msg);
		sa.assertAll();
	}
	
}
