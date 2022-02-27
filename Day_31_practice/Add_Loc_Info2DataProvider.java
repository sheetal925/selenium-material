package Day_31_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Add_Loc_Info2DataProvider {
	
	
	WebDriver driver; 
	
	
	//String TestUrl="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin";
	//String Password="admin123";
   // String LocName="Hyderabadsec";
	
    
    @DataProvider(name = "Orange1")
	public Object[][] getData()
	{
	 Object[][] data = new Object[2][4];

		// 1st row
		data[0][0] ="https://opensource-demo.orangehrmlive.com/";
		data[0][1] = "Admin";
		data[0][2] = "admin123";
		data[0][3] = "sec";
		
		// 2nd row
		data[1][0] ="https://opensource-demo.orangehrmlive.com/";
		data[1][1] = "Admin";
		data[1][2] = "admin123";
		data[1][3] = "jeedimetla";
		
		
		return data;

	
	}
    
    
    
    
    
    
	
		
  @Test(dataProvider="Orange1")
  public void LocationInfo(String  TestUrl,String UserName, String Password,String LocName) throws Exception {
	  
	  Add_Loc_Info2DataProvider T1=new Add_Loc_Info2DataProvider();
	  T1.OpenChrome();
	  T1.OpenOrangeHRM(TestUrl);
	  T1.Login(UserName,Password);
	 T1.Location_Details(LocName);
	//T1.Add_Location_Details(LocName);
	  
	    	  
	  
	  
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
  
 public void  Location_Details(String  LocName) throws Exception {
	 
	 
	 findElement(By.id("menu_admin_viewAdminModule")).click();	
 
	 findElement(By.id("menu_admin_Organization")).click();
	 findElement(By.id("menu_admin_viewLocations")).click();
	 	 findElement(By.id("btnAdd")).click(); 
	// 	findElement(By.id(" location_name")).sendKeys(LocName);
	 	findElement(By.id("location_name")).sendKeys(LocName);
	 	
	 	Select dropdown1 = new Select(driver.findElement(By.id("location_country")));
		dropdown1.selectByValue("IN");
		//dropdown1.selectByVisibleText("India");
			//dropdown1.selectByIndex(1);
	 	
	 	
	 	 findElement(By.id("btnSave")).click();
	
	 
 }
/* public void  Add_Location_Details(String LocName) throws Exception{
	 
	
	 
	findElement(By.id(" location_name")).sendKeys(LocName);
		
		Select dropdown1 = new Select(driver.findElement(By.id("location_country")));
		//dropdown1.selectByValue("IN");
		dropdown1.selectByVisibleText("India");
			//dropdown1.selectByIndex(1);
		 

 }*/

  
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
