package SeleniumFrameworkProject_26.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleniumJava.PageObjects.LandingPage;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	
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
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		
		//reading json to String
	String jsonContent=	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	
	
	//converting string to hashmap using jackson data bind dependency
	
	ObjectMapper mapper =new ObjectMapper();
	
	List<HashMap<String,String>> data =mapper.readValue( jsonContent, new TypeReference< List <HashMap<String, String>>> () 
	{
	} );
	return data;
		
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file =new File(System.getProperty("user.dir//") +"//reports//"+testCaseName+ ".png");
		FileUtils.copyFile(source,file);
		return System.getProperty("user.dir//") +"//reports//"+testCaseName+ ".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
         landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	}


