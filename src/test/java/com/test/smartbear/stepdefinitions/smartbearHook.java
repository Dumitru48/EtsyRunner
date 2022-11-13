package com.test.smartbear.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class smartbearHook {

        WebDriver driver= DriverHelper.getDriver();
   @Before
       public void navigation(){
           driver.get(ConfigReader.readProperty("smartbearUrl"));
       }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotCucumber(scenario, driver);
        driver.quit();
    }

}