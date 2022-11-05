package Test;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EaseMyTrip {
	@Test
	public void ease() {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		opt.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.easemytrip.com");
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.id("a_FromSector_show")).sendKeys("m");
		List<WebElement> cities=driver.findElements(By.xpath("//div[@id='fromautoFill']/ul/li/div/div/p/span"));
		int count= cities.size();
		for(int i=0;i<count;i++)
		{
			String city= cities.get(i).getText();
			System.out.println(city);
			if(city.equalsIgnoreCase("Mumbai(BOM)"))
			{
				cities.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("Editbox13_show")).click();
		driver.findElement(By.id("a_Editbox13_show")).sendKeys("new");
		//div[@id='toautoFill']/ul/li/div/div/p/span
		
		List<WebElement> c2= driver.findElements(By.xpath("//div[@id='toautoFill']/ul/li/div/div/p/span"));
		int count1= c2.size();
		for(int i=0;i<count1;i++)
		{
			String c2name=c2.get(i).getText();
			if(c2name.equalsIgnoreCase("New Delhi(DEL)"))
			{
				c2.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("ddate")).click();
		driver.findElement(By.xpath("(//li[@id='trd_3_12/10/2022'])[1]")).click();
		
		driver.findElement(By.xpath("(//div[@id='myFunction4'])[1]")).click();
		driver.findElement(By.className("plus_boxChd")).click();
		driver.findElement(By.id("traveLer")).click();
		driver.findElement(By.className("srchBtnSe")).click();
	}

}
