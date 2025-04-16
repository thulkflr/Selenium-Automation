import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

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
	public void addAllItemsToTheCart() {

		List<WebElement> addButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < addButtons.size(); i++) {
			addButtons.get(i).click();

		}

	}

	@Test(priority = 3)
	public void removeAllItemsFromTheCart() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> removeButtons = driver.findElements(By.className("btn_secondary"));
		for (int i = 0; i < removeButtons.size(); i++) {
			removeButtons.get(i).click();
		}

	}
String firstLetter="";
	@Test(priority = 4)
	public void getFirstLetterOfEachItem() {
		List<WebElement> itemsNames = driver.findElements(By.className("inventory_item_name"));
		for (int i = 0; i < itemsNames.size(); i++) {
			firstLetter=itemsNames.get(i).getText();
			System.out.println("the first char of"+firstLetter + " is: "+ firstLetter.charAt(0));
		}

	}

	@Test(priority = 5)
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
