package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(id = "searchBar")
    private WebElement searchBar;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchForItem(String item) {
        searchBar.sendKeys(item);
        searchButton.click();
    }
}