package TestCasesForFunctionalTesting;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.FreeCRM.qa.base.TestBase;
import crm.FreeCRM.qa.pages.LoginPage;

public class LoginPageTestCase extends TestBase{
	LoginPage loginPage;
	

	public LoginPageTestCase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	void setUp() throws IOException{
		initialization();
		loginPage = new LoginPage();
		
	}

	@Test (priority=1)
	public void validateLogin(){
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test (priority= 2)
	public void validateLinks() throws MalformedURLException, IOException{
	List<WebElement> allImages=loginPage.findAllLinks(this.driver);
	System.out.println("Total no of elements found" +allImages.size());
	for(WebElement element : allImages){
		System.out.println("URL: "+element.getAttribute("href")+ "returned" +loginPage.isLinkBroken(new URL(element.getAttribute("href"))));
	}
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
}
