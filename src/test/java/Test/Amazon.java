package Test;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://www.flipkart.com");
		//driver.findElement(By.xpath("(//div[@id='desktop-grid-4']/div/div/div/div/a[1])[3]")).click();
		//driver.findElement(By.xpath("//ul[@class='a-unordered-list a-nostyle a-horizontal feed-carousel-shelf']/li/span/a/img[contains(@alt,'Outdoor Slipper')]")).click();
		//driver.findElement(By.xpath("//div[@class='a-section a-spacing-none fluid-image-container']//following::img[@alt='Footwear+Handbags']")).click();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[@class='CXW8mj']/img[contains(@alt,'Printers (From ₹3999)')]")).click();
		//List<WebElement> priceList=driver.findElements(By.xpath("//div[@class='_30jeq3']"));
		
		driver.findElement(By.xpath("//img[contains(@alt,'Ultra 4826')]")).click();
		Set<String> windows= driver.getWindowHandles();
		Iterator<String> window=windows.iterator();
		String w1=window.next();
		String w2=window.next();
		driver.switchTo().window(w2);
		driver.findElement(By.className("N79-rD")).click();
		driver.findElement(By.id("pincodeInputId")).sendKeys("410206");
		driver.findElement(By.linkText("check")).click();
	}
}