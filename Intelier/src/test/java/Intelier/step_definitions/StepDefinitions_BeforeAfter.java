package Intelier.step_definitions;

import Intelier.steps.Steps_LiveCMS_BeforeAfter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Steps;

public class StepDefinitions_BeforeAfter {

    @Steps
    Steps_LiveCMS_BeforeAfter BE;
	
    @Before
    public void setup() {
    	BE.setup();
    }
    
    @After
    public void teardown() {
    	BE.teardown();
    }
	
}
