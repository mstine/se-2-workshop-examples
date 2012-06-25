package com.dss.se2workshop;

import com.dss.se2workshop.pages.HomePage;
import com.dss.se2workshop.util.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class FindSpeakerFlowTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
    }

    @Test
    public void testFindSpeakerFlow() throws Exception {
        HomePage homePage = new HomePage(driver, PropertyLoader.getBaseUrl()).get();
        FindASpeakerPage findASpeakerPage = homePage.findASpeaker();
        SpeakerDetailsPage speakerDetailsPage = findASpeakerPage
                .showDetailsFor("Craig Walls");
        FindKioskBySpeakerPage findKioskBySpeakerPage =
                speakerDetailsPage.findThisSpeaker();
        ReserveSpeakerPage reserveSpeakerPage =
                findKioskBySpeakerPage.rentNow();
        LoginPage loginPage = reserveSpeakerPage.continueToSignInOrCreateAccount();
        loginPage.login("joeuser", "password");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
