package com.test.etsy.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "@target/uiFailedTests.txt",
        glue="com/test/webOrder/stepdefinitions",
        dryRun=false,
        tags="@regression",   //used under feature files
        plugin={"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)
public class ReRunner {
}