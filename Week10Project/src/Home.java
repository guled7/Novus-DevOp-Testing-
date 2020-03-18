

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Home extends GammaTestSelenium{
	// move to cart
//	@Test
	public static void moveToShoppingCart() throws Exception {	
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a")).click();
	} 
	
	// laptop to cart page
//	@Test
	public static void add1ItemToCart() { 
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")).click();
	}
	// phone to cart page (for shipping test cases)
	public static void addPhoneToCart() { 
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")).click();
	}

}
