package Test;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Agoda {
	@Test
	public void hotelBook() throws IOException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("https://www.agoda.com/en-in/");
			driver.findElement(By.className("ab-close-button")).click();
			WebElement search= driver.findElement(By.className("SearchBoxTextEditor"));
			search.click();
			search.sendKeys("mum");
			List<WebElement> cityHotelsList= driver.findElements(By.xpath("//div/span[@class='Suggestion__text']"));
			int count=cityHotelsList.size();
			System.out.println(count);
			for(int i=0;i<count;i++)
			{
				
				String cityName= cityHotelsList.get(i).getText();
				
				System.out.println(cityName);
				if(cityName.equalsIgnoreCase("Malabar Hill, Mumbai"))
				{
					
					cityHotelsList.get(i).click();
					break;
				}
			}
			
			driver.findElement(By.xpath("//div[@aria-label='Mon Oct 17 2022']/span")).click();
			
			driver.findElement(By.xpath("//div[@aria-label='Tue Oct 18 2022']/span")).click();
			//driver.findElement(By.xpath("//div[@data-selenium='traveler-families']")).click();
			driver.findElement(By.xpath("(//*[name()='svg'][@role='img'])[6]")).click();
			Select select=new Select(driver.findElement(By.className("DropdownInputUpdate__box")));
			select.selectByValue("6");
			driver.findElement(By.xpath("(//div[@class='SearchBoxTextDescription__title'])[3]")).click();
			driver.findElement(By.xpath("//button[@data-selenium='searchButton']")).click();
			TakesScreenshot ts= (TakesScreenshot)driver;
			File a=ts.getScreenshotAs(OutputType.FILE);
			File b=new File("a.bmp");
			FileUtils.copyFile(a, b);
			List<WebElement> priceList= driver.findElements(By.xpath("//span[@data-selenium='display-price']"));
			int priceL= priceList.size();
			System.out.println(priceL);
			for(int i=0;i<priceL;i++)
			{
				
				String price=priceList.get(i).getText();
				System.out.println(price);
				
			}
	}

}
