package com.dss.se2workshop;

import com.dss.se2workshop.pages.FindAKioskPage;
import com.dss.se2workshop.pages.HomePage;
import com.dss.se2workshop.util.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindKioskFlowTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void testFindKioskFlow() {
        HomePage homePage = new HomePage(driver, PropertyLoader.getBaseUrl()).get();
        FindAKioskPage findAKioskPage = homePage.findAKiosk();


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
