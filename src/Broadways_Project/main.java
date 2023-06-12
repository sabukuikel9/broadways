package Broadways_Project;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class main extends B_setup {
	
	
	//Verify if users are able to login
	@Test(priority=1)
	public static void login() {
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();	
	}
	
	
	//verify if admin is able to add other new admin
	@Test(priority=2)
	public static void adminManagement() throws InterruptedException {
		driver.findElement(By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[1]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).sendKeys(Keys.RETURN);
		
		//selecting option from dropdown 
		WebElement sel_role = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
		sel_role.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		
		WebElement emp_name = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])"));
		emp_name.sendKeys("a");
		Thread.sleep(3000);
		emp_name.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		Thread.sleep(1000);
		
		WebElement status = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")); 
		status.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		
		driver.findElement(By.xpath("(//input[@autocomplete='off'])[1]")).sendKeys("Shree&123");
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Shree&123");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Shree&123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
	}
	
	
	//verify if the admin is able to search the admin
	@Test(priority=3)
	public static void search_user(){
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Shree&123");
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
	}
	
	
	//Verify if admin is able to add employee
	@Test(priority=4)
	public static void add_employee() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])")).sendKeys("Shivani");
		driver.findElement(By.xpath("(//input[@name='middleName'])")).sendKeys("Kumari");
		driver.findElement(By.xpath("(//input[@name='lastName'])")).sendKeys("Sharma");
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("111");
		
		//upload an image
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).sendKeys(".\\resources\\image.jpg");
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
	}
	
	
	//verify if the admin is able to add a vacancy
	@Test(priority=5)
	public static void recruiment() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@class = 'oxd-main-menu-item'])[4]")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[2]")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--secondary'])")).click();
		driver.findElement(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]")).sendKeys("CEO");
		//Selecting the options from drop down, it does not respond for this website, for this website user must select option manually
		WebElement job_title = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")); 
		Thread.sleep(2000);
		job_title.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.RETURN); 
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("(//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'])")).sendKeys("We are looking for an experienced Chief Executive Officer or CEO to supervise and control all strategic and business aspects of the company.");
		
		WebElement hiring_manager = driver.findElement(By.xpath("//input[@placeholder = 'Type for hints...']"));
		hiring_manager.sendKeys("a");
		Thread.sleep(2000);
		hiring_manager.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[3]")).sendKeys("1");
		driver.findElement(By.xpath("(//span[@class = 'oxd-switch-input oxd-switch-input--active --label-right'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type = 'submit'])")).click();	
	}
	
	
	//verify if the admin is able to search the added vacancy
	@Test(priority=6)
	public static void search_added_vacancy() throws InterruptedException {
		driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab']")).click();
		driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab']")).click();
		
		WebElement job_title = driver.findElement(By.className("oxd-select-text-input")); 
		Thread.sleep(2000);
		job_title.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}
}