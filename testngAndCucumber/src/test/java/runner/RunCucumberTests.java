package runner;

import stepPages.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(features="src/test/java/features/EditIncident.feature",
			glue={"stepPages","hooksImplementation"},
			monochrome=true,
			publish=true)
public class RunCucumberTests extends ProjectSpecificMethods {

}

