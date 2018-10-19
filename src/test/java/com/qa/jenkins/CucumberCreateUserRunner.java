package com.qa.jenkins;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\FridayAssessment (no Email Box).feature", glue = {"com.qa.jenkins"})

public class CucumberCreateUserRunner {

}
