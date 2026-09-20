package SeleniumJava.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumJava.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{

	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		  super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css = ".ta-results button")
	List<WebElement> countryLists;			
	
	public void selectCountry(String countryNamee)
	{
	    selectCountry.sendKeys(countryNamee);

	    waitForElementsToAppear(countryLists);

	    for(WebElement countryName : countryLists)
	    {
	        if(countryName.getText().equalsIgnoreCase("India"))
	        {
	            countryName.click();
	            break;
	        }
	    }
	}
		
	
}
