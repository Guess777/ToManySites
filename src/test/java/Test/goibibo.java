package Test;

import java.time.Duration;
import java.util.*;



import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class goibibo {
	@Test
	public void book() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com");
		
		driver.findElement(By.xpath("(//p[text()='Enter city or airport'])[1]")).click();
		///\driver.findElement(By.xpath("//div[@class='sc-cidDSM dOEpbS']/input")).click();
		driver.findElement(By.xpath("//div[@class='sc-cidDSM loaQCg']/div/input")).sendKeys("new");
		
		List<WebElement> listC1=driver.findElements(By.xpath("//p/span[@class='autoCompleteTitle ']"));
		int count1= listC1.size();
		for(int i=0;i<count1;i++)
		{
			String C1= listC1.get(i).getText();
			System.out.println(C1);
			if(C1.contains("New Delhi, India"))
			{	
				listC1.get(i).click();
				break;
			}
			
		}

	
		driver.findElement(By.xpath("//div[@class='sc-jcFjpl htmBRX']/input")).sendKeys("mum");
		
		List<WebElement> listC2=driver.findElements(By.xpath("//p/span[@class='autoCompleteTitle ']"));
		int count2= listC1.size();
		for(int i=0;i<count1;i++)
		{
			String C2= listC2.get(i).getText();
			System.out.println(C2);
			if(C2.contains("Mumbai, India"))
			{	
				listC2.get(i).click();
				break;
			}
			
		}
		List<WebElement> pricedate= driver.findElements(By.className("DayPicker-Day"));
		List<WebElement> priceList= driver.findElements(By.className("fsw__price"));
		int countPrice=priceList.size();
		SoftAssert soft=new SoftAssert();
		
//		Integer[] price1 =new Integer[priceList.size()];
//		priceList.toArray(price1);
		for (int i=0;i<1;i++)
		{
			
			
			
			String price=priceList.get(i).getText();
			String newPr= price.replace(',', ' ');
			String newPrice= newPr.replaceAll("\\s", "");
			System.out.println(newPrice);
			int p=Integer.parseInt(newPrice);
			System.out.println(newPrice);
			for(int j=0;j<countPrice;j++)
			{
				String price2=priceList.get(j).getText();
				String newP= price2.replace(',', ' ');
				String newPrice1= newP.replaceAll("\\s", "");
				int q=Integer.parseInt(newPrice1);
				System.out.println(newPrice1);
				
				if(p>q)
				{
					soft.assertTrue(true);
					String DatePrice=pricedate.get(j).getAttribute("aria-label");
					System.out.println("on"+ DatePrice+" price is less than current date");
					
					
				}
				else if (p==q) {
					soft.assertTrue(true);
					String DatePrice=pricedate.get(j).getAttribute("aria-label");
					System.out.println( DatePrice+" price is equal current date");
				}	
				else if (p<q) {
					soft.assertTrue(true);
					String DatePrice=pricedate.get(j).getAttribute("aria-label");
					System.out.println( DatePrice+" price is greater than current date.");
				}
				
				else {
					System.out.println("No Flight");
				}
			}			
		}
		driver.findElement(By.className("fswTrvl__done")).click();
		driver.findElement(By.className("jdKcUc")).click();
		soft.assertAll();
	}
}