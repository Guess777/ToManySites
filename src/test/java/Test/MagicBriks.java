package Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

public class MagicBriks {
	@Test
	public void magic() {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.magicbricks.com/");
		Actions act=new Actions(driver);
		WebElement Buy= driver.findElement(By.id("buyheading"));
		act.moveToElement(Buy).build().perform();
		
		driver.findElement(By.xpath("//div[@id='buyDrop']/div/div/div/div/ul/li/a[text()='Projects in Mumbai']")).click();
		
		Set<String> windows= driver.getWindowHandles();
		Iterator<String> window=windows.iterator();
		String w1= window.next();
		String w2= window.next();
		driver.switchTo().window(w2);
		
		driver.findElement(By.id("buy_propertyType")).click();
		driver.findElement(By.xpath("//input[@title='Flat']")).click();
		driver.findElement(By.xpath("//input[@title='Plot/Land']")).click();
		driver.findElement(By.id("buy_budget_lbl")).click();
		driver.findElement(By.xpath("//div[@class='range rangeMin']/ul/li[text()=' 40 Lac']")).click();
		driver.findElement(By.xpath("//div[@class='range rangeMax']/ul/li[text()=' 80 Lac']")).click();
		driver.findElement(By.xpath("//input[@value='SEARCH PROJECTS']")).click();
		
		//driver.findElement(By.id("bar_categoryI1")).click();
		
		driver.findElement(By.xpath("//span[@id='bar_categoryA1P']/input")).click();
		//Assert.assertTrue(driver.findElement(By.xpath("//span[@id='bar_categoryA1P']/input")).isSelected());
	
		System.out.println(driver.findElement(By.xpath("//span[@id='bar_categoryA1P']/input")).isSelected());
		WebElement name= driver.findElement(By.id("nameid"));
		name.click();
		name.sendKeys("Shekhar");
		WebElement mobile= driver.findElement(By.id("mobileid"));
		mobile.click();
		mobile.sendKeys("9881373941");
		driver.findElement(By.id("postReqSubmit")).click();
		String emailError= driver.findElement(By.id("emailError")).getText();
		System.out.println(emailError);
		Assert.assertEquals(emailError, "Please enter email");
		String PreforedLocalityError= driver.findElement(By.id("localityError")).getText();
		System.out.println(PreforedLocalityError);
		Assert.assertEquals(PreforedLocalityError, "Please enter preferred locality");
		String budgetError= driver.findElement(By.id("budgetError")).getText();
		System.out.println(budgetError);
		Assert.assertEquals(budgetError, "Please Select Budget");
		String userAcceptanceError= driver.findElement(By.id("userAcceptanceError")).getText();
		System.out.println(userAcceptanceError);
		Assert.assertEquals(userAcceptanceError, "Please Accept T&C, Privacy and Cookie Policy");
		
		
	}

}
