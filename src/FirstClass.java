import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstClass {
	WebDriver driver = new ChromeDriver();

	String url = "https://www.saucedemo.com/";

	@BeforeTest
	public void setup() {

		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		WebElement userName = driver.findElement(By.id("user-name"));
		userName.sendKeys("standard_user");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void addRandomItemToTheCart() {

		WebElement addButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		addButton.click();
	}

	@Test(priority = 3)
	public void removeTheItemFromTheCart() throws InterruptedException {
		Thread.sleep(3000);
		WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
		removeButton.click();

	}

	@Test(priority = 4)
	public void logout() throws InterruptedException {
		WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
		burgerMenu.click();
		Thread.sleep(1000);
		WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
		logoutButton.click();
		Thread.sleep(3000);
	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
