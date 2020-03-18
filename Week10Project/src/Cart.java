import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Cart extends GammaTestSelenium {
	
	@Test
	public static void testG031() throws Exception { // phone to calculate & apply shipping 
		// add phone to cart
		Home.addPhoneToCart();
		// move to cart
		Home.moveToShoppingCart();
		// expand shipping quote for phone
		driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();
		// enter country - 222 = UK, 223 = US
		Select country = new Select(driver.findElement(By.name("country_id")));
		country.selectByValue("222");
		// enter region - 3951 = county down, 3553 = greater london
		Select region = new Select(driver.findElement(By.name("zone_id")));
		region.selectByValue("3951");

		// enter post code for test case postcode
		driver.findElement(By.id("input-postcode")).sendKeys("sw1 0rt");

		// get quote button clicked
		driver.findElement(By.xpath("//*[@id=\"button-quote\"]")).click();

		// shipping rate
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("#modal-shipping > div > div > div.modal-body > div > label > input[type=radio]")))
				.click();

		// click apply shipping
		driver.findElement(By.xpath("//*[@id=\"button-shipping\"]")).click();
	}
	@Test
	public static void testG032() throws Exception { // phone to cancel shipping calculations
		// add phone to cart
		Home.addPhoneToCart();
		// move to cart
		Home.moveToShoppingCart();
		// expand shipping quote for phone
		driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();
		// enter country - 222 = UK, 223 = US
		Select country = new Select(driver.findElement(By.name("country_id")));
		country.selectByValue("222");
		// enter region - 3951 = county down, 3553 = greater london
		Select region = new Select(driver.findElement(By.name("zone_id")));
		region.selectByValue("3951");

		// enter post code for test case postcode
		driver.findElement(By.id("input-postcode")).sendKeys("sw1 0rt");

		// get quote button clicked
		driver.findElement(By.xpath("//*[@id=\"button-quote\"]")).click();

		// shipping rate
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("#modal-shipping > div > div > div.modal-body > div > label > input[type=radio]")))
				.click();

		// click cancel
		driver.findElement(By.xpath("//*[@id=\"modal-shipping\"]/div/div/div[3]/button")).click();
	}
	@Test
	public static void testG033() throws Exception { // phone calculate shipping with invalid postcode
		Home.addPhoneToCart();
		// move to cart
		Home.moveToShoppingCart();
		// expand shipping quote for phone
		driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();
		// enter country - 222 = UK, 223 = US
		Select country = new Select(driver.findElement(By.name("country_id")));
		country.selectByValue("222");
		// enter region - 3951 = county down, 3553 = greater london
		Select region = new Select(driver.findElement(By.name("zone_id")));
		region.selectByValue("3951");

		// enter post code for test case postcode
		driver.findElement(By.id("input-postcode")).sendKeys("te45 1ng");

		// get quote button clicked
		driver.findElement(By.xpath("//*[@id=\"button-quote\"]")).click();
	}
	@Test
	public static void testG034() throws Exception {// phone calculate shipping with blank postcode
		Home.addPhoneToCart();
		// move to cart
		Home.moveToShoppingCart();
		// expand shipping quote for phone
		driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();
		// enter country - 222 = UK, 223 = US
		Select country = new Select(driver.findElement(By.name("country_id")));
		country.selectByValue("222");
		// enter region - 3951 = county down, 3553 = greater london
		Select region = new Select(driver.findElement(By.name("zone_id")));
		region.selectByValue("3951");

		// enter post code for test case postcode
//		driver.findElement(By.id("input-postcode")).sendKeys("");

		// get quote button clicked
		driver.findElement(By.xpath("//*[@id=\"button-quote\"]")).click();
	}
	@Test
	public static void testG035() throws Exception {// calculate shipping with default inputs
		Home.addPhoneToCart();
		// move to cart
		Home.moveToShoppingCart();
		// expand shipping quote for phone
		driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();
		// waiting for get quote button to be located in order to be clicked
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-quote\"]")));
		// get quote button clicked
		driver.findElement(By.xpath("//*[@id=\"button-quote\"]")).click();
	}
	@Test
	public static void testG036() throws Exception { // open gift cert drop down
		Home.add1ItemToCart();
		// move to cart
		Home.moveToShoppingCart();
		// expand gift cert for laptop
		driver.findElement(By.cssSelector("#accordion > div:nth-child(2) > div.panel-heading > h4 > a")).click();
	}
	@Test
	public static void testG037() throws Exception { // apply blank gift cert
		Home.add1ItemToCart();
		// move to cart
		Home.moveToShoppingCart();
		// expand gift cert for laptop
		driver.findElement(By.cssSelector("#accordion > div:nth-child(2) > div.panel-heading > h4 > a")).click();
		// waiting for button to be found before clicking
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-voucher")));
		// click gift cert apply button
		driver.findElement(By.cssSelector("#button-voucher")).click();
	}
	@Test
	public static void testG038() throws Exception { // invalid gift cert
		Home.add1ItemToCart();
		// move to cart
		Home.moveToShoppingCart();
		// expand gift cert for laptop
		driver.findElement(By.cssSelector("#accordion > div:nth-child(2) > div.panel-heading > h4 > a")).click();
		// enter invalid gift cert
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-voucher\"]")));
		driver.findElement(By.xpath("//*[@id=\"input-voucher\"]")).sendKeys("testing");
		// waiting for
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-voucher")));
		// click gift cert apply button
		driver.findElement(By.cssSelector("#button-voucher")).click();
	}
	@Test
	public static void testG039() throws Exception { // apply valid gift cert --not possible no certificate
		Home.add1ItemToCart();
		// move laptop to cart
		Home.moveToShoppingCart();
		// expand gift cert
		driver.findElement(By.cssSelector("#accordion > div:nth-child(2) > div.panel-heading > h4 > a")).click();
		// enter invalid gift cert
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-voucher\"]")));
		driver.findElement(By.xpath("//*[@id=\"input-voucher\"]")).sendKeys("valid certificate");
		// waiting for
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-voucher")));
		// click gift cert apply button
		driver.findElement(By.cssSelector("#button-voucher")).click();
	}
	@Test
	public static void testG040() throws Exception { // verify checkout button to continue to checkout
		// run test G039
//		testG039();
		Home.add1ItemToCart();
		Home.moveToShoppingCart();
		// waiting for checkout button to be found
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element2 = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("#content > div.buttons.clearfix > div.pull-right > a")));
		// click checkout button
		driver.findElement(By.cssSelector("#content > div.buttons.clearfix > div.pull-right > a")).click();
	}
	@Test
	public static void testG041() throws Exception { // going to checkout with no item
		Home.moveToShoppingCart();
		// wait of checkout button to be found
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element2 = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("#content > div.buttons.clearfix > div.pull-right > a")));
		// click checkout button
		driver.findElement(By.cssSelector("#content > div.buttons.clearfix > div.pull-right > a")).click();
	}
}
