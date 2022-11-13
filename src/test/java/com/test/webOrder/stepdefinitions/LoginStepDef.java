package com.test.webOrder.stepdefinitions;

import com.test.webOrder.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    /*@Given("User navigates to the {string}")
    public void user_navigates_to_the(String website) {
        driver.get(website);
    }*/
    @When("User provides username {string} and password {string}")
    public void user_provides_username_and_password_guest1(String username, String password) {
    loginPage.login(username, password);


    }
    @Then("User validates the title {string} from homepage")
    public void user_validates_the_title_from_homepage(String title) {
        Assert.assertEquals(title, driver.getTitle().trim());
        driver.quit();
    }

    @Then("User validates the message {string} from login page")
    public void user_validates_the_message_from_login_page(String errorMessage) {
       Assert.assertEquals(errorMessage, loginPage.errorMessage());
    }
    @Then("User exits the website")
    public void user_exits_the_website() {
   // driver.quit();
    }

}