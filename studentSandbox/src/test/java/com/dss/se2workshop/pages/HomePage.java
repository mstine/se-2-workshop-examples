package com.dss.se2workshop.pages;

import com.dss.se2workshop.FindASpeakerPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class HomePage extends LoadableComponent<HomePage> {

    private WebDriver driver;
    private String baseUrl;

    @FindBy(css = "h1 > a.headerLink")
    private WebElement findASpeaker;

    @FindBy(xpath = "//a[contains(@href, '/fluffbox-rwx-0.1/kiosk/find')]")
    private WebElement findAKiosk;

    public HomePage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;

        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(baseUrl+"/fluffbox-rwx-0.1/");
    }

    @Override
    protected void isLoaded() throws Error {
        System.out.println(driver.getTitle());
        Assert.assertEquals("Fluffbox", driver.getTitle());
    }

    public FindASpeakerPage findASpeaker() {
        findASpeaker.click();
        return new FindASpeakerPage(driver);
    }

    public FindAKioskPage findAKiosk() {
        findAKiosk.click();
        return new FindAKioskPage(driver);
    }
}
