package com.dss.se2workshop.pop;

import com.dss.se2workshop.pop.pages.*;
import com.dss.se2workshop.util.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FindSpeakerFlowTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void testFindSpeakerFlow() throws Exception {
        HomePage homePage = new HomePage(driver, PropertyLoader.getBaseUrl()).get();
        FindASpeakerPage findASpeakerPage = homePage.findASpeaker();
        SpeakerDetailsPage speakerDetailsPage = findASpeakerPage.showSpeakerDetails("Matt Stine");
        FindKioskBySpeakerPage findKioskBySpeakerPage = speakerDetailsPage.findThisSpeaker();
        ReserveSpeakerPage reserveSpeakerPage = findKioskBySpeakerPage.rentNow();
        LoginPage loginPage = reserveSpeakerPage.continueToSignInOrCreateAccount();
        loginPage.login("joeuser", "password").at();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
