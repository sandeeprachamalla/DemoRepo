package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features\\devops",glue={"Stepdefnition"},tags={"@UnderTest"},plugin={"html:target/cucumber-html-report"})
//glue={"Stepdefnition"},tags={"@UnderTest"},plugin={"html:target/cucumber-html-report"}
//tags={"~@outline"}
public class Runner {

}
