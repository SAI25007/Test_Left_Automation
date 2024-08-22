package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

// Use dryRun=true, to execute testCases without stopping 

@CucumberOptions(features="src/test/java/Features",
glue="Steps",monochrome=true, tags="@Auto")


//, plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json"}
//pretty is used to generate different type of filesy

public class TestNGRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel=true)
//    public Object[][] scenarios()
//    {
//        return super.scenarios();
//    }
}
