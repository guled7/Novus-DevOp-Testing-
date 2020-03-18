
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GammaTestSelenium {
	public static WebDriver driver;
	static Random random = new Random();

//	public static void main(String[] args) throws Exception {
//		setUp();
//		Cart.testG034(driver);
//		Thread.sleep(5000);
//		shutDown(driver);
//	}
	@Test
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"");
		driver = new ChromeDriver();
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
//		return driver;
	}

	@Test
	public static void shutDown() {
		driver.close();
		
	}
	@Test
	public static void endOfTests() {
		System.out.println("Tests end check results folder!");
	}
	

}
