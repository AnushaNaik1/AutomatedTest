package CommonUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractFirefoxWebDriverTest {

  protected static WebDriver driver;

  public AbstractFirefoxWebDriverTest() {
    super();
  }

  @BeforeTest
  public void beforeTest() {
    //Download the web driver executable
    WebDriverManager.firefoxdriver().setup();
    
    //Create a instance of your web driver - chrome
    driver = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
    driver.quit();
  }
  
  public void sleep(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}