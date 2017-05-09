package runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="features\\sample.feature",glue={"Stepdefnition"})
//

public class SampleRunner {

}
