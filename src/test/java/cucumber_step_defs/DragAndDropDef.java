package cucumber_step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static cucumber_step_defs.DriverInitializer.driver;
import static org.testng.Assert.*;

public class DragAndDropDef {

    @Given("user is on dragAndDrop page")
    public void userIsOnDragAndDropPage() {
        driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
    }

    @When("user drop debit account {string}")
    public void userDropDebitAccount(String elementText) {
        WebElement originBankElement = driver.findElement(By.cssSelector("li[id='credit2']>a"));
        WebElement destinationBankElement = driver.findElement(By.id("bank"));

        Actions action = new Actions(driver);
        action.dragAndDrop(originBankElement, destinationBankElement).build().perform();

        assertEquals("User drops BANK element", originBankElement.getText().trim(), elementText);
        assertTrue(driver.findElement(By.xpath("//ol[@id='bank']/li[@data-id='5']"))
                .isDisplayed(),"Bank element is displayed in a table");
    }

    @And("user drop debit amount {string}")
    public void userDropDebitAmount(String elementText) {
        WebElement originDebit = driver.findElement(By.cssSelector("#fourth:nth-child(2)>a"));
        WebElement destinationDebit = driver.findElement(By.id("amt7"));

        Actions action = new Actions(driver);
        action.dragAndDrop(originDebit, destinationDebit).build().perform();

        assertEquals("User drops debit element", originDebit.getText().trim(), elementText);
        assertTrue(driver.findElement(By.xpath("//ol[@id='amt7']/li[@data-id='2']"))
                .isDisplayed());
    }

    @And("user drop credit account {string}")
    public void userDropCreditAccount(String elementText) {
        WebElement originSalesElement = driver.findElement(By.id("credit1"));
        WebElement destinationSalesElement = driver.findElement(By.id("loan"));

        Actions action = new Actions(driver);
        action.dragAndDrop(originSalesElement, destinationSalesElement).build().perform();

        assertEquals("User drops SALES element", originSalesElement.getText().trim(), elementText);
        assertTrue(driver.findElement(By.xpath("//ol[@id='loan']/li[@data-id='6']"))
                .isDisplayed(), "Sales element is displayed in a table");
    }

    @And("user drop credit amount {string}")
    public void userDropCreditAmount(String elementText) {
        WebElement originCreditElement = driver.findElement(By.cssSelector("#fourth:nth-child(4)"));
        WebElement destinationCreditElement = driver.findElement(By.id("amt8"));

        Actions action = new Actions(driver);
        action.dragAndDrop(originCreditElement, destinationCreditElement).build().perform();

        assertEquals("User drops credit element", originCreditElement.getText().trim(), elementText);
        assertTrue(driver.findElement(By.xpath("//ol[@id='amt8']/li[@data-id='2']"))
                .isDisplayed(), "Credit value displayed in a table");
    }

    @Then("success message is shown")
    public void successMessageIsShown() {
        assertEquals("Checking if Perfect! message appears", driver.findElement(By.xpath("(//a[@class='button button-green'])[1]"))
                .getText(), "Perfect!");
    }
}
