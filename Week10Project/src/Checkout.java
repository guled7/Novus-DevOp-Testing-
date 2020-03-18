import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Checkout extends GammaTestSelenium {

	// checkout pages test cases start
		@Test
		public static void testG042() throws Exception { // new register account checkout
			Cart.testG040();
			// check new user(register account)option
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
					"#collapse-checkout-option > div > div > div:nth-child(1) > div:nth-child(3) > label > input[type=radio]")))
					.click();

			// click continue
			driver.findElement(By.xpath("//*[@id=\"button-account\"]")).click();
		}
		@Test
		public static void testG043() throws Exception { // enter account details - no inputs
			testG042();
			// wait for button to be found
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element2 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-register\"]")));
			// click continue
			driver.findElement(By.xpath("//*[@id=\"button-register\"]")).click();
		}
		@Test
		public static void testG044() throws Exception { // enter account details - incorrect inputs - fake details
			testG042();
			int value = random.nextInt(100000);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element1 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-payment-firstname\"]")));

			// first name
			driver.findElement(By.xpath("//*[@id=\"input-payment-firstname\"]")).sendKeys("a");
			// last name
			driver.findElement(By.name("lastname")).sendKeys("b");
			// email
			driver.findElement(By.xpath("//*[@id=\"input-payment-email\"]")).sendKeys("c" + value + "@testing.not");
			// telephone
			driver.findElement(By.name("telephone")).sendKeys("Hello");
			// address
			driver.findElement(By.name("address_1")).sendKeys("Hello");
			// city
			driver.findElement(By.name("city")).sendKeys("Hello");
			// postcode
			driver.findElement(By.name("postcode")).sendKeys("Hello");
			// country
			Select country = new Select(driver.findElement(By.name("country_id")));
			country.selectByValue("222");
			// region
			Select region = new Select(driver.findElement(By.name("zone_id")));
			region.selectByValue("3951");
			// password
			driver.findElement(By.xpath("//*[@id=\"input-payment-password\"]")).sendKeys("qwerty");
			driver.findElement(By.xpath("//*[@id=\"input-payment-confirm\"]")).sendKeys("qwerty");

			WebElement element2 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-register\"]")));
			// click continue
			driver.findElement(By.xpath("//*[@id=\"button-register\"]")).click();
		}
		@Test
		public static void testG045() throws Exception { // testG044 run again with the privacy check-box checked
			testG044();
			// check check-box
			driver.findElement(By.xpath("//*[@id=\"collapse-payment-address\"]/div/div[3]/div/input[1]")).click();
			// wait for continue button
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element2 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-register\"]")));
			// button to continue to next section payment
			driver.findElement(By.xpath("//*[@id=\"button-register\"]")).click();
		}
		@Test
		public static void testG046() throws Exception { // enter account details - real details
			testG042();
			int value = random.nextInt(100000);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element1 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-payment-firstname\"]")));

			// first name
			driver.findElement(By.xpath("//*[@id=\"input-payment-firstname\"]")).sendKeys("MyName");
			// last name
			driver.findElement(By.name("lastname")).sendKeys("MySurname");
			// email
			driver.findElement(By.xpath("//*[@id=\"input-payment-email\"]"))
					.sendKeys("realEmail" + value + "1@testing.yes");
			// telephone
			driver.findElement(By.name("telephone")).sendKeys("Hello");
			// address
			driver.findElement(By.name("address_1")).sendKeys("Hello");
			// city
			driver.findElement(By.name("city")).sendKeys("Somewhere Good");
			// postcode
			driver.findElement(By.name("postcode")).sendKeys("te54 1ng");
			// country
			Select country = new Select(driver.findElement(By.name("country_id")));
			country.selectByValue("222");
			// region
			Select region = new Select(driver.findElement(By.name("zone_id")));
			region.selectByValue("3951");
			// password
			driver.findElement(By.xpath("//*[@id=\"input-payment-password\"]")).sendKeys("RealPassword");
			driver.findElement(By.xpath("//*[@id=\"input-payment-confirm\"]")).sendKeys("RealPassword");

			WebElement element2 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-register\"]")));
			// click continue
			driver.findElement(By.xpath("//*[@id=\"button-register\"]")).click();
		}
		@Test
		public static void testG047() throws Exception { // testG046 run again with privacy check-box checked
			testG046();
			WebDriverWait wait = new WebDriverWait(driver, 5);
//			WebElement element1 = wait
//					.until(ExpectedConditions.elementToBeClickable(By.xpath("// *[@id=\"button-payment-method\"]")));
			// check check-box
			driver.findElement(By.xpath("//*[@id=\"collapse-payment-address\"]/div/div[3]/div/input[1]")).click();
			// wait for continue button
			WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-register")));
			// button to continue to next section payment
			driver.findElement(By.xpath("//*[@id=\"button-register\"]")).click();
		}
		@Test
		public static void testG048() throws Exception { // no payment comment
			testG047();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element2 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("// *[@id=\"button-payment-method\"]")));
			driver.findElement(By.xpath("// *[@id=\"button-payment-method\"]")).click();
		}
		@Test
		public static void testG049() throws Exception { // add comment to payment box and checks terms & conditions check-box
			testG047();
			// wait for elements to be found
			WebDriverWait wait = new WebDriverWait(driver, 5);
			// waiting for the payment
			WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("comment")));
