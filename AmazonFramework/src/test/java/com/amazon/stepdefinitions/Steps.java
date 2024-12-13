package com.amazon.stepdefinitions;

import com.amazon.pages.*;
import com.amazon.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Steps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    SearchPage searchPage = new SearchPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver); 

    @Given("user launches the application")
    public void userLaunchesTheApplication() {
        driver.get("https://www.amazon.com");
        String expectedTitle = "Amazon.com. Spend less. Smile more."; 
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Application did not launch correctly.");
    }

    @When("user logs in with username {string} and password {string}")
    public void userLogsIn(String username, String password) {
        loginPage.login(username, password);
        boolean isLoggedIn = loginPage.isLoggedIn(); 
        Assert.assertTrue(isLoggedIn, "Login failed.");
    }

    @When("user searches for {string}")
    public void userSearchesFor(String item) {
        searchPage.searchForItem(item);
        boolean isItemDisplayed = searchPage.isSearchResultDisplayed(item); 
        Assert.assertTrue(isItemDisplayed, "Search results for the item are not displayed.");
    }

    @When("user adds item to the cart")
    public void userAddsItemToCart() {
        cartPage.addToCart();
        boolean isItemInCart = cartPage.isItemInCart(); 
        Assert.assertTrue(isItemInCart, "Item was not added to the cart.");
    }

    @Then("user navigates to checkout")
    public void userNavigatesToCheckout() {
        checkoutPage.navigateToCheckout();
        boolean isOnCheckoutPage = checkoutPage.isOnCheckoutPage(); 
        Assert.assertTrue(isOnCheckoutPage, "Navigation to checkout page failed.");
    }
}
