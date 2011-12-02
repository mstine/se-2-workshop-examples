package com.dss.se2workshop.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindSpeakerByKioskPage {
    private WebDriver driver;

    public FindSpeakerByKioskPage(WebDriver driver) {
        this.driver = driver;
    }

    public SpeakerClonePage showSpeakerDetails(String name) {
        driver.findElement(By.linkText(name)).click();

        return new SpeakerClonePage(driver);
    }
}
