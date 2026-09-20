package SeleniumJava.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumJava.AbstractComponents.AbstractComponents;

public class ProductCatalouge extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalouge(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy (css=".col-lg-4")
	List<WebElement> productList;
	
	
	By toastMessage =By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")    
	WebElement spinner;
	
	/*
	 * @FindBy (xpath="//*[contains(@class,'btn btn-custom')])[3]") WebElement Cart;
	 */
	
	public List<WebElement> getProductList()
	
	{
		return productList;
	}
	
	public void getProductName (String productNaam)
	{
		for(WebElement productName :productList)
		{
			if(productName.findElement(By.tagName("b")).getText().equalsIgnoreCase(productNaam))
			{
				productName.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				break;
			}
			
		}
		
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}
	
	
	
}
