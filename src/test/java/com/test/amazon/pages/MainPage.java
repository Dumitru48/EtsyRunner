package com.test.amazon.pages;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;
public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(xpath = "//span[contains(text(),'results for')]")
    WebElement result;

    @FindBy(tagName = "h2")
    List<WebElement> allHeaders;//40

    public void searchWord(String key){
        searchBox.sendKeys(key, Keys.ENTER);
    }

    public boolean validateResult(){
        if(result.getText().contains("50,000")){
            return true;
        }
        return false;
    }

    public void validateHeaders(String word){
        for(WebElement header:allHeaders){
            if(!BrowserUtils.getText(header).equals("")){
                Assert.assertTrue(BrowserUtils.getText(header).toLowerCase().contains(word));
            }
        }
    }
}