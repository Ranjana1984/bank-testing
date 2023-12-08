package testing.servertest;


import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    System.out.println("Script Started");	
       //initializing the web driver
     System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    //setting properties
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
	  //chromeOptions.addArguments("--headless");
	  //chromeOptions.addArguments("--disable-gpu");
	 //chromeOptions.addArguments("--no-sandbox");
    //open url
    System.out.println("Driver opening up the url in browser");	
    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.get("http://3.101.107.156:8080/contact.html");	
   // driver.get("https://www.facebook.com");
    
    //invole implicit waits to load the page
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    
    System.out.println("Enter details in the form");
    //enter details
    //input name
    driver.findElement(By.id("inputName")).sendKeys("Sam");
    Thread.sleep(3000);
    driver.findElement(By.id("inputNumber")).sendKeys("999999999");
    Thread.sleep(1000);
    driver.findElement(By.id("inputMail")).sendKeys("sam@xyz.com");
    Thread.sleep(1000);
    driver.findElement(By.id("inputMessage")).sendKeys("Hi, I am interested in insurance");
    Thread.sleep(1000);
    
    driver.findElement(By.id("my-button")).click();
    
//    String response = driver.findElement(By.id("response")).getText();
   
//    System.out.println(response);
    
    System.out.println("test scripts executed");
    
    TakesScreenshot scrShot = ((TakesScreenshot)driver);
    
    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    
   // File destFile = new File("/Users/jivan/test-reports.jpg");
    File destFile = new File("/var/lib/jenkins/workspace/insure-me-test-scripts/test-reports.jpg");
    
    
    FileUtils.copyFile(srcFile, destFile);
    
    Thread.sleep(1000);
    
    
    
    
    driver.quit();
    
       	
    
    	
        System.out.println( "Hello World!" );
    }
}
    
 