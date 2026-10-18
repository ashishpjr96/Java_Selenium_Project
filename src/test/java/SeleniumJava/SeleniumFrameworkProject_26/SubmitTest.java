package SeleniumJava.SeleniumFrameworkProject_26;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkProject_26.TestComponents.BaseTest;
import SeleniumJava.PageObjects.CartPage;
import SeleniumJava.PageObjects.CheckOutPage;
import SeleniumJava.PageObjects.ConfirmationPage;
import SeleniumJava.PageObjects.LandingPage;
import SeleniumJava.PageObjects.OrdersPage;
import SeleniumJava.PageObjects.ProductCatalouge;

public class SubmitTest extends BaseTest{
	String prodName="ZARA COAT 3";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void SubmitTest(HashMap<String,String>input) throws IOException {
		// TODO Auto-generated method stub
        
		
	
		ProductCatalouge productLis=landingPage.loginPage(input.get("email"),input.get("password") );
	
		productLis.getProductName(input.get("productName"));
		CartPage cart=productLis.goToCartPage();
		
		
		boolean match=cart.verifyProductName(input.get("productName"));
		Assert.assertTrue(match);
		
		CheckOutPage check=cart.goToCheckOut();
		check.selectCountry("Indi");
		
		ConfirmationPage confirmationPage =check.submitOrder();
		String confirmationMessage= confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
		//driver.close();
		
		
	}
	
	@Test (dependsOnMethods={"SubmitTest"})
	public void orderHistroyTest()
	{
		ProductCatalouge productLis=landingPage.loginPage("admin96@gmail.com", "Admin@1234");
		OrdersPage ordersPage=productLis.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrderList(prodName));
	}
	
	
	@DataProvider()
    public Object[][] getData()
	{
		HashMap<Object,Object> map =new HashMap<Object,Object>();
		map.put("email","admin96@gmail.com");
		map.put("password","Admin@1234");
		map.put("productName","ZARA COAT 3");
		
		
		HashMap<Object,Object> map1 =new HashMap<Object,Object>();
		map1.put("email","rahulshetty@gmail.com");
		map1.put("password","Iamking@000");
		map1.put("productName","iphone 13 pro");
		
		return new Object[][] {{map} ,{map1} };
	}
	
}
