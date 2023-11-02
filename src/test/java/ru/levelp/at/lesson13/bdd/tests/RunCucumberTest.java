package ru.levelp.at.lesson13.bdd.tests;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("ru/levelp/at/lesson13/bdd")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ru.levelp.at.lesson13.bdd")
// @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@smoke")
public class RunCucumberTest {
}
