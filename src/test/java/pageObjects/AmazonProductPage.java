package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import com.epam.healenium.SelfHealingDriver;

public class AmazonProductPage {

	SelfHealingDriver driver;
	By FirstProduct = By.xpath("//div[@data-cel-widget=\"search_result_2\"]");
	By SelectSizeButton = By.xpath("//span[@id=\"dropdown_selected_size_name\"]");
	By BuyOptions = By.xpath("//a[@title=\"See All Buying Options\"]");
	By AddToCart = By.xpath("//span[@id=\"a-autoid-2-offer-1\"]");
	By MenuCloseButton = By.xpath("//i[@class=\"a-icon aod-close-button\"]");
	
	public AmazonProductPage(SelfHealingDriver driver) {
		this.driver = driver;
	}
	
	public void scrollToProduct() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(FirstProduct));			
	}
	
	public void chooseProduct() {
		driver.findElement(FirstProduct).click();
	}
	
	public void sizeClick() {
		driver.findElement(SelectSizeButton).click();
	}
	
	public void addtoCart() {
		driver.findElement(BuyOptions).click();
		driver.findElement(AddToCart).click();
		driver.findElement(MenuCloseButton).click();
	}
}
