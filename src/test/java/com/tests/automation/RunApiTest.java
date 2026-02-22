package com.tests.automation;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/spec/features",
        //glue = "",
        plugin = {"pretty",
                "html:target/report-back/cucumber-report.html",
                "json:target/report-back/cucumber.json"},
        tags = ("@users"),
        monochrome = true,
        snippets = CAMELCASE
)
public class RunApiTest {
}
