package com.test.webOrder.pages;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DriverHelper;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@for='GroupOrder']")
    WebElement groupOrderBox;

    @FindBy(id = "getAddressNextButton")
    WebElement nextButton;

    @FindBy(id = "InviteNote")
    WebElement inviteesBox;

    @FindBy(id = "InviteList")
    WebElement inviteListBox;

    @FindBy(id = "ConfirmAddressID")
    WebElement location;

    @FindBy(id = "addressPreview")
    WebElement address;

    @FindBy(id = "createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath="//label[.='Total Participants:']//following-siblings::div")  //using following siblings. can also use for sibling-->> ..//div
    WebElement totalParticipant;

    public void clickButtons() {
        groupOrderBox.click();
        nextButton.click();
    }

    public void sendInvitees(String invitees) {
        this.inviteesBox.sendKeys(invitees);
    }

    public void sendInviteList(String firstEmail, String secondEmail) {
        inviteListBox.sendKeys(firstEmail + " , " + secondEmail);
    }

    public void validateAddress(String location, String address) {
        BrowserUtils.selectBy(this.location, location, "text");
        Assert.assertTrue(BrowserUtils.getText(this.address).contains(address));
    }

    public void clickGroupOrderButton() {
        createGroupOrderButton.click();
    }
    public String validateHeader() throws InterruptedException{
        Thread.sleep(3000);
        return BrowserUtils.getText(header);
    }
    public int validateParticipant(){
        return Integer.parseInt(BrowserUtils.getText(totalParticipant));
    }
    //The main purpose of using the parseInt function is to EXTRACT a NUMBER from a STRING.
    // This turns the returned value to an actual number.
}