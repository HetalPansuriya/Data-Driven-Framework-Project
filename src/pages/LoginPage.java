package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
/*	WebElement email = driver.findElement(By.name("usernameInput"));
	WebElement password = driver.findElement(By.name("password"));
	WebElement signInButton = driver.findElement(By.id("signIn"));
	WebElement globalError = driver.findElement(By.id("globalError"));
	WebElement emailError = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	WebElement passwordError = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	*/
	
	//We will use PAge FActory
	
	@FindBy(id = "usernameInput-input")
	public WebElement email;
	@FindBy(name = "password")
	public WebElement password;
	@FindBy(id = "signIn")
	public WebElement signInButton;
	@FindBy(id = "globalError")
	public WebElement globalError;
	@FindBy(id = "UsernameTextField__errors-usernameInput")
	public WebElement emailError;
	@FindBy(id = "PasswordTextField__errors-password")
	public WebElement passwordError;	
	
	
	public void openbrowser() {
		
		String browser = "FireFox";// chrome,safari

		if (browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\seleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\seleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.safari.driver", "C:\\seleniumJars\\s.exe");
			driver = new FirefoxDriver();
		}
		PageFactory.initElements(driver, this);//initialize driver to find elements
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void openLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=dKnSQVM8fbU&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiZEtuU1FWTThmYlUiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY0NTk3NzYyNywiaWF0IjoxNjQ1OTc2NDI3LCJqdGkiOiI4Y2ZjYjc1NS05N2EwLTRiMjctYjIzOS02MmJkN2JmYWIyNGIiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.emL2RUpxNtPwvnM0wxHnBkHRWKBYaXw1nSmApqn7M9c76uuWM7Lwn_9Z3v00bv3xB-xyrh_1ATPCxFzpM73i5q-2TyKOMKDNkVAwXqZsY5wTcYziYROEIhjW19HfwGXpp2dOPv1BuCEl1NngMl4Rwd32LlQqn8REOeEzNpr1HYJ3ghchQ0JdCFHwiBotUXZ13g8kM72yo4FzEwq2uh_zbogTAzNpVbI_bWSK7VVnVHpYLrzLdYZ6lqR9xm3TPnHGszA7K_9U65J-vpXcYpOBuRcr_KFWS5JeowlHh5acA_zUuUtDpGDKYiF2Gz0MY7Itx8NG_WUchLZPHlxelfrzhQ&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);	
		password.sendKeys(b);
		signInButton.click();
		Thread.sleep(3000);
	}
	public String readError() {
		String actual = globalError.getText();
		System.out.println(actual);
		return actual;
	}
	public String emailError() {
		String actual = emailError.getText();
		System.out.println(actual);
		return actual;
	}
	public String emptyEmailError() {
		String actual = emailError.getText();
		System.out.println(actual);
		return actual;
	}
	public String passwordError() {
		String actual = passwordError.getText();
		System.out.println(actual);
		return actual;
	}

}

