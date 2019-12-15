package HonestFoodCompany.BasicTest;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import HonestFoodCompanyPageFactory.HomePage;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtilities.AbstractFirefoxWebDriverTest;
import HonestFoodCompanyPageFactory.HomePage;
import HonestFoodCompanyPageFactory.MamacitaPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class addToCartTest extends AbstractFirefoxWebDriverTest{
	
	 

  @Test
  @Parameters("dishName")
  public void addToCartFuntion(String dishName) throws InterruptedException {
	  
	  HomePage homePage;
	  MamacitaPage mamacitaPage;
	  //set the driver
	  driver.get("https://clubkitchen.at/");
	  homePage=new HomePage(driver);
	  
	  //maximizing he window
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //closing the cookie
		if(driver.findElement(By.className("agree-cookie"))!=null) {
			WebElement cookie = driver.findElement(By.className("agree-cookie"));
			cookie.click();
			
		}
		
		homePage=new HomePage(driver);
		
		//Selecting Mamacita by image 
		homePage.navigateMamacitaByImage();
		driver.get("https://clubkitchen.at/speisekarte/mamacita/wallenstein/");
		
		mamacitaPage= new MamacitaPage(driver);
		
		
		//entering the address
		mamacitaPage.enterAdress("Semperstraße 44, 1180 Wien, Austria");
		mamacitaPage.submit();
		
		
		//selecting the "Cheesy Pork Burrito"
		mamacitaPage= new MamacitaPage(driver);
		mamacitaPage.selectItem(dishName);
		
		//adding to cart
		mamacitaPage.addToCart();
		
		//verifying "Cheesy Pork Burrito" is in the cart
		AssertJUnit.assertEquals(mamacitaPage.getAnItem(), dishName);
			
	
  }

 }


