package Day_01_Practice_ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ex1_Org2_Static2 {
	
	 static WebDriver driver;
	String TestUrl="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin";
	String Password="admin123";
	String  Jobtitle="team lead";
	String JobDes="testing info";
	String JobNote="types of testing";
	
  @Test
  public void  Add_Job_Info() throws Exception {
	  
	 
		  
	  Ex1_Org2_Static2.OpenChrome();
	  Ex1_Org2_Static2.OpenOrangeHRM(TestUrl);
	  Ex1_Org2_Static2.Login(UserName,Password);
	  Ex1_Org2_Static2.AddJobDetails();
	  Ex1_Org2_Static2.AddJobDetailsInfo(Jobtitle,JobDes,JobNote);

		
					
  }
  public  static  void  OpenChrome() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	  
  }
  
  
 public  static void  OpenOrangeHRM(String TestUrl ) throws Exception {
	  
	 driver.get(TestUrl); 
  }
 public   static void  Login(String UserName,String Password ) throws Exception {
	  
	 findElement(By.name("txtUsername")).sendKeys(UserName);
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();	
 }
 public   static void  AddJobDetails() throws Exception {
	  
	 findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
 }
 public   static void  AddJobDetailsInfo(String Jobtitle,String JobDes,String  JobNote ) throws Exception {
		findElement(By.id("jobTitle_jobTitle")).sendKeys(Jobtitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDes);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote);
		findElement(By.id("btnSave")).click();
 }
 
  public  static  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
	 
		}
		return elem;
	}

  
  
  
  
  
}
