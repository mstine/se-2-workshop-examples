package com.dss.se2workshop.pop.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class PaymentPage extends LoadableComponent<PaymentPage> {
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void load() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals("This concludes your fake rental experience!", driver.findElement(By.cssSelector("h1")).getText());
    }

    public void at() throws Error {
        isLoaded();
    }
}
