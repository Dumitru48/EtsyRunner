package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement productName;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipcode;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expirateDate;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visaCard;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpress;
    @FindBy(tagName = "strong")
    WebElement message;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;
    public void provideProductInformation(String productName,String quantity){
        BrowserUtils.selectBy(this.productName,productName,"text");
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }
    public void provideAddressInformation(String name,String street,String city,String state,String zipCode){
        this.customerName.sendKeys(name);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipcode.sendKeys(zipCode);
    }
    public void providePaymentInformation(String cardNumber,String expireDate,String cardType){
        this.cardNumber.sendKeys(cardNumber);
        this.expirateDate.sendKeys(expireDate);
        selectCard(cardType);
    }
    public void selectCard(String cardType){
        cardType=cardType.toUpperCase();
        switch (cardType){
            case "VISA":
                visaCard.click();
                break;
            case "MASTERCARD":
                masterCard.click();
                break;
            case "AMERICAN EXPRESS":
                americanExpress.click();
                break;
            default:
                System.out.println("Card name is not found.Please provide valid card type");
        }
    }
    public void validateMessage(String message){
        processButton.click();
        Assert.assertEquals(message,BrowserUtils.getText(this.message));
    }

}