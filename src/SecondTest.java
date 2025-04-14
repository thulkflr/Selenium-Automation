import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTest {
	WebDriver driver = new ChromeDriver();
	String username = "Admin";
	String password = "admin123";
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeTest
	public void setup() {
		driver.manage().window().maximize();
		driver.get(url);

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys(username);
		WebElement passwordFiled = driver.findElement(By.name("password"));
		passwordFiled.sendKeys(password);
		// driver.findElement(By.("")).click();

		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
	}

	@Test(priority = 2)
	public void navigateToPIM() throws InterruptedException {
		Thread.sleep(2000);

		WebElement PIMButton = driver.findElement(By.xpath("//span[text()='PIM']"));
		PIMButton.click();
		Thread.sleep(2000);

		System.out.println("title is: " + driver.getTitle());
		WebElement element = driver.findElement(By.xpath("//h6[text()='PIM']"));
		if (element.isDisplayed()) {
			System.out.println("Doooooooooooooooooooooooone");
		} else {
			System.out.println("faaaaail");

		}

	}

	@Test(priority = 3)
	public void addNewEmployee() throws InterruptedException {
		WebElement addEmpButton = driver.findElement(By.xpath("//a[text()='Add Employee']"));
		addEmpButton.click();
		Thread.sleep(2000);
		WebElement firstNameFiled = driver.findElement(By.name("firstName"));
		firstNameFiled.sendKeys("Thu Alkfl");
		WebElement middleNameFiled = driver.findElement(By.name("middleName"));
		middleNameFiled.sendKeys("Mohammad");
		WebElement lastNameFiled = driver.findElement(By.name("lastName"));
		lastNameFiled.sendKeys("Rababa'h");
		Thread.sleep(500);
		WebElement clearField = driver.findElement(By.xpath("(//input[@data-v-1f99f73c])[5]"));
		clearField.clear();

		WebElement idField = driver.findElement(By.xpath("(//input[@data-v-1f99f73c])[5]"));
		idField.sendKeys("201998");

		WebElement toggleButton = driver.findElement(By.xpath("//span[@data-v-8e4757dc]"));
		toggleButton.click();
		toggleButton.click();

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

	}

	@AfterTest
	public void colse() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

}
