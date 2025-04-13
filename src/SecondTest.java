import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTest {
WebDriver driver =new ChromeDriver();
String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
@BeforeTest
public void setup() {
	driver.manage().window().maximize();
	driver.get(url);
	
}

@Test (priority =1)
public void login() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	//driver.findElement(By.("")).click();
	
driver.findElement(By.xpath("//button[@type='submit']")).click();
}


@Test (priority =2)
public void navigateToPIM() throws InterruptedException {
	Thread.sleep(2000);

	driver.findElement(By.xpath("//span[text()='PIM']")).click();
	Thread.sleep(2000);

	System.out.println("title is: " +driver.getTitle());
	WebElement element= driver.findElement(By.xpath("//h6[text()='PIM']"));
	if(element.isDisplayed())
	{
		System.out.println("Doooooooooooooooooooooooone");	}
	else {
		System.out.println("faaaaail");
		
	}
	
}


@Test (priority =3)
public void addNewEmployee() throws InterruptedException {
	driver.findElement(By.xpath("//a[text()='Add Employee']"))
	.click();	
	Thread.sleep(2000);
	driver.findElement(By.name("firstName")).sendKeys("Thu Alkfl");
	driver.findElement(By.name("middleName")).sendKeys("Mohammad");
	driver.findElement(By.name("lastName")).sendKeys("Rababa'h");
	driver.findElement(By.xpath("(//input[@data-v-1f99f73c])[5]")).clear();
	Thread.sleep(500);

	driver.findElement(By.xpath("(//input[@data-v-1f99f73c])[5]")).sendKeys("201998");

	driver.findElement(By.xpath("//span[@data-v-8e4757dc]")).click();
	driver.findElement(By.xpath("//span[@data-v-8e4757dc]")).click();
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
}


@AfterTest
public void colse() throws InterruptedException {
	Thread.sleep(5000);
	driver.quit();
}

	
	
}
