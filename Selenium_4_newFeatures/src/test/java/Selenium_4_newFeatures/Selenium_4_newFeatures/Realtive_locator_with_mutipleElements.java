package Selenium_4_newFeatures.Selenium_4_newFeatures;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Realtive_locator_with_mutipleElements {

	public static void main(String[] args) {
		WebDriver driver;
		
		String URL= "https://www.google.com";     
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\xooa\\git\\Selenium-Practice\\Selenium-Practice\\chromedriver.exe");
		driver= new ChromeDriver();
		
		String parentTab= driver.getWindowHandle();
		System.out.println("Parent Tab Handle "+parentTab);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(URL);
		
		List<WebElement> languages= driver.findElements(RelativeLocator.withTagName("a").toRightOf(By.xpath("//div[contains(text(),'Google offered in:  ')]")));
				//near(By.xpath("//div[contains(text(),'Google offered in:  ')]")));
		for(WebElement ele: languages)
		{
			System.out.println(ele);
			System.out.println(ele.getAttribute("text"));
		}
	}

}
