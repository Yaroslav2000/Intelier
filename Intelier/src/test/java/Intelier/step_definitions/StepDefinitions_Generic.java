package Intelier.step_definitions;

import Intelier.steps.LiveCMS_Steps_Generic;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Steps;

public class StepDefinitions_Generic {

    @Steps
    LiveCMS_Steps_Generic LiveCMSGenericSteps;
	
    @Before
    public void setup() {
    	LiveCMSGenericSteps.setup();
    }
    
    @After
    public void teardown() {
    	LiveCMSGenericSteps.teardown();
    }
	
}
