package pages;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;


public class HomePage extends BaseTest {

	//Popup
	@FindBy(xpath = "//div[contains(text(),'QKnows Terms of Use')]")
	public WebElement TitleModel;
	@FindBy(css = "body.no-scrolling:nth-child(2) div.modal-dialog-wrapper div.modal-dialog div.modal-dialog-control div.modal-dialog-control-checkbox div.checkbox:nth-child(1)")
	public WebElement RequiredCbx;
	@FindBy(css = "body.no-scrolling:nth-child(2) div.modal-dialog-wrapper div.modal-dialog div.modal-dialog-control div.modal-dialog-control-checkbox div.checkbox:nth-child(3)")
	public WebElement OptionalCbx;
	@FindBy(css = "body.no-scrolling:nth-child(2) div.modal-dialog-wrapper div.modal-dialog div.modal-dialog-control div.modal-dialog-control-checkbox div.checkbox:nth-child(3) div.checkbox-label span:nth-child(1) > strong:nth-child(1)")
	public WebElement OptionalCbxText;
	@FindBy(css = "body.no-scrolling:nth-child(2) div.modal-dialog-wrapper div.modal-dialog div.modal-dialog-control div.modal-dialog-control-submit div.button-wrapper > button.button")
	public WebElement ProceedBtn;
	
	//HomePage
	@FindBy(xpath = "//a[contains(text(),'QKnows')]")
	public WebElement TitleHomePage;
	@FindBy(css = "#searchbar-activeinput")
	public WebElement SearchArea;
	@FindBy(css = "#searchbar-magnifier")
	public WebElement SearchBtn;
	@FindBy(css = "div.page-result div.page-result-view div.search-result-grid-wrapper div.search-result-list-center-wrapper div.search-result-list-wrapper div.search-result-list div.search-result-list-main div:nth-child(1) div.search-result > div.search-result-abstract")
	public WebElement firstResult;
	@FindBy(css = "div.page-result div.page-result-view div.search-result-grid-wrapper div.search-result-list-center-wrapper div.search-result-list-wrapper div.search-result-list div.search-result-list-main div:nth-child(2) div.search-result > div.search-result-abstract")
	public WebElement secondResult;
	@FindBy(css = "div.page-result div.page-result-view div.search-result-grid-wrapper div.search-result-list-center-wrapper div.search-result-list-wrapper div.search-result-list div.search-result-list-main div:nth-child(3) div.search-result > div.search-result-abstract")
	public WebElement thirdResult;

	public HomePage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	public String checkTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(TitleModel, "QKnows Terms of Use"));
		return TitleModel.getText();
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

	public void clickOnRequiredCkbox() {
	    utilities.TestUtil.ExplicitInvisibilityWaitOne(RequiredCbx).click();
	    log.info("I click on required checkbox");
	}

	public void clickOnOptionalCkbox() {
		System.out.println("traza:   "+driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.textToBePresentInElement(OptionalCbxText, "Yes, I would like to receive e-mail updates about QKnows news and events."));
		System.out.println("traza:   "+driver.getTitle());
		utilities.TestUtil.ExplicitClickableWaitOne(OptionalCbx).click();
	    log.info("I click on optional checkbox");
	}

	public void clickOnProceedButton() {
	    utilities.TestUtil.ExplicitInvisibilityWaitOne(ProceedBtn).click();
	    log.info("I click on login button");
	}

	public String checkTitleHomePage() {
		return TitleHomePage.getText();
	}

	public void sendTextSearchField(String text) {
	    utilities.TestUtil.ExplicitInvisibilityWaitOne(SearchArea).sendKeys(text);
	}
	
	public void clickOnSearchBtn() {
	    utilities.TestUtil.ExplicitInvisibilityWaitOne(SearchBtn).click();
	}

	public boolean testResult(String word) {
		// test word in text of every 
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(firstResult, word));
		wait.until(ExpectedConditions.textToBePresentInElement(secondResult, word));
		wait.until(ExpectedConditions.textToBePresentInElement(thirdResult, word));
		return utilities.TestUtil.CheckWordMatchText(firstResult.getText(),word);
		}
	
	
}	



