package com.test.smartbear.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/resources/features/smartbear",  //for feature is content root on feature right click
        glue="com/test/smartbear/stepdefinitions",  //for glue is SOURCE ROOT of stepdefinitions package
        dryRun=false,       //if is true, gets you the snippets and is looking only for "Is IMPLEMENTED or NOT"
        //you'll not see opened pages
        //the scope of dryRun true is only ot run the code
        //if you don't need to wait for the whole webpage running ONLY run the method above
        //which is running with no printing webpage
        //!!!!!all tests will pass!!!!! as long as snippets are implemented
        //if you make it FALSE you'll see opened pages
        tags="@smart",   //"@smart" link to feature files
        plugin={"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)
public class Runner {

}