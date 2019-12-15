package CommonUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class TakeScreenshots extends AbstractFirefoxWebDriverTest{

	public static void capture() throws IOException {
		File screenshot = ((TakesScreenshot)driver)
				.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshot,
				new File("C:\\Users\\Veer\\eclipse-workspace\\BasicTest\\target\\screenshot.png"));
		
    }
}
