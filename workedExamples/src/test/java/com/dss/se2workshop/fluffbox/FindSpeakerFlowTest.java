package com.dss.se2workshop.fluffbox;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FindSpeakerFlowTest {
	private WebDriver driver;
	private String baseUrl="http://localhost:8080";
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testFindSpeakerFlow() throws Exception {
		driver.get(baseUrl+"/fluffbox-rwx/");
		driver.findElement(By.cssSelector("h1 > a.headerLink")).click();
		driver.findElement(By.linkText("Matt Stine")).click();
		driver.findElement(By.linkText("Find this Speaker")).click();
		driver.findElement(By.linkText("RENT NOW")).click();
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
