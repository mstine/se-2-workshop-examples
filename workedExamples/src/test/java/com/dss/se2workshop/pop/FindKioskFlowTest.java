package com.dss.se2workshop.pop;

import com.dss.se2workshop.pop.pages.*;
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

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


}
