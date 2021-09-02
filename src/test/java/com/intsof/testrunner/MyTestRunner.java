package com.intsof.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(		
		features= {"src/test/resources/com/intsof/features"},
		glue = {"com/intsof/stepdefinitions","com/intsof/hooks"},
		plugin = {"pretty"},
		tags="@Smoke",
		publish = true,
		monochrome = true		
		)

public class MyTestRunner {

}
