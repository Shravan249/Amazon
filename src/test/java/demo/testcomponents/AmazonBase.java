package demo.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import demo.pageobject.Amazonsearch;
import demo.pageobject.SearchVerification;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBase {

	public WebDriver driver;
	private String url = "https://www.amazon.in/";

	public WebDriver driverIntialize() throws IOException {
		String filepath = "D:\\Testing\\flipkart\\src\\test\\java\\demo\\resources\\GlobalData.properties";
		FileInputStream fis = new FileInputStream(filepath);
		Properties prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}

		else if (browser.equals("firefox")) {
			// fire fox
		}

		else if (browser.equals("edge")) {
			
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public Amazonsearch website() throws IOException {
		driver = driverIntialize();
		driver.get(url);
		Amazonsearch as = new Amazonsearch(driver);
		return as ;
	}

	public SearchVerification searchVerify() throws Exception {

		driver = driverIntialize();
		driver.get(url);
		SearchVerification search = new SearchVerification(driver);
		return search;
	}

	public String getScreenshot(String testName, WebDriver driver) throws Exception {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "//reports//" + testName + ".png");
		FileUtils.copyFile(fs, destFile);
		System.out.println("Screenshot taken");
		return System.getProperty("user.dir") + "//reports//" + testName + ".png";

	}

	
	 

}
