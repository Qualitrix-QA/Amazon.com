package com.amazon.stepdefinitions;

import com.amazon.pages.*;
import com.amazon.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class Steps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    SearchPage searchPage = new SearchPage(driver);
    CartPage cartPage = new CartPage(driver);

    @Given("user launches the application")
    public void userLaunchesTheApplication() {
        driver.get("https://www.amazon.com");
    }

    @When("user logs in with username {string} and password {string}")
    public void userLogsIn(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user searches for {string}")
    public void userSearchesFor(String item) {
        searchPage.searchForItem(item);
    }

    @When("user adds item to the cart")
    public void userAddsItemToCart() {
        cartPage.addToCart();
    }

    @Then("user navigates to checkout")
    public void userNavigatesToCheckout() {
        // Implementation of checkout
    }
}