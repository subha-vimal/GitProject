package org.runner;

import org.helper.Jvm;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Facebook/Facebook.feature", glue = "org.stepDefinition", dryRun = false, plugin = {
		"html:target/Reports/HtmlReport/fb", "junit:target/Reports/JunitReport/fb.xml",
		"json:target/Reports/JsonRepot/fb.json" })

public class TestRunner {
	@AfterClass
	public static void tc() {
		System.out.println("before");
		Jvm.generatedJvmReport("target/Reports/JsonRepot/fb.json");
		System.out.println("after");
	}
}
