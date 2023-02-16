package testng2;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.Browser;
import pomClasses.About;
import pomClasses.LoginOrSignUpPage;
import pomClasses.NewAcccount;
import pomClasses.SignUpPage;

public class TestNg2 {
	
	private WebDriver driver ;
	private  LoginOrSignUpPage loginOrSignUpPage ;
	
	@Parameters("browser")
	 @BeforeTest 
	  public void openBrowser(String browserName) throws InterruptedException{
		 
	 if(browserName.equals("Chrome")) {
		driver = Browser.openChromeBrowser();
		 }
		 
	 Thread.sleep(5000);
		 if(browserName.equals("Edge")) {
			driver = Browser.openEdgeBrowser();
			 }
				
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	           driver.manage().window().maximize();
	 }
	
	
	
	
	@BeforeClass 
	public void createPomObject() {
		loginOrSignUpPage = new LoginOrSignUpPage (driver);
	}
		
	
	@BeforeMethod 
	public void openSignUpPage () {
		 System.out.println("Before Method");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("https://www.instagram.com/");
	}
	
	@Test // (priority = 2)
	public void loginOrSignUp() throws InterruptedException {
		System.out.println("Test A");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	//	 LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage (driver);
		 
		Thread.sleep(2000);
	      loginOrSignUpPage.sendUserName();
	      loginOrSignUpPage.sendPassword();
	      loginOrSignUpPage.clickOnLoginButton();
	      Thread.sleep(3000);
	      driver.navigate().back();
	      Thread.sleep(5000);
	      loginOrSignUpPage.clickOnNotNow();
	      
	       String actual = driver.getCurrentUrl();
	         System.out.println(actual);
	         String actualtitle = driver.getTitle();
	         System.out.println(actualtitle);
	                         // https://www.instagram.com/accounts/emailsignup/
	         String Expect = "https://www.instagram.com/";
	         String exetit = "Instagram";
	         
	         
	         Assert.assertEquals(actual, Expect);
	         Assert.assertEquals(actualtitle, exetit);
	         
	         
//	         if (actual.equals(Expect) && actualtitle.equals(exetit))
//	         {
//	        	 System.out.println("pass");
//	         }
//	         else
//	         {
//	        	 System.out.println("fail");
//	         }
	}
  @Test  //(priority = 1)
    public void about() throws InterruptedException {
	  System.out.println("Test B");
    	 About about = new About(driver); 
    	 Thread.sleep(6000);
    	    about.clickOnAbout();
    	    
  	      String actual = driver.getCurrentUrl();
  	         System.out.println(actual);
  	         String actualtitle = driver.getTitle();
  	         System.out.println(actualtitle);
  	                         // https://www.instagram.com/accounts/emailsignup/
  	         String Expect = "https://www.instagram.com/";
  	         String exetit = "Instagram";
  	         
  	       
  	         Assert.assertEquals(actual, Expect);
  	         Assert.assertEquals(actualtitle, exetit);
  	         
  	         
//  	         if (actual.equals(Expect) && actualtitle.equals(exetit))
//  	         {
//  	        	 System.out.println("pass");
//  	         }
//  	         else
//  	         {
//  	        	 System.out.println("fail");
//  	         }
    	    
    	
    }
	
	@AfterMethod
	public void returnToHome() throws InterruptedException {
		System.out.println("After Method");
	     ArrayList<String> addr = new  ArrayList<String> (driver.getWindowHandles());
		 Thread.sleep(5000);
		 driver.switchTo().window(addr.get(0));
	}
	
	@AfterClass
	public void clearPomObject () {
		loginOrSignUpPage = null;
	}
	
	 @AfterTest
	 public void afterTest () throws InterruptedException {
		 Thread.sleep(5000);
	 driver.quit();
	 driver = null;
	 System.gc();   // garbage collector===>> System.gc(); 
	 }
	 
	
	
	
	
	

}
