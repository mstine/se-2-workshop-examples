package com.dss.se2workshop.pop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpeakerClonePage {
    private WebDriver driver;

    @FindBy(linkText = "RENT NOW!")
    private WebElement rentNow;

    public SpeakerClonePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public ReserveSpeakerPage rentNow() {
        rentNow.click();

        return new ReserveSpeakerPage(driver);
    }
}
