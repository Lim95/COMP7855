package tomcat_WebTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class photoGalleryTest {
	
	
	@Before
	public static void createDriver() {
		   
	}
	
	@After
	public void quitDriver() {

	}

	@Test
	public void tomcat_Test() throws InterruptedException { 
		// System and WebDriver Setup
		System.setProperty("webdriver.chrome.driver", 
		"C:\\Users\\User\\Downloads\\selenium-java-3.141.59\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// Enter Address of the Webpage
		driver.get("http://localhost:8888/gallery");
		driver.manage().window().maximize();
		
		// Testing Login Failing
		driver.findElement(By.name("uname")).click();
		driver.findElement(By.name("uname")).sendKeys("wrong");
		driver.findElement(By.name("psw")).click();
		driver.findElement(By.name("psw")).sendKeys("wrong");
		driver.findElement(By.id("logbtn")).click();
		
		Thread.sleep(1000);
		
		// Testing Login Access
		driver.findElement(By.name("uname")).click();
		driver.findElement(By.name("uname")).sendKeys("admin");
		driver.findElement(By.name("psw")).click();
		driver.findElement(By.name("psw")).sendKeys("admin");
		driver.findElement(By.id("logbtn")).click();	
		
		Thread.sleep(1000);
		
		// Testing Scrolling Through the Gallery
		for(int i = 0; i<3; i++)
		{
			driver.findElement(By.id("lbtn")).click();
		}
		
		Thread.sleep(1000);
		for(int i = 0; i<3; i++)
		{
			driver.findElement(By.id("rbtn")).click();
			Thread.sleep(5200);
		}
		
		// Testing Upload
		Thread.sleep(1000);
		driver.findElement(By.id("ubtn")).click();
		
		WebElement uploadElement = driver.findElement(By.id("upfile"));
		Thread.sleep(1000);	
		uploadElement.sendKeys("C:\\Users\\User\\Pictures\\IMG-20120714-009211.jpg");
		Thread.sleep(1000);
		driver.findElement(By.id("upbtn")).click();

		Thread.sleep(1000);
		
		// Scroll Through to find the Uploaded Picture
		for(int i = 0; i<5; i++)
		{
			driver.findElement(By.id("lbtn")).click();
		}
		for(int i = 0; i<5; i++)
		{
			driver.findElement(By.id("rbtn")).click();
		}
		
		driver.close();
		driver.quit();
   }
}

