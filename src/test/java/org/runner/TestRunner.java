package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\GitHub\\CucumberFacebook\\GitProject\\src\\test\\resources\\Facebook\\Facebook.feature",glue="org.stepDefinition",
<<<<<<< HEAD
dryRun = false,plugin= {"json:D:\\GitHub\\CucumberFacebook\\GitProject\\target\\Reports\\fb.json"})
=======
dryRun = false,plugin= {"html:D:\\GitHub\\CucumberFacebook\\GitProject\\target\\Reports\\fb","junit:D:\\GitHub\\CucumberFacebook\\GitProject\\target\\Reports\\fb.xml"}
,tags="@sanity,@smoke")
>>>>>>> d925b8accb4e648a94780465f7cfcf95314d2ec4
public class TestRunner {

}
