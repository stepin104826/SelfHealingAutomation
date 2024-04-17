package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.epam.healenium.SelfHealingDriver;

public class AmazonSignInPage {

	SelfHealingDriver driver;
	By emailInput = By.xpath("//input[@id=\"ap_email\"]");
	By continueButton = By.xpath("//input[@id=\"continue\"]");
	By passwordInput = By.xpath("//input[@id=\"ap_password\"]");
	By signInButton = By.xpath("//input[@id=\"signInSubmit\"]");
	
	public AmazonSignInPage(SelfHealingDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailInput).sendKeys(email);
	}
	
	public void clickContinue() {
		driver.findElement(continueButton).click();
	}
	
	public void enterPassword(String pass) {
		driver.findElement(passwordInput).sendKeys(pass);
	}
	
	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}
	
}
