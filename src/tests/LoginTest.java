package tests;

import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();

	@BeforeMethod
	public void beforeMethod() throws IOException {
		lp.openbrowser();
		lp.openLoginPage();
	}

	@AfterMethod
	public void afterMethod() {
		lp.closeBrowser();
	}

	@Test(priority = 1)
	public void loginWithWrongEmailPasswordTest() throws InterruptedException {
		lp.login(df.wrongEmail, df.wrongPassword);
		Assert.assertEquals(lp.readError(), df.globalError);
	}

	@Test(priority = 2)
	public void loginWithSpecialCharEmailTest() throws InterruptedException {// enter special char in email
		lp.login(df.emailErrSpeChar, df.wrongPassword);
		Assert.assertEquals(lp.emailError(), df.emailErrSpeChar);// verify the error message
	}

	@Test(priority = 3)
	public void loginWithEmptyEmailTest() throws InterruptedException {// empty email
		lp.login("", df.wrongPassword);
		Assert.assertEquals(lp.emptyEmailError(), df.emptyEmailErr);// verify the error message
	}

	@Test(priority = 4)
	public void loginWithEmptyPasswordTest() throws InterruptedException {// empty password
		lp.login(df.wrongEmail, "");
		Assert.assertEquals(lp.passwordError(), df.emptyPasswordErr);// verify the error message
	}
}
