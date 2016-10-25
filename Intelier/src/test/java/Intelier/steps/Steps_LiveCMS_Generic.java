package Intelier.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.Pages_LiveCMS_Generic;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class Steps_LiveCMS_Generic extends ScenarioSteps {
	
	Pages_LiveCMS_Generic liveCMSGeneric;

// -----------------------------------------------------------------------------------------------------------------
// LOGIN & LOGOUT

	@Step("LiveCMS Setup")
    public void setup() {
		liveCMSGeneric.open();
		liveCMSGeneric.Username_TEXTBOX.type("automation@Webcanada.com");
		liveCMSGeneric.Password_TEXTBOX.type("Automation123");
		liveCMSGeneric.Login_BUTTON.click();
    }
	
	@Step("Teardown")
    public void teardown() {
    	try {
    		liveCMSGeneric.Logout_LINK.click();
    	} catch (NoSuchElementException ex) {}
	}
	
}