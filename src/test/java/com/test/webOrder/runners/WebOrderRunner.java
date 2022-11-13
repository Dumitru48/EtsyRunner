package com.test.webOrder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/resources/features/weborder",  //for feature is content root on feature right click
        glue="com/test/webOrder/stepdefinitions",  //for glue is SOURCE ROOT
        dryRun=false,       //if is true is looking only for "Is IMPLEMENTED or NOT"
                            //you'll not see opened pages
                             //the scope of dryRun trues is only ot run the code not execute it
                            //if you don't need to wait for the whole webpage running ONLY run the method above
                            //which is running with no printing webpage
                            //!!!!!all tests will pass!!!!! as long as snippets are implemented
                            //if you make it FALSE you'll see opened pages
        tags="@regression",   //used under feature files
        plugin={"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)
public class WebOrderRunner {

}