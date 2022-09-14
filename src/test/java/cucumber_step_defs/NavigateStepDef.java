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

public class NavigateStepDef {

    @Given("user is on home page")
    public void userIsOnHomePage() {
        driver.navigate().to("http://demo.guru99.com/");
    }

    @When("user navigates to agile page")
    public void userNavigatesToAgilePage() {
        driver.findElement(By.xpath("//a[contains(@href,'Agile_Project')]")).click();
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @And("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        if (username.equals("1303") && password.equals("Guru99")) {
            assertEquals(username, "1303", "We enter correct username");
            assertEquals(password, "Guru99", "We enter correct password");
        } else {
            System.out.println("Username or password is incorrect");
        }
    }

    @And("click login button")
    public void clickLoginButton() {
        driver.findElement(By.name("btnLogin")).click();
    }

    @Then("welcome message is correct")
    public void welcomeMessageIsCorrect() {
        String message = driver.findElement(By.tagName("marquee")).getText();
        assertEquals(message, "Welcome To Customer's Page of Guru99 Bank", "Welcome message is positive");
    }

    @Then("invalid credentials message is shown")
    public void invalidCredentialsMessageIsShown() {
        String message = driver.switchTo().alert().getText();
        assertEquals(message, "User or Password is not valid", "Welcome message is negative");
    }
}
