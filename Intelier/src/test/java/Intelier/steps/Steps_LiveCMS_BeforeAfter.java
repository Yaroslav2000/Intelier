package Intelier.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.Pages_LiveCMS_BeforeAfter;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class Steps_LiveCMS_BeforeAfter extends ScenarioSteps {
	
	Pages_LiveCMS_BeforeAfter BE;

// -----------------------------------------------------------------------------------------------------------------
// LOGIN & LOGOUT

	@Step("LiveCMS Setup")
    public void setup() {
		BE.open();
		BE.Username_TEXTBOX.type("automation@Webcanada.com");
		BE.Password_TEXTBOX.type("Automation123");
		BE.Login_BUTTON.click();
    }
	
	@Step("Teardown")
    public void teardown() {
    	//waitABit(1000000);
//		try {
//			BE.Logout_LINK.click();
//    	} catch (NoSuchElementException ex) {}
	}
	
}