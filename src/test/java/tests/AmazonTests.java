package tests;

import pageObjects.AmazonProductPage;

import pageObjects.AmazonSearchPage;
import pageObjects.AmazonSignInPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.epam.healenium.SelfHealingDriver;

import org.testng.annotations.*;

public class AmazonTests {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		ChromeOptions options = new ChromeOptions();
		WebDriver delegate = new FirefoxDriver();
		SelfHealingDriver driver = SelfHealingDriver.create(delegate);
		driver.get("https://www.amazon.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		AmazonSearchPage spobject = new AmazonSearchPage(driver);
		spobject.maximizeBrowser();
		
		spobject.clickToSignIn();
//		Thread.sleep(2000);
		
		AmazonSignInPage siobject = new AmazonSignInPage(driver);
		
		siobject.enterEmail("dhaksiny@buffalo.edu");
//		Thread.sleep(2000);
		
		siobject.clickContinue();
//		Thread.sleep(2000);
		
		siobject.enterPassword("Dhaksu@555");
//		Thread.sleep(2000);
		
		siobject.clickSignIn();
//		Thread.sleep(2000);
		
		
		try {
			driver.findElement(By.xpath("//img[@alt=\"captcha\"]"));
		}
		catch(Exception e){
			Thread.sleep(2000);
		}
		
		spobject.searchProduct("Nike Shoes");
		Thread.sleep(2000);
		
		spobject.searchClick();
		Thread.sleep(2000);
		
		AmazonProductPage ppobject = new AmazonProductPage(driver);
		
		ppobject.scrollToProduct();
		Thread.sleep(2000);
		
		ppobject.chooseProduct();
		Thread.sleep(2000);
		
		ppobject.sizeClick();
		Thread.sleep(2000);
		
		int i = 0;
		while(driver.findElement(By.xpath(String.format("//li[@id=\"size_name_%d\"]",i))).isEnabled() == false) {
			i++;
		}
		driver.findElement(By.xpath(String.format("//li[@id=\"size_name_%i\"]",i))).click();
		Thread.sleep(2000);
		
		ppobject.addtoCart();
		Thread.sleep(2000);
		
		spobject.clearCart();
		Thread.sleep(2000);
		
		spobject.closeDriver();

	}

}
