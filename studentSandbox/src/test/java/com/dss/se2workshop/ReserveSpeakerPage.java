package com.dss.se2workshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReserveSpeakerPage {
    private WebDriver driver;

    public ReserveSpeakerPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage continueToSignInOrCreateAccount() {
        driver.findElement(By.linkText("Continue")).click();
        return new LoginPage(driver);
    }
}
