package com.orangehrm_automation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.icecrm_automation.utility.BaseClass;
import com.icecrm_automation.utility.PropertyHandling;
import com.orangehrm_automation.pages.MyInfoPage;
import com.orangehrm_automation.pages.OrageHrmLoginPage;

public class FileUploadTest extends BaseClass{
	
	OrageHrmLoginPage orangeHrmLoginPage;
	MyInfoPage myInfoPage;
	PropertyHandling property;
	
	@BeforeClass
	public void beforClass() {
		orangeHrmLoginPage = new OrageHrmLoginPage();
		myInfoPage = new MyInfoPage();
		property = new PropertyHandling();
		String username = property.getProperties("orangeHrmUN");
		String password= property.getProperties("orangeHrmPW");
		String browser= property.getProperties("browser");
		String url = property.getProperties("orangeHrmUrl");
		launchBrowser(browser);
		driver.get(url);
		orangeHrmLoginPage.login(username, password);
	}
	
	@Test
	public void fileUpload() {
		click(myInfoPage.myInfoMenu);
		click(myInfoPage.profileImg);
		click(myInfoPage.addImg);
		this.fileUpload("C:\\Users\\Admin\\Desktop\\Capture.PNG");
		System.out.println("File Uploaded successfully...");
	}

}
