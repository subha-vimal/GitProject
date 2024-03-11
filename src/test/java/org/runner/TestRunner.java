package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\GitHub\\CucumberFacebook\\GitProject\\src\\test\\resources\\Facebook\\Facebook.feature",glue="org.stepDefinition",
dryRun = false,plugin= {"html:D:\\GitHub\\CucumberFacebook\\GitProject\\target\\Reports\\fb"},tags="@sanity,@smoke")
public class TestRunner {

}
