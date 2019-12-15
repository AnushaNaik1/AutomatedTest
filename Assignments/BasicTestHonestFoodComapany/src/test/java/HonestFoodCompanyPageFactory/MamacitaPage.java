package HonestFoodCompanyPageFactory;

import java.util.Iterator;
import java.util.List;

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
import io.github.bonigarcia.wdm.WebDriverManager;

public class MamacitaPage extends AbstractFirefoxWebDriverTest {
	
	
	WebDriverWait wait;
	
	public MamacitaPage(WebDriver driver) {
		
		AbstractFirefoxWebDriverTest.driver=driver;
		this.wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);
		

		
	}

	
	@FindBy(id="address-input")
	WebElement address;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div[1]/div[2]/form/input[2]")
	WebElement submitPage;
	
	@FindBy(how = How.CLASS_NAME, using = "btn--honest blattgold--form-banner-submit")
	WebElement submitButton;
	
	@FindBy(how = How.XPATH, using = "//button[[contains(.,'Cheesy Pork Burrito')]")
	WebElement CheesyPorkBurrito;
	
	@FindBy(how = How.XPATH, using = "//button[[contains(.,' Wicked Classic Burrito (leicht scharf) ')]")
	WebElement WickedClassicBurrito;
	
	@FindBy(id = "topup-modal--close")
	WebElement addToCartButton;

	@FindBy(className = "item--name")
	WebElement cartItemNames;
	
	//addressPopup
	@FindBy(className = "addressPopup")
	WebElement addressPopup;
	
	public void enterAdress(String add ) {
		address= wait.until(ExpectedConditions.visibilityOf(address));
		address.clear();
		address.sendKeys(add);
		address.click();
		
	}
	public void submit() throws InterruptedException {
		
		submitPage.click();
		
			Thread.sleep(15000);
		
	}
	
	public void selectItem(String itemNeeded) {
		
		String itemXpath=("//button[contains(.,'" + itemNeeded + "')]");
		WebElement item=driver.findElement(By.xpath(itemXpath));
		item = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(itemXpath))));
		item = wait.until(ExpectedConditions.elementToBeClickable(item));
		item.click();
	}
	public void addToCart() throws InterruptedException {
		//Thread.sleep(2000);
		addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 250)");
		Actions action = new Actions(driver);
		action.moveToElement(addToCartButton).click().perform();
		addToCartButton.submit();
	}
	
	public String getAnItem(){
		cartItemNames = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("item--name")));
		
			
			
		return cartItemNames.getText();
		}
		
	}
	

	
	
	
	

