package stepDefinations;

import base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pages.HomePage;
import pages.LoginPage;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class StepDefinitionHomePage extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;

	@Given("^User is in loginPage$")
	public void user_is_in_homePage() throws Throwable {
		// if it is null the set up method will start everytime
		driver = null;
		setUp();
		loginPage = new LoginPage();
		
	}


    @Then("^I login with user \"([^\"]*)\" and pwd \"([^\"]*)\"$")
    public void i_login_with_user_something_and_pwd_something(String name, String pwd) throws Throwable {
		loginPage = new LoginPage();
		loginPage.sendDataPassengers3(name, pwd);
    }

    @Then("^i click on login button$")
    public void i_click_on_login_button() throws Throwable {
    	loginPage.clickOnButton();
 	   }

    @Given("^I see a message with title \"([^\"]*)\"$")
    public void i_see_a_message_with_title_something(String title) throws Throwable {
    	homePage = new HomePage();
    	Assert.assertEquals(title, homePage.checkTitle());
    }
    @Then("^I click on required checkbox$")
    public void i_click_on_required_checkbox() throws Throwable {
        homePage.clickOnRequiredCkbox();
    }

    @And("^I click on optional checkbox$")
    public void i_click_on_optional_checkbox() throws Throwable {
    	homePage.clickOnOptionalCkbox();
    }

    @And("^I click on Proceed to QKnows button$")
    public void i_click_on_proceed_to_qknows_button() throws Throwable {
    	homePage.clickOnProceedButton();
    }
    
    @Then("^Home Page with title \"([^\"]*)\" is shown$")
    public void home_page_with_title_something_is_shown(String title) throws Throwable {
    	Assert.assertEquals(title, homePage.checkTitleHomePage());
    }
    
    @When("^I send text (.+) in search area$")
    public void i_send_text_something_in_search_area(String text) throws Throwable {
        homePage.sendTextSearchField(text);
    }
    

    @And("^I click on search button$")
    public void i_click_on_search_button() throws Throwable {
        homePage.clickOnSearchBtn();
    }
    
    @Then("^the top 3 results contains the word (.+)$")
    public void the_top_3_results_contains_the_word_something(String word) throws Throwable {
        Assert.assertTrue(homePage.testResult(word));
    }
    
    
    
    @After
    public void killBrowser(Scenario scenario){
        if (scenario.isFailed()) {
         scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        driver.close();
        driver.quit();
    }
}
