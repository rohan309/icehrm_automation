package com.icecrm_automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotClass {

	public static void main(String[] args) throws AWTException 
	{ System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.facebook.com/login/");
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  actions.contextClick(driver.findElement(By.linkText("Forgotten account?"))).build().perform();
	  
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_DOWN);
	  robot.keyPress(KeyEvent.VK_DOWN);
	  robot.keyRelease(KeyEvent.VK_DOWN);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  
	  //robot.mouseMove(200, 300);
	}

}
