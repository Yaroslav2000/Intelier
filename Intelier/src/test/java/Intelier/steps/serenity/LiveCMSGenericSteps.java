package Intelier.steps.serenity;

import Intelier.pages.LiveCMSGeneric;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LiveCMSGenericSteps extends ScenarioSteps {
	
	LiveCMSGeneric liveCMSGeneric;

// -----------------------------------------------------------------------------------------------------------------
// TASKS
	
	@Step("LiveCMS Setup")
    public void setup() {
		liveCMSGeneric.open();
		liveCMSGeneric.login("automation@Webcanada.com","Automation123");
    }
	
	@Step("Teardown")
    public void teardown() {
		liveCMSGeneric.logout();
    }

}