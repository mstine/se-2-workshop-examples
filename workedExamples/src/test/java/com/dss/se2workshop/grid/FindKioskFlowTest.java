package com.dss.se2workshop.grid;

import com.dss.se2workshop.pop.pages.*;
import com.dss.se2workshop.util.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class FindKioskFlowTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
    }

    @Test
    public void testFindKioskFlow() throws Exception {
        HomePage homePage = new HomePage(driver, PropertyLoader.getBaseUrl()).get();
        FindAFluffboxPage findAFluffboxPage = homePage.findAFluffbox();

        findAFluffboxPage.searchForKiosksIn("Ft. Lauderdale");
        FindSpeakerByKioskPage findSpeakerByKioskPage = findAFluffboxPage.findSpeakersHere();

        SpeakerClonePage speakerClonePage = findSpeakerByKioskPage.showSpeakerDetails("Matt Stine");
        ReserveSpeakerPage reserveSpeakerPage = speakerClonePage.rentNow();
        LoginPage loginPage = reserveSpeakerPage.continueToSignInOrCreateAccount();
        loginPage.login("joeuser", "password").at();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }


}
