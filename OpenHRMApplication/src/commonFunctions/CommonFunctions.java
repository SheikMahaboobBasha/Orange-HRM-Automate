package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	public static WebDriver driver=null;
	public static Properties properties=null;
	
	public Properties loadPropertyFile() throws IOException {
		FileInputStream fileinputstream = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fileinputstream);
		return properties;
	}

	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		loadPropertyFile();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		//String driverLocation = properties.getProperty("driverLocation");

if (browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\ELCOT\\eclipse-workspace\\OpenHRMApplication\\Driver\\chromedriver.exe");
	driver= new ChromeDriver();
	

}else if (browser.equalsIgnoreCase("firefox")) {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\ELCOT\\eclipse-workspace\\OpenHRMApplication\\Driver\\geckodriver.exe");
	driver=new FirefoxDriver();
}

driver.manage().window().maximize();
driver.get(url);
}

	
	@AfterSuite
	public void teardown() {

	}








}
