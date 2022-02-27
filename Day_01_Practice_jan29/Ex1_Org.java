package Day_01_Practice_ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ex1_Org {
	
	WebDriver driver;
	
	
  @Test
  public void  Add_Job_Info() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://opensource-demo.orangehrmlive.com/"); 
	  

		findElement(By.name("txtUsername")).sendKeys("admin");
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();	
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys("Team manager");
		findElement(By.id("jobTitle_jobDescription")).sendKeys("testing");
		findElement(By.id("jobTitle_note")).sendKeys("automation");
		findElement(By.id("btnSave")).click();
		
		
		
				
		
		
		
		
  }
  
  
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
	 
		}
		return elem;
	}

  
  
  
  
  
}
