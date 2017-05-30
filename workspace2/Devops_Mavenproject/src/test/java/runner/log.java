package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features\\devops\\1login.feature",glue={"Stepdefnition"},tags={"@UnderTest"})
//glue={"Stepdefnition"},tags={"@UnderTest"}
//tags={"~@outline"}
public class log {

}
