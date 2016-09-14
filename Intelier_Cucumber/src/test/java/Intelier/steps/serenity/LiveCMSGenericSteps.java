package Intelier.steps.serenity;

import Intelier.pages.LiveCMSGeneric;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LiveCMSGenericSteps extends ScenarioSteps {
	
	LiveCMSGeneric liveCMSGeneric;

	@Step
    public void setup() {
		liveCMSGeneric.open();
		liveCMSGeneric.login();
    }
	
	@Step
    public void teardown() {
		liveCMSGeneric.logout();
    }

}