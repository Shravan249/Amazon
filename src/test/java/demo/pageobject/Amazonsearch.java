package demo.pageobject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Amazonsearch {
	
	WebDriver driver;
	
	
	public Amazonsearch(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nav-signin-tooltip")
	WebElement login;
	
	@FindBy(css="input[type='email']")
	WebElement email;
	
	@FindBy(id="continue")
	WebElement next;
	
	@FindBy(css="input[type='password']")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signIn;

	@FindBy(id ="twotabsearchtextbox")
	WebElement search;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement enterText;
	
	@FindBy(css="input[type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//h2/a/span")
	List<WebElement> order;
	
	@FindBy(id="buy-now-button")
    WebElement buyNow;
	

	public void login(String emails,String passwords) {
		login.click();
		email.sendKeys(emails);
		next.click();
		password.sendKeys(passwords);
		signIn.click();
		 
      
	}
	
	public void order(String searchText,String brandName) {
		

		search.click();
		enterText.sendKeys(searchText);
		submit.click();
		for (int i=1;i<order.size();i++) {
			if(order.get(i).getText().contains(brandName)){
				
				order.get(i).click();
			}
		}
		
		
	}
	
	public void buyProduct() {
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		buyNow.click();
	}
	



	
}
