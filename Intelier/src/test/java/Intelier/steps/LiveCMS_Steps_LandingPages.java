package Intelier.steps;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.LiveCMS_Pages_LandingPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LiveCMS_Steps_LandingPages extends ScenarioSteps {

	LiveCMS_Pages_LandingPages LiveCMS_Pages_LandingPages; 
	
// -----------------------------------------------------------------------------------------------------------------
// COMMON	
	
	@Step
	public void navigate_to_Client_Dashboard() {
		LiveCMS_Pages_LandingPages.open();
	}
	
	@Step
	public void navigate_to_LandingPages_module() {
		LiveCMS_Pages_LandingPages.navigate_to_LandingPages_module();
	}

	@Step
	public void open_Create_Campaign() {
		LiveCMS_Pages_LandingPages.CreateCampaign_BUTTON.click();
    	switch_to_iframe();
	}
	
	public void switch_to_iframe() {
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(LiveCMS_Pages_LandingPages.IFRAME);
	}
	
	@Step
	public void set_Brand(String string) {
		if (string.equals("Golden Circle")) {
			LiveCMS_Pages_LandingPages.Brand_GC_BUTTON.click();
		} else if (string.equals("Hotel Jen")) {
			LiveCMS_Pages_LandingPages.Brand_HJ_BUTTON.click();
		} else if (string.equals("Kerry Hotels")) {
			LiveCMS_Pages_LandingPages.Brand_KH_BUTTON.click();
		} else if (string.equals("Shangri-La")) {
			LiveCMS_Pages_LandingPages.Brand_SL_BUTTON.click();
		}
	}
	
	@Step
	public void set_Type(String string) {
		if (string.equals("Multi-Property")) {
			LiveCMS_Pages_LandingPages.Type_MultiProperty_BUTTON.click();
		} else if (string.equals("No Property")) {
			LiveCMS_Pages_LandingPages.Type_NoProperty_BUTTON.click();
		} else if (string.equals("Single-Property")) {
			LiveCMS_Pages_LandingPages.Type_SingleProperty_BUTTON.click();
		}
	}
	
	@Step
	public void set_Layout(String string) {
		LiveCMS_Pages_LandingPages.Layout_Template_BUTTON.click();
	}
	
	@Step
	public void go_Next() {
		LiveCMS_Pages_LandingPages.Next_BUTTON.waitUntilClickable().click();
	}
	
	@Step
	public void set_Account(String string) {
		LiveCMS_Pages_LandingPages.Account_DROPDOWN.selectByVisibleText(string);
	}

	@Step
	public void set_InternalName(String campaign) {
		LiveCMS_Pages_LandingPages.InternalName_TEXTBOX.type(campaign);
	}

	@Step
	public void set_ActiveDates_default() {
		LiveCMS_Pages_LandingPages.ActiveDates_StartDate_TEXTBOX.click();
		waitABit(250);
		LiveCMS_Pages_LandingPages.ActiveDates_StartDate_TEXTBOX.sendKeys(Keys.ENTER);
    	if (!LiveCMS_Pages_LandingPages.NoExpiry_CHECKBOX.isSelected()) {
    		LiveCMS_Pages_LandingPages.NoExpiry_CHECKBOX.click();
    	}
	}
	
	@Step
	public void set_Subdomain(String string) {
		LiveCMS_Pages_LandingPages.Subdomain_DROPDOWN.selectByVisibleText(string);
	}
	
	public Map<String, String> Generated_RandomVanityURL = new HashMap<String, String>();
	
	//workaround for bug SHLPC-550
	public Map<String, String> Generated_RandomCampaignNumber = new HashMap<String, String>();
	
	@Step
	public void set_RandomVanityURL_generate(String campaign) {
    	String Random_number = RandomStringUtils.randomNumeric(7);
    	String RandomVanityURL = campaign+"VanityURL"+Random_number;
    	LiveCMS_Pages_LandingPages.VanityURL_TEXTBOX.type(RandomVanityURL);	
    	Generated_RandomVanityURL.put(campaign, RandomVanityURL);
    	
    	//workaround for bug SHLPC-550
    	LiveCMS_Pages_LandingPages.InternalName_TEXTBOX.type(campaign+Random_number);
    	Generated_RandomCampaignNumber.put(campaign, Random_number);
	}
	
	@Step
	public void set_findProperty(String string) {
		LiveCMS_Pages_LandingPages.FindProperty_TEXTBOX.click();
		LiveCMS_Pages_LandingPages.select_Property(string);
	}
	
	@Step
	public void set_Languages_AddAll() {
		LiveCMS_Pages_LandingPages.AddAllLanguages_BUTTON.click();
	}

	@Step
	public void submit_Campaign() {
		LiveCMS_Pages_LandingPages.CreateCampaign_Submit_BUTTON.click();
	}
	
	@Step
	public void set_TitleTag(String string) {
		LiveCMS_Pages_LandingPages.TitleTag_TEXTBOX.type(string);
	}
	
	@Step
	public void set_MetaKeywords(String string) {
		LiveCMS_Pages_LandingPages.MetaKeywords_TEXTBOX.type(string);
	}
	
	@Step
	public void set_MetaDescription(String string) {
		LiveCMS_Pages_LandingPages.MetaDescription_TEXTBOX.type(string);
	}

	public void publish_Campaign() {
		LiveCMS_Pages_LandingPages.Publish_BUTTON.click();
	}
	
	
// -----------------------------------------------------------------------------------------------------------------
// VERIFICATIONS  
	
    @Step
	public void should_see_LandingPages_module() {
    	try {
    		assertTrue(LiveCMS_Pages_LandingPages.AllModules_BLOCK.toString().contains("Landing Pages"));
    	} catch (NoSuchElementException ex) {}
	}












}
