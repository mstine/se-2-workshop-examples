package com.dss.se2workshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindASpeakerPage {
    private WebDriver driver;

    public FindASpeakerPage(WebDriver driver) {
        this.driver = driver;
    }

    public SpeakerDetailsPage showDetailsFor(String speaker) {
        driver.findElement(By.linkText(speaker)).click();

        return new SpeakerDetailsPage(driver);
    }
}
