package com.test.amazon.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/test/amazon/stepdefinitions",
        dryRun = false,
        tags ="@amazon",
        plugin ={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt",
                "json:target/cucumber-reports/cucumber.json"}
)
public class Runner {
}