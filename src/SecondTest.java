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
		System.out.println("faaaaail");	}
	
}


@Test (priority =1)
public void addNewPIM() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab-item') and text()='Add Employee']"))
.click();
	}


@AfterTest
public void colse() {
	
}

	
	
}
