package Day_31_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Add_skills {
	static WebDriver driver;
	
	
	//String TestUrl="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin";
	//String Password="admin123";
   // String skillname="Java123";
   // String Description="Java Desc";
    
    
    
    @DataProvider(name = "Orange3")
   	public Object[][] getData()
   	{
   	 Object[][] data = new Object[3][5];

   		// 1st row
   		data[0][0] ="https://opensource-demo.orangehrmlive.com/";
   		data[0][1] = "Admin";
   		data[0][2] = "admin123";
   		data[0][3] = "Java123";
   		data[0][3] = "Java Desc123";
   		
   		// 2nd row
   		data[1][0] ="https://opensource-demo.orangehrmlive.com/";
   		data[1][1] = "Admin";
   		data[1][2] = "admin123";
   		data[1][3] = "java 124";
   		data[1][4] = "Java Desc124 ";
   		
   		//3rd row
   		
   		data[2][0] ="https://opensource-demo.orangehrmlive.com/";
   		data[2][1] = "Admin";
   		data[2][2] = "admin123";
   		data[2][3] = "java 125";
   		data[2][4] = "Java Desc 125";
   		
   		return data;

   	
   	}
    
    
    
    
    
    
    
    
    
	
  @Test(dataProvider= "Orange3")
  public void Add_Skills_Info(String  TestUrl,String UserName, String Password,String skillname,String Description ) throws Exception  {
	  
	  Add_skills A1=new Add_skills();
	  
	  A1.OpenChrome();
	  A1.OpenOrangeHRM(TestUrl);
	  A1.Login(UserName,Password);
	  A1.Skill_Test(skillname,Description);
	  
	  	  
	  
	  
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
 
 
 public void  Skill_Test (String skillname , String Description)throws Exception {
  
	 findElement(By.id("menu_admin_viewAdminModule")).click();	
	 findElement(By.id("menu_admin_Qualifications")).click();	
	 findElement(By.id("menu_admin_viewSkills")).click();	
	 //findElement(By.id(" btnAdd")).click();	
	 findElement(By.id("btnAdd")).click(); 
	 findElement(By.id("skill_name")).sendKeys(skillname);
	 findElement(By.id("skill_description")).sendKeys(Description);
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
