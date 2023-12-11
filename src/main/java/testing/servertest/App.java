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

    	{
    	    System.out.println("Script Started");	
    	       //initializing the web driver
    	     //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	    //setting properties
    	    WebDriverManager.chromedriver().setup();
    	    ChromeOptions chromeOptions = new ChromeOptions();
    		  //chromeOptions.addArguments("--headless");
    		  //chromeOptions.addArguments("--disable-gpu");
    		 //chromeOptions.addArguments("--no-sandbox");
    	    //open url
    	    System.out.println("Driver opening up the url in browser");	
    	    WebDriver driver = new ChromeDriver(chromeOptions);
    	    driver.get("http://54.241.138.172:8080/contact.html");	
    	    //driver.get("http://localhost:8080/contact.html");	
    	    //invole implicit waits to load the page
    	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	    System.out.println("Enter details in the form");
    	    //enter details
    	    driver.findElement(By.id("inputName")).sendKeys("Ranjana");
    	    Thread.sleep(1000);
    	    driver.findElement(By.id("inputNumber")).sendKeys("900000009");
    	    Thread.sleep(1000);
    	    driver.findElement(By.id("inputMail")).sendKeys("Ranjana@xyz.com");
    	    Thread.sleep(1000);
    	    driver.findElement(By.id("inputMessage")).sendKeys("Hi, Iam intrested in finance");
    	    Thread.sleep(1000);
    	    driver.findElement(By.id("my-button")).click();
    	    Thread.sleep(1000);
    	    String message = driver.findElement(By.id("message")).getText();
    	    System.out.println(message);
    	    Thread.sleep(1000);
    	    System.out.println("test scripts are executed");
    	    TakesScreenshot scrShot = ((TakesScreenshot)driver);
    	    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    	    //File destFile = new File("C:\\Users\\jivan\\eclipse-workspacenew\\servertest\\Testss.jpg");
    	    File destFile = new File("/var/lib/jenkins/workspace/capstone-project-test/Testss.jpg");
    	    FileUtils.copyFile(srcFile, destFile);
    	    Thread.sleep(1000);
    	    System.out.println("ScreenShot Taken");
    	    driver.quit();
    	    }
    }
}