//			// text-box
			driver.findElement(By.name("comment")).sendKeys("trying to make a payment.");
			// terms & conditions check-box
			driver.findElement(By.xpath("// *[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")).click();
			// wait for continue button
			WebElement element2 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("// *[@id=\"button-payment-method\"]")));
			// continue button
			driver.findElement(By.xpath("// *[@id=\"button-payment-method\"]")).click();
		}
		@Test
		public static void testG050() throws Exception { // not working - confirm order
			testG049();
			// can not access the website any further 
			// forced to fail as it cannot continue 
			driver.findElement(By.xpath("// *[@id=\"forced-fail\"]")).click();
		}
		@Test
		public static void testG051() throws Exception { // login as a returning account with no details
			Cart.testG040();
			// waiting for button to be found
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-login\"]"))).click();
			// click returning account login button
			driver.findElement(By.xpath("//*[@id=\"button-login\"]")).click();
		}
		@Test
		public static void testG052() throws Exception { // checkout login with invalid details
			Cart.testG040();
			// waiting for button to be found
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-login\"]"))).click();
			// enter invalid login email
			driver.findElement(By.name("email")).sendKeys("FakeEmail@fail.yes");
			// enter invalid login password
			driver.findElement(By.name("password")).sendKeys("itIsGoingToFail");
			// click returning account login button
			driver.findElement(By.xpath("//*[@id=\"button-login\"]")).click();
		}
		@Test
		public static void testG053() throws Exception { // checkout login with correct details
			Cart.testG040();
			// waiting for login button to be found
			WebDriverWait wait = new WebDriverWait(driver, 10);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-login\"]")));
			// enter login email
			driver.findElement(By.name("email")).sendKeys("testAuto@project.com"); // temp email account could be deleted
			// enter login password
			driver.findElement(By.name("password")).sendKeys("Project10"); // temp password account could be deleted
			WebElement element1 = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"button-login\"]")));
			// click returning account login button
			driver.findElement(By.xpath("//*[@id=\"button-login\"]")).click();
		}
		@Test
		public static void testG054() throws Exception { // returning account billing details - no input
			testG053();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element1 = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-payment-address")));
			// radio button for new address
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label"))).click();
			// click continue
			driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
		}
		@Test
		public static void testG055() throws Exception { // returning account with incorrect billing details
			testG053();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element1 = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-payment-address")));
			// radio button for new address
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label"))).click();

			// first name
			driver.findElement(By.name("firstname")).sendKeys("weekten");
			// last name
			driver.findElement(By.name("lastname")).sendKeys("test");
			// address
			driver.findElement(By.name("address_1")).sendKeys("somewhere that doesn't matter");
			// city
			driver.findElement(By.name("city")).sendKeys("some city");
			// post code
			driver.findElement(By.name("postcode")).sendKeys("te 1ng");
			// country
			Select country = new Select(driver.findElement(By.name("country_id")));
			country.selectByValue("222");
			// region
			Select region = new Select(driver.findElement(By.name("zone_id")));
			region.selectByValue("3951");
			// click returning account continue button
			driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
		}
		@Test
		public static void testG056() throws Exception { // returning account wit correct billing details
			testG053();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element1 = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-payment-address")));
			// radio button for new address
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label"))).click();

			// first name
			driver.findElement(By.name("firstname")).sendKeys("Project");
			// last name
			driver.findElement(By.name("lastname")).sendKeys("Auto");
			// address
			driver.findElement(By.name("address_1")).sendKeys("99 somewhere that doesn't matter street");
			// city
			driver.findElement(By.name("city")).sendKeys("some city");
			// post code
			driver.findElement(By.name("postcode")).sendKeys("te54 1ng");
			// country
			Select country = new Select(driver.findElement(By.name("country_id")));
			country.selectByValue("222");
			// region
			Select region = new Select(driver.findElement(By.name("zone_id")));
			region.selectByValue("3951");
			// click returning account continue button
			driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
		}
		@Test
		public static void testG057() throws Exception { //returning customer continuing with no payment comment 
			testG056();
			// wait for button for payment is found then clicked
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("// *[@id=\"button-payment-method\"]"))).click();
		}
		@Test
		public static void testG058() throws Exception { 
			testG056();
			// wait to be found then for check-box to be check
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")))
					.click();

			// wait for button for payment is found then clicked
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("// *[@id=\"button-payment-method\"]"))).click();
		}
		@Test
		public static void testG059() throws Exception {// not working - confirm order
			testG058();
			// can not access the website any further 
			//forced fail as it cannot continue 
			driver.findElement(By.xpath("// *[@id=\"forced-fail\"]")).click();
		}
}
