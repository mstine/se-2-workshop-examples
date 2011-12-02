package com.dss.se2workshop.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindASpeakerPage {
    private WebDriver driver;

    public FindASpeakerPage(WebDriver driver) {
        this.driver = driver;
    }

    public SpeakerDetailsPage showSpeakerDetails(String name) {
        driver.findElement(By.linkText(name)).click();

        return new SpeakerDetailsPage(driver);
    }
}
