package com.test.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[.='New User Signup!']")
    WebElement header;

    @FindBy(xpath = "//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "//input[@name='email' and @data-qa='signup-email']")
    WebElement emailAdress;

    @FindBy(xpath = "//button[.='Signup']")
    WebElement signUpButton;

    public boolean validateHeader(){
        return header.isDisplayed();
    }

    public void sendingInformation(String name,String email){
        this.name.sendKeys(name);
        emailAdress.sendKeys(email);
        signUpButton.click();
    }
}