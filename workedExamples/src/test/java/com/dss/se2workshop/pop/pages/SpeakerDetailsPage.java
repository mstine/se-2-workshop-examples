package com.dss.se2workshop.pop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpeakerDetailsPage {
    private WebDriver driver;

    @FindBy(linkText = "Find this Speaker")
    private WebElement findThisSpeaker;

    public SpeakerDetailsPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public FindKioskBySpeakerPage findThisSpeaker() {
        findThisSpeaker.click();

        return new FindKioskBySpeakerPage(driver);
    }
}
