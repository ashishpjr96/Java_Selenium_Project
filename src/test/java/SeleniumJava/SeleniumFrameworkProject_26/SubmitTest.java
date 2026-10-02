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

import SeleniumJava.PageObjects.CartPage;
import SeleniumJava.PageObjects.CheckOutPage;
import SeleniumJava.PageObjects.ConfirmationPage;
import SeleniumJava.PageObjects.LandingPage;
import SeleniumJava.PageObjects.ProductCatalouge;

public class SubmitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		WebDriver driver =new ChromeDriver();
		String prodName="ZARA COAT 3";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		LandingPage landingPage=new LandingPage(driver);
		landingPage.goTo();
		ProductCatalouge productLis=landingPage.loginPage("admin96@gmail.com", "Admin@1234");
	
		productLis.getProductName(prodName);
		CartPage cart=productLis.goToCartPage();
		
		
		boolean match=cart.verifyProductName(prodName);
		Assert.assertTrue(match);
		CheckOutPage check=cart.goToCheckOut();
		check.selectCountry("Indi");
		
		ConfirmationPage confirmationPage =check.submitOrder();
		String confirmationMessage= confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
		
		
	}
}
