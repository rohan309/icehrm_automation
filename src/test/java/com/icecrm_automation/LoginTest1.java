package com.icecrm_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest1 {

	public static void main(String[] args) {
		// setup chromedriver file in system class
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\icecrm_automation\\chromedriver.exe");
		// create instance of chrome driver class to launch browser
		WebDriver driver = new ChromeDriver();
		/*
		 * driver.executesScript() //Will not be executed 
		 * Chromedriver driver= new Chromedriver(); 
		 * driver1.executesScript()
		 */
		// navigate to ice hrm website
		driver.get("https://cybersuccess.icehrm.com/");

//1st TC (Valid username and vaalid password)

		WebElement username = driver.findElement(By.id("username"));

		// enter the text (admin) in the username field

		username.sendKeys("admin");

		// enter the text (2zuzfakn) in the password field
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("2zuzfakn");

		// locate the Login button and perform click operation
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton.click();

		// Locating element in page and confirming landed on home page or not
		String logo = driver.findElement(By.xpath("//div[@class='logo logoResponsive']")).getText();
		System.out.println(logo);

		String homeText = driver.findElement(By.xpath("//header[@id='delegationDiv']/a")).getText();
		System.out.println(homeText);

		if (homeText.equals("Home")) {
			System.out.println("Test case is pass");
		} else {
			System.out.println("Test case is fail");
			// throw new Exception("failed to login to application");
		}

		// Thread.sleep(2000);
		// Locating Sign out and performing click operation
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[5]/a/span")).click(); //

		driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();

//2st TC (invalid username and invalid password)

		WebElement username1 = driver.findElement(By.id("username"));
		username1.sendKeys("fdfdf");
		WebElement password1 = driver.findElement(By.id("password"));
		password1.sendKeys("12t482384");
		WebElement loginButton1 = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton1.click();

		String homeText1 = driver.findElement(By.xpath("//div[@class='pb-9']/h3")).getText();
		System.out.println(homeText1);
		if (homeText1.equals("IceHrm Login")) {
			System.out.println("Test case is pass");
		} else {
			System.out.println("Test case is fail");
		}

// 3rd TC (verify login feature with valid username and invalid password)

		WebElement username2 = driver.findElement(By.id("username"));
		username2.sendKeys("admin");
		WebElement password2 = driver.findElement(By.id("password"));
		password2.sendKeys("123y4inrnfl");
		WebElement loginButton2 = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton2.click();

		String homeText2 = driver.findElement(By.xpath("//div[@class='pb-9']/h3")).getText();
		System.out.println(homeText2);
		if (homeText2.equals("IceHrm Login")) {
			System.out.println("Test case is pass");
		} else {
			System.out.println("Test case is fail");
		}
	}

}
