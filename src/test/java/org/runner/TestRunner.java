package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\GitHub\\GitProject\\src\\test\\resources\\Facebook\\Facebook.feature",glue="org.stepDefinition",
dryRun = false,plugin= {"html:D:\\GitHub\\CucumberFacebook\\GitProject\\target\\Reports\\HtmlReport\\fb","junit:D:\\GitHub\\CucumberFacebook\\GitProject\\target\\Reports\\JunitReport\\fb.xml","json:D:\\GitHub\\CucumberFacebook\\GitProject\\target\\Reports\\JsonReport\\fb.json"}
)

public class TestRunner {

}
