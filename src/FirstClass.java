import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstClass {
WebDriver driver =new ChromeDriver();

String url ="https://www.saucedemo.com/";

@BeforeTest
public void setup() {
	
	driver.manage().window().maximize();
	driver.get(url);
}


@Test (priority =1 ) 
public void login() throws InterruptedException {
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(3000);
	
	
}

@Test (priority =2 ) 
public void addRandomItemToTheCart() {

driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
}

@Test (priority =3 ) 
public void removeTheItemFromTheCart() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.id("remove-sauce-labs-backpack")).click();
}


@Test (priority =4 ) 
public void logout() throws InterruptedException {
	driver.findElement(By.id("react-burger-menu-btn")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("logout_sidebar_link")).click();
	Thread.sleep(3000);
}

@AfterTest
public void close() {
	driver.quit();
}


	
	
}
