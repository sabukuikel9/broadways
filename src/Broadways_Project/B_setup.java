package Broadways_Project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class B_setup {

	public static WebDriver driver;
	
	public static WebDriver setup(){
		System.setProperty("Webdrive.chrome.driver", ".\\resources\\chromedriver_win32.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}	
	
	@BeforeSuite (alwaysRun = true)
	public static void openbrowser(){

		driver = setup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(URL);
		driver.manage().window().maximize();
	}
	@AfterSuite (alwaysRun = true)
	public static void closebrowser(){
		driver.close();
	}
}

		
		
		




