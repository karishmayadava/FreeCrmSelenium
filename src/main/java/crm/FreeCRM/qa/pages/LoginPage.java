package crm.FreeCRM.qa.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.FreeCRM.qa.base.TestBase;

public class LoginPage extends TestBase


{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	

	public LoginPage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	

	public HomePage login(String un,String psw){
		username.sendKeys(un);
		password.sendKeys(psw);
		loginButton.click();
		
		//JavascriptExecutor js =(JavascriptExecutor)driver;
		//js.executeScript("argument[0].click();", loginButton);
		return new HomePage();
		
	}
	
	public static List findAllLinks(WebDriver driver){
		List<WebElement> elementList = new ArrayList();
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> finalList = new ArrayList();
		
		for(WebElement element :elementList){
			if(element.getAttribute("href")!=null){
				finalList.add(element);
			}
		}
		
		return finalList;
		
	}
	public static String isLinkBroken(URL url) throws IOException{
		
		String response = "";
		HttpURLConnection connection= (HttpURLConnection)url.openConnection();
		connection.connect();
		response = connection.getResponseMessage();
		connection.disconnect();
		return response;
	}
	
}
