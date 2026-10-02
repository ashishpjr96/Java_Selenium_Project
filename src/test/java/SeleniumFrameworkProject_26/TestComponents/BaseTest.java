package SeleniumFrameworkProject_26.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumJava.PageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException{
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SeleniumJava\\Resources\\Global.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		
	driver =new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//
		}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	}
	
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		LandingPage landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

}
