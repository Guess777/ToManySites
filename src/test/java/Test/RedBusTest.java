package Test;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusTest {
    @Test
	public void bus() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//input[@data-message='Please enter a source city']")).sendKeys("mumbai");
		
		List<WebElement> fromList= driver.findElements(By.xpath("//div[@class='fl search-box clearfix']/div/ul/li"));
		int count = fromList.size();
		for(int i=0;i<count;i++)
		{ 
		    String city= fromList.get(i).getText();
			System.out.println(city);
			if(city.equalsIgnoreCase("Sion, Mumbai"))
			{
				fromList.get(i).click();
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']")).sendKeys("Auran");
		List<WebElement> toList= driver.findElements(By.xpath("//div[@class='fl search-box']/div/ul/li"));
		int count1 = toList.size();
		for(int j=0;j<count1;j++)
		{ 
		    String  city1= toList.get(j).getText();
			System.out.println(city1);
			if(city1.equalsIgnoreCase("Adalat Road, Aurangabad"))
			{
				toList.get(j).click();
				break;
			}
			
		}
		
		driver.findElement(By.className("current")).click();
		driver.findElement(By.id("search_btn")).click();
		
		
		
		List<WebElement> fareList= driver.findElements(By.xpath("//div[@class='fare d-block']/span"));
		
		int countFare=fareList.size();
		System.out.println(countFare);
		for(int k=0;k<countFare;k++)
		{
		 String farePrice=	fareList.get(k).getText();
		 System.out.println(farePrice);	
		}
	}
}
