package com.dvops.maven.eclipse;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewTest{
  //declare Selenium WebDriver
	private WebDriver webDriver;
  
	@BeforeTest
	public void beforeTest() {
		  //Setting system properties of ChromeDriver
		  //to amend directory path base on your local file path
			String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";
			System.setProperty("webDriver.chrome.driver", chromeDriverDir);
		  //initialize FirefoxDriver at the start of test
			webDriver = new ChromeDriver();
			}
	
   @Test  
   public void checkTitle() {
	  //Load website as a new page
	   webDriver = new ChromeDriver();
	   webDriver.navigate().to("http://localhost:8080/eTimesheet/userservlets/dashboard");
	  
	  //Assert the title to check that we are indeed in the correct website
	   AssertJUnit.assertEquals(webDriver.getTitle(), "Mott MacDonald Timesheet App");
	   System.out.println("title: "+webDriver.getTitle());
   		}
	
   @Test
   public void testButtonPresence() {
	   webDriver = new ChromeDriver();
	   webDriver.navigate().to("http://localhost:8080/eTimesheet/userservlets/dashboard");
        // Find the button by its name
	   WebElement button = webDriver.findElement(By.linkText("Add New Employee"));
        button.click();
        // Verify the title of the new page
        AssertJUnit.assertEquals(webDriver.getTitle(), "Mott MacDonald Timesheet App");
        System.out.println("title: "+webDriver.getTitle());
        }
  
  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.close();			
  }
 }