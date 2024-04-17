package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.epam.healenium.SelfHealingDriver;

public class AmazonSearchPage {
	SelfHealingDriver driver;
	By searchbox = By.xpath("//input[@id=\"twotabsearchtextbox\"]");
	By searchclick = By.xpath("//input[@id=\"nav-search-submit-button\"]");
	By signInOptions = By.xpath("//a[@id=\"nav-link-accountList\"]");
	By cart = By.xpath("//span[@id=\"nav-cart-count\"]");

	public AmazonSearchPage(SelfHealingDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String text) {
		driver.findElement(searchbox).sendKeys(text);
	}
	
	
	public void searchClick() {
		driver.findElement(searchclick).click();
	}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	public void clickToSignIn() {
		Actions chain = new Actions(driver);
		chain.moveToElement(driver.findElement(signInOptions)).click().perform();
	}
	
	public void clearCart() {
		Actions chain = new Actions(driver);
		chain.moveToElement(driver.findElement(cart)).click().moveToElement(driver.findElement(By.xpath("//span[@data-feature-id=\"delete\"]"))).click().perform();
	}
	
	public void closeDriver() {
		driver.quit();
	}
	
	
}
