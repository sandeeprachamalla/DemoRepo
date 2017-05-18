package runner;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="features\\funds.feature",glue={"Stepdefnition"},tags={"@UnderTest"})
//,glue={"Stepdefnition"},tags={"@UnderTest"}
//,tags={"~@outline"}

public class funds {

}
