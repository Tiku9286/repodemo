package testng2;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import pomClasses.LoginOrSignUpPage;
import pomClasses.NewAcccount;
import pomClasses.SignUpPage;


public class TestNg extends Browser {
	private WebDriver driver ;
	private NewAcccount newAcccount;
	private SignUpPage signUpPage;
	
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
		newAcccount = new NewAcccount (driver);
		  signUpPage = new SignUpPage(driver);
	}

	 @BeforeMethod
	 public void openSignUpPage () {
//		 System.out.println("Before Method");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("https://www.instagram.com/");
		    
		//    NewAcccount newAcccount = new NewAcccount (driver);
	           newAcccount.clickOnNewAccount();
	  }
	   
	 @Test
	 public void createAccount () throws InterruptedException {
		 
		 System.out.println("Test 1");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//    SignUpPage signUpPage = new SignUpPage(driver);

		 signUpPage.sendMobNoOrEmail();
         signUpPage.sendFullName();
         signUpPage.sendUserName();
         signUpPage.sendPassword();
         signUpPage.clickOnSignUp();
         signUpPage.clickOnMonth();
         signUpPage.clickOnDate();
         signUpPage.clickOnYear();

         Thread.sleep(2000);
         String actual = driver.getCurrentUrl();
         System.out.println(actual);
         String actualtitle = driver.getTitle();
         System.out.println(actualtitle);
                         // https://www.instagram.com/accounts/emailsignup/
         String Expect = "https://www.instagram.com/accounts/emailsignup/";
         String exetit = "Sign up • Instagram";
         
         Assert.assertEquals(actual, Expect);
         Assert.assertEquals(actualtitle, exetit);
         
         
         
         
//         if (actual.equals(Expect) || actualtitle.equals(exetit))
//         {
//        	 System.out.println("pass");
//         }
//         else
//         {
//        	 System.out.println("fail");
//         }
      }
	 @Test
	 public void signUp () throws InterruptedException {
		 System.out.println("Test 2");
	//	 SignUpPage signUpPage = new SignUpPage(driver); 
		 
		 Thread.sleep(9000);
	      signUpPage.clickOnTermsLink();
	      ArrayList<String> addr = new  ArrayList<String> (driver.getWindowHandles());
			 driver.switchTo().window(addr.get(1));
			
	      Thread.sleep(3000);
	      String actual = driver.getCurrentUrl();
	         System.out.println(actual);
	         String actualtitle = driver.getTitle();
	         System.out.println(actualtitle);
       
       String Expect = "https://help.instagram.com/581066165581870/?locale=en_US";
       String exetit = "Terms of Use | Instagram Help Center";
       
       
       Assert.assertEquals(actual, Expect);
       Assert.assertEquals(actualtitle, exetit);
       
       
//       if (actual.equals(Expect) || actualtitle.equals(exetit))
//       {
//      	 System.out.println("pass");
//       }
//       else
//       {
//      	 System.out.println("fail");
//       }
       }
	 
	 @AfterMethod
	 public void closetab () throws InterruptedException {
		 
		 ArrayList<String> addr = new  ArrayList<String> (driver.getWindowHandles());
		 Thread.sleep(5000);
		 driver.switchTo().window(addr.get(0));
		
		 }
	 @AfterClass
		public void clearPomObject() {
			newAcccount = null;
			  signUpPage = null;
		}
	 
	 @AfterTest
	 public void afterTest () throws InterruptedException {
		 Thread.sleep(5000);
	 driver.quit();
	 driver = null;
	 System.gc();   // garbage collector===>> System.gc(); 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
