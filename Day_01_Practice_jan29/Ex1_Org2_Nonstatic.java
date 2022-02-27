package Day_01_Practice_ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ex1_Org2_Nonstatic {
	
	WebDriver driver;
	String TestUrl="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin";
	String Password="admin123";
	String  Jobtitle="team lead";
	String JobDes="testing info";
	String JobNote="types of testing";
	
  @Test
  public void  Add_Job_Info() throws Exception {
	  
	 
	  Ex1_Org2_Nonstatic  T1=new Ex1_Org2_Nonstatic();
	  
	  T1.OpenChrome();
	  T1.OpenOrangeHRM(TestUrl);
	  T1.Login(UserName,Password);
	  T1.AddJobDetails();
	  T1.AddJobDetailsInfo(Jobtitle,JobDes,JobNote);

		
			
		
  }
  public void  OpenChrome() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	  
  }
  
  
 public void  OpenOrangeHRM(String TestUrl ) throws Exception {
	  
	 driver.get(TestUrl); 
  }
 public void  Login(String UserName,String Password ) throws Exception {
	  
	 findElement(By.name("txtUsername")).sendKeys(UserName);
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();	
 }
 public void  AddJobDetails() throws Exception {
	  
	 findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
 }
 public void  AddJobDetailsInfo(String Jobtitle,String JobDes,String  JobNote ) throws Exception {
		findElement(By.id("jobTitle_jobTitle")).sendKeys(Jobtitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDes);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote);
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
