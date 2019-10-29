package Selenium_4_newFeatures.Selenium_4_newFeatures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Relative_Locator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		
		String URL= "https://ui.cogmento.com/";     // "http://www.freecrm.com/";
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("email")).sendKeys("yashchauhanyash@gmail.com");
		
		//Lets apply relative locator feature for password
		//Or	//driver.findElement(By.name("password")).sendKeys("Yash@1990");
		driver.findElement(RelativeLocator.withTagName("input").below(By.name("email"))).sendKeys("Yash@1990");
//Or	//driver.findElement(RelativeLocator.withTagName("input").above(By.xpath("//div[contains(text(),'Login')]"))).sendKeys("Yash@1990");
//Or	//driver.findElement(RelativeLocator.withTagName("input").below(By.name("email")).above(By.xpath("//div[contains(text(),'Login')]"))).sendKeys("Yash@1990");
		
		Thread.sleep(2000);
	
		//Lets apply relative locator feature for password
		//	driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		driver.findElement(RelativeLocator.withTagName("div").below(By.name("password"))).click();
		Thread.sleep(2000);
		String title=driver.getTitle();
		System.out.println("Title of the Page :"+title);
		driver.close();
		
		

	}

}
