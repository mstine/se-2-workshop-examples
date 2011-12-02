package com.dss.se2workshop.pop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReserveSpeakerPage {
    private WebDriver driver;

    @FindBy(linkText = "Continue")
    private WebElement continueToSignInOrCreateAccount;

    public ReserveSpeakerPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public LoginPage continueToSignInOrCreateAccount() {
        continueToSignInOrCreateAccount.click();
        return new LoginPage(driver);
    }
}
