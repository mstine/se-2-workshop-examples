package com.dss.se2workshop.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindAFluffboxPage {
    private WebDriver driver;

    @FindBy(id = "searchCriteria")
    private WebElement searchCriteria;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    private WebElement findSpeakersHere;

    public FindAFluffboxPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void searchForKiosksIn(String location) throws InterruptedException {
        searchCriteria.clear();
        searchCriteria.sendKeys(location);
        searchButton.click();

        findSpeakersHere = (new WebDriverWait(driver, 60, 1))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.linkText("Find Speakers Here"));
                    }
                });
    }

    public FindSpeakerByKioskPage findSpeakersHere() {
        findSpeakersHere.click();

        return new FindSpeakerByKioskPage(driver);
    }
}
