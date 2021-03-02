package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;


public class LoginPage extends BaseTest {

	// Log in QnowsDev
	@FindBy(css = "#username")
	public WebElement UserName;
	@FindBy(css = "#password")
	public WebElement Pwd;
	@FindBy(css = "#kc-login")
	public WebElement login;
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}


	public void sendDataPassengers3(String name, String pwd) {
		utilities.TestUtil.ExplicitClickableWaitOne(UserName).sendKeys(name);
		utilities.TestUtil.ExplicitClickableWaitOne(Pwd).sendKeys(pwd);
		log.info("I send user and pwd");
	}
	
	public void clickOnButton() {
	    utilities.TestUtil.ExplicitClickableWaitOne(login).click();
	    log.info("I click on login button");
	}

	//method to validate if Error message displayed	@After("@browser")
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png"); //stick it in the report
	    }
	    driver.close();
	}
}	



