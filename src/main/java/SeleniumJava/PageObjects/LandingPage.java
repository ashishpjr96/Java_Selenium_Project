package SeleniumJava.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJava.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{    super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElement userEmail= driver.findElement(By.xpath("//*[@formcontrolname='userEmail']"));
	
   @FindBy(xpath="//*[@formcontrolname='userEmail']")
   WebElement userEmail;
   
   @FindBy(id="userPassword")
   WebElement userPassword;
   
   @FindBy(css="#login")
   WebElement loginButton;
   
   @FindBy(xpath="//div[@id='toast-container']")
   WebElement errorToast;
   
   public ProductCatalouge loginPage(String emailID,String password) {
	   
	   userEmail.sendKeys(emailID);
	   userPassword.sendKeys(password);
	   loginButton.click();
	   ProductCatalouge productLis=new ProductCatalouge(driver);
	   return productLis;
   }
   
   public void goTo()
   {
		driver.get("https://rahulshettyacademy.com/client");
   }
   
   public String getErrorMessage() {
	   
	   waitForWebElementToAppear(errorToast);
	  return errorToast.getText();
   }
   
}
