package com.dss.se2workshop.pop.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class HomePage extends LoadableComponent<HomePage> {

    @FindBy(css = "h1 > a.headerLink")
    private WebElement findASpeaker;

    @FindBy(xpath = "//a[contains(@href, '/fluffbox-rwx/kiosk/find')]")
    private WebElement findAFluffbox;

    private WebDriver driver;
    private String baseUrl;

    public HomePage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;

        PageFactory.initElements(driver, this);
    }

    public FindASpeakerPage findASpeaker() {
        findASpeaker.click();
        return new FindASpeakerPage(driver);
    }

    @Override
    protected void load() {
        driver.get(baseUrl + "/fluffbox-rwx/");
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals("Fluffbox", driver.getTitle());
    }

    public FindAFluffboxPage findAFluffbox() {
        findAFluffbox.click();
        return new FindAFluffboxPage(driver);
    }
}
