package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FindKioskFlowTest {
	private WebDriver driver;
	private String baseUrl="http://localhost:8080";
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testFindKioskFlow() throws Exception {
		driver.get(baseUrl+"/fluffbox-rwx/");
		driver.findElement(By.xpath("//a[contains(@href, '/fluffbox-rwx/kiosk/find')]")).click();
		driver.findElement(By.id("searchCriteria")).clear();
		driver.findElement(By.id("searchCriteria")).sendKeys("Ft. Lauderdale");
		driver.findElement(By.id("searchButton")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.linkText("Find Speakers Here"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.linkText("Find Speakers Here")).click();
		driver.findElement(By.linkText("Matt Stine")).click();
		driver.findElement(By.linkText("RENT NOW!")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("joeuser");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("loginButton")).click();
		assertEquals("This concludes your fake rental experience!", driver.findElement(By.cssSelector("h1")).getText());
		
		driver.findElement(By.linkText("Logout")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
