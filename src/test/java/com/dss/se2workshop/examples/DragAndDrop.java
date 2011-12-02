package com.dss.se2workshop.examples;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.*;
import org.junit.*;

public class DragAndDrop {
	
	@Test
	public void dragAndDrop() throws Exception {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("file:///Users/mstine/Projects/se-2-workshop-examples/src/main/webapp/dnd.html");
		
		WebElement element = driver.findElement(By.id("draggable_demo"));
		WebElement target = driver.findElement(By.id("droppable_demo"));
		
		for (int i = 0; i < 2; i ++) {
			(new Actions(driver)).dragAndDrop(element, target).perform();
			Thread.sleep(5000);
		}
		
		driver.quit();
	}
	
}