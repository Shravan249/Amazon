package demo.pageobject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Flipkartsearch {

	
	WebDriver driver;
	SoftAssert sa = new SoftAssert();
	
	
	public Flipkartsearch(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="div[class='_2QfC02'] button")
	WebElement loginClose;
	
	@FindBy(css="div[class='_3OO5Xc'] input")
	WebElement search;
	
	@FindBy(css="div[class='_3OO5Xc'] input")
	WebElement enterText;
	
	@FindBy(xpath="//div[@class='col-12-12 _2oO9oE']/button")
	WebElement submit;
	
	@FindBy(xpath="//div[@class='W_R1IA']/span")
	WebElement checkList;
	
	@FindBy(xpath="//div[@class='col col-7-12']/div[1]")
	List<WebElement> order;
	
	
	
	public void order(String searchText,String brandName) {
		
		loginClose.click();
	    search.click();
		enterText.sendKeys(searchText);
		submit.click();
		String text=checkList.getText();
		if(text.contains(searchText)) {
			sa.assertTrue(true);
		}
	   for(int i=1;i<order.size();i++) 
	   {
		   if(order.get(i).getText().contains(brandName)) {
			   
			   order.get(i).click();
		   }
	   }
		sa.assertAll();
		
		}



	}

