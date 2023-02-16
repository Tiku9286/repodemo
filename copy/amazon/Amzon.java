package amazon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amzon {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul\\Downloads\\latest win 32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		                                     // deprcated method 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		   driver.get("https://www.amazon.in/");
           driver.manage().window().maximize();
           
          WebElement mob = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")); 
          mob.sendKeys("samsung note 20 ultra");
        
          
           WebElement srch = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")); 
          srch.click();
          
        //span[contains(text(),'Samsung Galaxy S22 Ultra 5G (Burgundy, 12GB, 256GB')]
          WebElement selmob = driver.findElement(By.xpath("//span[contains"
          		+ "(text(),'Samsung Galaxy S22 Ultra 5G (Burgundy, 12GB, 256GB')]")); 
          selmob.click();
          
          ArrayList<String> addr = new  ArrayList<String>(driver.getWindowHandles()) ;
          driver.switchTo().window(addr.get(1));
     
            
          JavascriptExecutor js =  (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0,2500)");
            
           
           WebElement cart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']")); 
           cart.click();
                      
           WebElement proceed = driver.findElement(By.xpath(" //span[@id='attach-sidesheet-checkout-button']")); 
           proceed.click(); 
          
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
}
}