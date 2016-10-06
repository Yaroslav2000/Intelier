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
		liveCMSGeneric.Username_TEXTBOX.type("automation@Webcanada.com");
		liveCMSGeneric.Password_TEXTBOX.type("Automation123");
		liveCMSGeneric.Login_BUTTON.click();
    }
	
	@Step("Teardown")
    public void teardown() {
		liveCMSGeneric.Logout_LINK.click();
    }

}