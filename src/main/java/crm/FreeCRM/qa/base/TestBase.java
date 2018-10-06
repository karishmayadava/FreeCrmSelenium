package crm.FreeCRM.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import crm.FreeCRM.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
public	static Properties prop;
	
	public TestBase() throws IOException{
		prop = new Properties();
		FileReader fis =new FileReader(System.getProperty("user.dir")+"/src/main/java/crm/FreeCRM/qa/config/config.properties");
		prop.load(fis);
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium2018\\setup\\set\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.firefox.driver","E:\\Selenium2018\\setup\\set\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("ie")){
			System.setProperty("webdriver.ie.driver","E:\\Selenium2018\\setup\\set\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
             driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

		
	}

}
