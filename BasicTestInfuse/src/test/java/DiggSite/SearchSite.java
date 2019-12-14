package DiggSite;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtilities.AbstractFirefoxWebDriverTest;

public class SearchSite extends AbstractFirefoxWebDriverTest {
  @Test
  public void  searchCameraFromSearchBox(){
	  driver.get("https://digg.com/channel/technology");
	  WebElement search = driver.findElement(By.className("main-navigation__secondary-search"));
	  search.click();
	  WebElement searchTextBox = driver.findElement(By.xpath("//input[@type='search']"));
	  searchTextBox.clear();
	  searchTextBox.sendKeys("Camera" + Keys.ENTER);
		  
  }
	  
	  @Test
	  public void  subHedingLongReads(){
		  driver.get("https://digg.com/channel/technology");
		  
		  WebElement search = driver.findElement(By.className("main-navigation__primary"));
		  search.click();
		  WebElement searchTextBox = driver.findElement(By.xpath("//li/a[text()='Long Reads']"));
		  searchTextBox.click();
		  String heading = driver.findElement(By.xpath("//h1")).getText();
		//h1
		  Assert.assertEquals(heading,"Long Reads");
	  
	  }
	  
	  @Test
	  public void  subHedingPhotos(){
		  driver.get("https://digg.com/channel/technology");
		  
		  WebElement search = driver.findElement(By.className("main-navigation__primary"));
		  search.click();
		  WebElement searchTextBox = driver.findElement(By.xpath("//li/a[text()='Photos']"));
		  searchTextBox.click();
		  String heading = driver.findElement(By.xpath("//h1")).getText();
		//h1
		  Assert.assertEquals(heading,"Photos");
	  
	  }
	  @Test
	  public void  subHedingPhot(){
		  driver.get("https://digg.com/channel/technology");
		  
		  WebElement search = driver.findElement(By.className("main-navigation__primary"));
		  search.click();
		  WebElement searchTextBox = driver.findElement(By.xpath("//li/a[text()='Science']"));
		  searchTextBox.click();
		  String heading = driver.findElement(By.xpath("//h1")).getText();
		//h1
		  Assert.assertEquals(heading,"Science");
	  
	  }
	  
	  
	  
	  
}
