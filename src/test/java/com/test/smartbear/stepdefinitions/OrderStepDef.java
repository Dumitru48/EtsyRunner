package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.LoginPage;
import com.test.smartbear.pages.MainPage;
import com.test.smartbear.pages.OrderPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;


public class OrderStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginpage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);

    @Given("User provides valid username and password")
    public void user_provides_valid_username_and_password() {
        loginpage.login("Tester", "test");
    }

    @Then("User validates the {string} and click Order Button")
    public void user_validates_the_and_click_order_button(String title) {
        Assert.assertEquals(title, driver.getTitle().trim());
        mainPage.clickOrderButton();
    }

    @When("User enters the product information {string} and {string}")
    public void user_enters_the_product_information_and(String productName, String quantity) {
        orderPage.provideProductInformation(productName, quantity);
    }

    @When("User enters the address information {string}, {string}, {string}, {string}, {string}")
    public void user_enters_the_address_information(String name, String street, String city, String state, String zip) {
orderPage.provideAddressInformation(name,street, city, state, zip);
    }

    @When("User enters payment information {string}, {string}, {string}")
    public void user_enters_payment_information(String cardNumber, String expirateDate, String cardType) {
orderPage.providePaymentInformation(cardNumber, expirateDate, cardType);
    }

    @Then("User clicks process button and validate the message {string}")
    public void user_clicks_process_button_and_validate_the_message(String message) {
orderPage.validateMessage(message);
    }
}