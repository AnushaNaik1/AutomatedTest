package HonestFoodCompanyPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtilities.AbstractFirefoxWebDriverTest;



public class HomePage extends AbstractFirefoxWebDriverTest{
	
	
	WebDriverWait wait;
	
	
	public HomePage(WebDriver driver) {
		
		AbstractFirefoxWebDriverTest.driver=driver;
		 this.wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);
		
		
	}

	
	@FindBy(how = How.XPATH, using = "//a[@href='/speisekarte/mamacita/wallenstein/' and @class='banner--link']")
	WebElement MamacitaImage;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/speisekarte/mamacita/wallenstein/' and @class='banner--link']")
	WebElement MamacitaButton;


	public void navigateMamacitaByImage() {
		MamacitaImage= wait.until(ExpectedConditions.visibilityOf(MamacitaImage));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 250)");
		 Actions action = new Actions(driver);
		 action.moveToElement(MamacitaImage).click().perform();
	}
	
	public void navigateMamacitaByButton() {
		MamacitaButton= wait.until(ExpectedConditions.visibilityOf(MamacitaButton));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 750)");
		 Actions action = new Actions(driver);
		 action.moveToElement(MamacitaButton).click().perform();
	}
}
