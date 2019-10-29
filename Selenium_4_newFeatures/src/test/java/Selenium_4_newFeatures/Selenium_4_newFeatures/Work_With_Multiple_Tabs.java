package Selenium_4_newFeatures.Selenium_4_newFeatures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Work_With_Multiple_Tabs {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		
		String URL= "https://ui.cogmento.com/";     // "http://www.freecrm.com/";
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
		driver= new ChromeDriver();
		
		String parentTab= driver.getWindowHandle();
		System.out.println("Parent Tab Handle "+parentTab);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("email")).sendKeys("yashchauhanyash@gmail.com");
		
		//new method added to open tab or window
		WebDriver newTabdriver=driver.switchTo().newWindow(WindowType.TAB);
		String childTab= driver.getWindowHandle();
		System.out.println("Child Tab Handle "+childTab);

		newTabdriver.get("https://www.google.com");
		newTabdriver.findElement(By.name("q")).sendKeys("Yash Chouhan");
		Thread.sleep(2000);
		newTabdriver.close();
		
		driver.switchTo().window(parentTab);
		driver.findElement(By.name("password")).sendKeys("Yash@1990");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		String title=driver.getTitle();
		System.out.println("Title of the Page :"+title);
		driver.close();

	}

}
