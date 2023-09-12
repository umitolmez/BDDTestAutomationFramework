package com.automationExercise.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/features",
        glue = "com/automationExercise/stepDefinitions",
        dryRun = false,
        tags = "@TC4"
)
public class CukesRunner {
}