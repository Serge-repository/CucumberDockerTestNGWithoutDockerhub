package cucumber_step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import static cucumber_step_defs.DriverInitializer.driver;
import static org.testng.Assert.*;

public class SmokeDef {

    @Given("User is on homePage")
    public void userIsOnHomePage() {
        driver.navigate().to("http://demo.guru99.com/Agile_Project/Agi_V1/");
    }

    @Then("title of homePage is {string}")
    public void titleOfHomePageIs(String pageTitle) {
        assertEquals(pageTitle, driver.getTitle(), "Home page title is Guru99 Bank Home Page");
    }

    @And("login form is present")
    public void loginFormIsPresent() {
        assertTrue(driver.findElement(By.name("btnLogin")).isDisplayed());
    }

    @When("user click on newToursButton")
    public void userClickOnNewToursButton() {
        driver.findElement(By.xpath("//a[contains(@href,'newtours')]")).click();
    }

    @Then("title of newToursPage is {string}")
    public void titleOfNewToursPageIs(String pageTitle) {
        assertEquals(pageTitle, driver.getTitle(), "Title must be Welcome: Mercury Tours");
    }

    @And("main fragment is present")
    public void mainFragmentIsPresent() {
        assertTrue(driver.findElement(By.xpath("//img[contains(@src,'images/logo.gif')]")).isDisplayed());
    }

    @When("user click on tableDemoLink")
    public void userClickOnTableDemoLink() {
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li")).click();
        driver.findElement(By.xpath("//a[contains(@href,'table')]")).click();
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @Then("title of tablePage is {string}")
    public void titleOfTablePageIsCorrect(String tabName) {
        assertEquals(tabName, driver.getTitle(), "Title of the page is correct");
    }

    @And("table is present")
    public void tableIsPresent() {
        assertTrue(driver.findElement(By.xpath("//table")).isDisplayed());
    }
}
