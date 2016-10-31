package Intelier.steps;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.Pages_FrontEnd_LandingPages;
import Intelier.pages.Pages_CustomActions;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class Steps_FrontEnd_LandingPages extends ScenarioSteps {

	Pages_FrontEnd_LandingPages FE;
	Pages_CustomActions Custom;

// -----------------------------------------------------------------------------------------------------------------
// COMMON	
	
    @Step
	public void open_vanity_URL(String string) {
		FE.open_vanity_URL(string);		
	}
    
    
// -----------------------------------------------------------------------------------------------------------------
// VERIFICATIONS 	
    
    @Step
	public void should_see_English_PageTitle(String string) {
    	try {
    		assertTrue(FE.English_PageTitle.containsText(string));
    		Custom.moveToElement(FE.English_PageTitle);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_English_PageCopyHeadline(String string) {
    	try {
    		assertTrue(FE.English_PageCopyHeadline.containsText(string));
    		Custom.moveToElement(FE.English_PageCopyHeadline);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_English_PageCopyContent(String string) {
    	try {
        	assertTrue(FE.Homepage.containsText(string));
    		Custom.moveToElementByText(string);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_English_PageCopyTermsConditions(String string) {
    	try {
        	FE.English_TermsConditions_Open.click();
    	} catch (NoSuchElementException ex) {}
    	try {
        	assertTrue(FE.English_TermsConditions.containsText(string));
    	} catch (NoSuchElementException ex) {}
    	Serenity.takeScreenshot();
    	try {
        	FE.English_TermsConditions_Close.click();
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_Property(String string) {
//    	System.out.println("////////////////////////////////////////");
//    	System.out.println(FE.Homepage.getText());
//    	System.out.println("////////////////////////////////////////");
//    	System.out.println(FE.get_PropertyText(string));
//    	System.out.println("////////////////////////////////////////");
    	try {
    		assertTrue(FE.Homepage.containsText(FE.get_PropertyText(string)));
    		Custom.moveToElementByText(string);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_Offer_English_Title(String string) {
    	try {
        	FE.Offer_Open.click();
    	} catch (NoSuchElementException ex) {}
    	try {
        	assertTrue(FE.Homepage.containsText(string));
        	Custom.moveToElementByText(string);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_Offer_English_Description(String string) {
    	try {
        	assertTrue(FE.Homepage.containsText(string));
    		Custom.moveToElementByText(string);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_Offer_English_TermsConditions(String string) {
    	try {
    		FE.Offer_English_TermsConditions_Open.click();
    		waitABit(500);
    	} catch (NoSuchElementException ex) {}
    	try {
        	assertTrue(FE.Homepage.containsText(string));
    		Custom.moveToElementByText(string);
    	} catch (NoSuchElementException ex) {}
	}

    
}
