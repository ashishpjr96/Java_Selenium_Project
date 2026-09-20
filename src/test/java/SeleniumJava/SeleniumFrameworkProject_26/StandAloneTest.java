package SeleniumJava.SeleniumFrameworkProject_26;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumJava.PageObjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		WebDriver driver =new ChromeDriver();
		String prodName="ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage=new LandingPage(driver);
		driver.findElement(By.xpath("//*[@formcontrolname='userEmail']")).sendKeys("admin96@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Admin@1234");
		driver.findElement(By.cssSelector("#login")).click();
		List<WebElement>productList=driver.findElements(By.cssSelector(".col-lg-4"));
		for(WebElement productName :productList)
		{
			if(productName.findElement(By.tagName("b")).getText().equalsIgnoreCase(prodName))
			{
				productName.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				break;
			}
			else
			{
				System.out.println("Product not Found !!! ");
			}
		}
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));  //element click intercepted (for loading spinner)
		driver.findElement(By.xpath("(//*[contains(@class,'btn btn-custom')])[3]")).click();
		
		
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		 boolean match= cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(prodName));
		 Assert.assertTrue(match);	
		 
		 driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
		 
		 driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("Indi");
		 
		//List<WebElement>countryList=driver.findElements(By.cssSelector(".ng-star-inserted"));
			List<WebElement>countryList= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results button")));
			
			
			for(WebElement countryName:countryList)
		{
			if( countryName.getText().equalsIgnoreCase("India"))
			{
				countryName.click();
				break;
			}
		}
		 
	
	}

}
