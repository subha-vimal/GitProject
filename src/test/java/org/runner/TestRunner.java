package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Admin\\eclipse-workspace\\FacebookCucumber\\src\\test\\resources\\Facebook\\Facebook.feature",glue="org.stepDefinition",
dryRun = true)
public class TestRunner {

}
