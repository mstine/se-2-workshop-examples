package com.dss.se2workshop.grid;

import com.dss.se2workshop.pop.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FindSpeakerFlowTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
    }

    @Test
    public void testFindSpeakerFlow() throws Exception {
        HomePage homePage = new HomePage(driver, "http://localhost:8080").get();
        FindASpeakerPage findASpeakerPage = homePage.findASpeaker();
        SpeakerDetailsPage speakerDetailsPage = findASpeakerPage.showSpeakerDetails("Matt Stine");
        FindKioskBySpeakerPage findKioskBySpeakerPage = speakerDetailsPage.findThisSpeaker();
        ReserveSpeakerPage reserveSpeakerPage = findKioskBySpeakerPage.rentNow();
        LoginPage loginPage = reserveSpeakerPage.continueToSignInOrCreateAccount();
        loginPage.login("joeuser", "password").at();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

}
