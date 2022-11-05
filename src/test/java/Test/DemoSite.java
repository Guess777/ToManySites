package Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSite {

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(opt);
		Point p=new Point(100,100);
		driver.manage().window().setPosition(p);
		Dimension d=new Dimension(1000, 800);
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/");
		driver.findElement(By.linkText("Tabs")).click();
		//driver.findElement(By.id("ui-id-3")).click();
		//driver.findElement(By.id("Re-Size Accordion")).click();
		driver.switchTo().frame(1);
		Assert.assertEquals(null, false);
	}
}
