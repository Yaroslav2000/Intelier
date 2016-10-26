package Intelier.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.Pages_FrontEnd_LandingPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class Steps_FrontEnd_LandingPages extends ScenarioSteps {

	Pages_FrontEnd_LandingPages FE;
	
    @Step
	public void open_vanity_URL(String string) {
		FE.open_vanity_URL(string);		
	}
    
    @Step
	public void should_see_English_PageTitle(String string) {
    	try {
    		FE.moveToElement(FE.English_PageTitle);
    		assertTrue(FE.English_PageTitle.containsText(string));
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_English_PageCopyHeadline(String string) {
    	try {
    		FE.moveToElement(FE.English_PageCopyHeadline);
    		assertTrue(FE.English_PageCopyHeadline.containsText(string));
    	} catch (NoSuchElementException ex) {}
	}
}
