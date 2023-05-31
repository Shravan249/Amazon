package demo.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import demo.pageobject.Flipkartsearch;

public class FlikartBase {

	
   WebDriver driver;
   private String url="https://www.flipkart.com/";
	
	public WebDriver driverIntialize() throws IOException {
		String filepath="D:\\Testing\\flipkart\\src\\test\\java\\demo\\resources\\GlobalData.properties";
		FileInputStream fis = new FileInputStream(filepath);
		Properties prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver",
					"D:\\Soft\\ChromeDriver\\chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver(options);
		}

		else if (browser.equals("firefox")) { // fire fox
		}

		else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Java files\\edgedriver_win64/msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public Flipkartsearch website() throws IOException {
		driver=driverIntialize();
		driver.get(url);
		Flipkartsearch fs=new Flipkartsearch(driver);
		return fs;
	}
	
	@AfterMethod
	public void getClose() {
		
		driver.close();
		
	}
}
