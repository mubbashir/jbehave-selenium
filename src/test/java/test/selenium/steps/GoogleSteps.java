package test.selenium.steps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import test.selenium.page.google.GoogleLanding;

public class GoogleSteps extends ScenarioSteps {

	@Managed(driver = "firefox")
	WebDriver driver;
	private final Pages pages;

	public GoogleSteps(Pages pages) {
		this.pages = pages;
	}

	GoogleLanding landingPage;

	@Step @Given("the user accesses the google landing page")
	public void open_landing_page(){
		landingPage.open();
	}

	@Step @When("they type in $keyword")
	public void search_for_keyword(String keyword){
		landingPage.search(keyword);
	}

	@Step @Then("we should see $keyword")
	public void find_in_results(String keyword){
		landingPage.findUrl(keyword);
	}

	@Step @Then("click on $keyword")
	public void click_on(String keyword){
//		driver.manage().deleteAllCookies();
	}
}
