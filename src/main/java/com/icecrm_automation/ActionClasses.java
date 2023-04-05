package com.icecrm_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClasses
{
    public static void main( String[] args ) throws InterruptedException
    { System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	/*
	 * driver.navigate().to("https://cybersuccess.icehrm.com/");
	 * driver.manage().window().maximize();
	 * driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
	 * driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("2zuzfakn"
	 * );
	 * //driver.findElement(By.xpath("//button[contains(text(),'Log in ')]")).click(
	 * );
	 * 
	 * Actions actions = new Actions(driver);
	 * //actions.moveToElement(driver.findElement(By.
	 * xpath("//button[contains(text(),'Log in ')]"))).build().perform();
	 * //actions.click(driver.findElement(By.
	 * xpath("//button[contains(text(),'Log in ')]"))).build().perform(); //running
	 * successfully //actions.contextClick().build().perform(); //for right click
	 * //actions.contextClick(driver.findElement(By.
	 * xpath("//button[contains(text(),'Log in ')]"))).build().perform();
	 */    
	
    driver.get("https://rohan1234.agilecrm.com/login");
    driver.manage().window().maximize();
    driver.findElement(By.name("email")).sendKeys("rohan1234@yopmail.com");
    driver.findElement(By.name("password")).sendKeys("Rohan1234");
    driver.findElement(By.xpath("//input[@value='Sign In']")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.id("dealsmenu")).click();
    Thread.sleep(5000);
    
    WebElement source = driver.findElement(By.xpath("//a[contains(text(),'ABC')]"));
    WebElement destination = driver.findElement(By.xpath("//a[contains(text(),'Deal1')]"));
    
    Actions actions = new Actions(driver);
    //actions.clickAndHold(source).release(destination).build().perform();
    actions.dragAndDrop(source, destination).build().perform();
    }
}
