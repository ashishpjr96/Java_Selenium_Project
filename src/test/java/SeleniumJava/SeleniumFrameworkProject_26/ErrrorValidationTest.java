package SeleniumJava.SeleniumFrameworkProject_26;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkProject_26.TestComponents.BaseTest;
import SeleniumJava.PageObjects.CartPage;
import SeleniumJava.PageObjects.ProductCatalouge;
public class ErrrorValidationTest extends BaseTest {
	
	
	
	@Test()
	public void LoginErrorValidation() throws IOException {
		// TODO Auto-generated method stub
        
		
		String prodName="ZARA COAT 3";
		landingPage.loginPage("admin96@gmail.com", "Adminqq@1234");
		Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email or password.");
		}
	
	@Test()
	public void ProductErrorValidation() throws IOException {
		// TODO Auto-generated method stub
        
		
		String prodName="ZARA COAT 3";
		ProductCatalouge productLis=landingPage.loginPage("rahulshetty@gmail.com", "Iamking@000");
	
		productLis.getProductName(prodName);
		CartPage cart=productLis.goToCartPage();
		
		
		boolean match=cart.verifyProductName("ZARA COAT333");
		Assert.assertFalse(match);

	}
}



