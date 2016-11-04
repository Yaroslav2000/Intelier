package Intelier.steps;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.Pages_FrontEnd_LandingPages;
import Intelier.pages.Pages_CustomActions;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
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
	public void should_see_PageLogo() {
    	try {
    		assertTrue(FE.containsElements(FE.PageLogo.toString()));
    		Custom.moveToElement(FE.PageLogo);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_PageContactUs() {
    	try {
    		assertTrue(FE.containsText("Contact Us"));
    		Custom.moveToElementByText("Contact Us");
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_PageFindHotel() {
    	try {
    		assertTrue(FE.containsText("Find a Hotel"));
    		Custom.moveToElementByText("Find a Hotel");
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_PageCurrency() {
    	try {
    		assertTrue(FE.containsElements(FE.PageCurrency.toString()));
    		Custom.moveToElement(FE.PageCurrency);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_PageLanguage() {
    	try {
    		assertTrue(FE.containsElements(FE.PageLanguage.toString()));
    		Custom.moveToElement(FE.PageLanguage);
    	} catch (NoSuchElementException ex) {}
	}
    
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
//    	System.out.println(FE.Homepage.getText());
//    	System.out.println("////////////////////////////////////////");
//    	System.out.println(FE.get_PropertyText(string));
    	try {
    		assertTrue(FE.Homepage.containsText(FE.get_PropertyText(string)));
    		Custom.moveToElementByText(string);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_Offer_English_Title(String string) {
    	try {
        	FE.get_TitleXPath(string).click();         	
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
    		FE.get_TermsConditionsXPath(string).click();
    		waitABit(500);
    	} catch (NoSuchElementException ex) {}
    	try {
        	assertTrue(FE.Homepage.containsText(string));
    		Custom.moveToElementByText(string);
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_English_ShareThisPage() {
    	try {
    		assertTrue(FE.English_SocialSharing.containsText("share this page"));
    		Custom.moveToElement(FE.English_SocialSharing);
    	} catch (NoSuchElementException ex) {}
	}
    
    @Step
	public void should_see_PageFooter() {
    	try {
    		assertTrue(FE.containsElements(FE.PageFooter.toString()));
    		Custom.moveToElement(FE.PageFooter);
    	} catch (NoSuchElementException ex) {}
	}




    
}
