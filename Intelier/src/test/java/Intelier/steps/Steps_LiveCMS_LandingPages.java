package Intelier.steps;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.Pages_LiveCMS_LandingPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.components.HtmlTable;
import net.thucydides.core.steps.ScenarioSteps;

public class Steps_LiveCMS_LandingPages extends ScenarioSteps {

	Pages_LiveCMS_LandingPages BE; 
	
// -----------------------------------------------------------------------------------------------------------------
// COMMON	
	
	@Step
	public void navigate_to_Client_Dashboard() {
		BE.open();
	}
	
	@Step
	public void navigate_to_LandingPages_module() {
		BE.navigate_to_LandingPages_module();
	}

	@Step
	public void open_Create_Campaign() {
		BE.CreateCampaign_BUTTON.click();
    	switch_to_iframe();
	}
	
	@Step
	public void search_campaign(String campaign) {
		BE.Search_TEXTBOX.type(campaign);
		BE.Search_TEXTBOX.sendKeys(Keys.ENTER);
	}
	
	
	
// -----------------------------------------------------------------------------------------------------------------
// CAMPAIGN IFRAME	
	
	public void switch_to_iframe() {
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(BE.IFRAME);
	}
	
	@Step
	public void set_Brand(String string) {
		if (string.equals("Golden Circle")) {
			BE.Brand_GC_BUTTON.click();
		} else if (string.equals("Hotel Jen")) {
			BE.Brand_HJ_BUTTON.click();
		} else if (string.equals("Kerry Hotels")) {
			BE.Brand_KH_BUTTON.click();
		} else if (string.equals("Shangri-La")) {
			BE.Brand_SL_BUTTON.click();
		}
	}
	
	@Step
	public void set_Type(String string) {
		if (string.equals("Multi-Property")) {
			BE.Type_MultiProperty_BUTTON.click();
		} else if (string.equals("No Property")) {
			BE.Type_NoProperty_BUTTON.click();
		} else if (string.equals("Single-Property")) {
			BE.Type_SingleProperty_BUTTON.click();
		}
	}
	
	@Step
	public void set_Layout(String string) {
		BE.Layout_Template_BUTTON.click();
	}
	
	@Step
	public void go_Next() {
		BE.Next_BUTTON.waitUntilClickable().click();
	}
	
	@Step
	public void set_Account(String string) {
		BE.Account_DROPDOWN.selectByVisibleText(string);
	}

	@Step
	public void set_InternalName(String campaign) {
		BE.InternalName_TEXTBOX.type(campaign);
	}

	@Step
	public void set_ActiveDates_default() {
		BE.ActiveDates_StartDate_TEXTBOX.type(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    	if (!BE.NoExpiry_CHECKBOX.isSelected()) {
    		BE.NoExpiry_CHECKBOX.click();
    	}
	}
	
	@Step
	public void set_Subdomain(String string) {
		BE.Subdomain_DROPDOWN.selectByVisibleText(string);
	}
	
	public Map<String, String> Generated_RandomVanityURL = new HashMap<String, String>();
	
	//workaround for bug SHLPC-550
	public Map<String, String> Generated_RandomCampaignName = new HashMap<String, String>();
	
	@Step
	public void set_RandomVanityURL_generate(String campaign) {
    	String Random_number = RandomStringUtils.randomNumeric(7);
    	String RandomVanityURL = campaign+"VanityURL"+Random_number;
    	BE.VanityURL_TEXTBOX.type(RandomVanityURL);	
    	Generated_RandomVanityURL.put(campaign, RandomVanityURL);
    	
    	//workaround for bug SHLPC-550
    	String RandomCampaignName = campaign+Random_number;
    	BE.InternalName_TEXTBOX.type(RandomCampaignName);
    	Generated_RandomCampaignName.put(campaign, RandomCampaignName);
	}
	
	@Step
	public void set_findProperty(String string) {
		BE.FindProperty_TEXTBOX.click();
		BE.select_Property(string);
	}
	
	@Step
	public void set_Languages_AddAll() {
		BE.AddAllLanguages_BUTTON.click();
	}

	@Step
	public void submit_Campaign() {
		BE.CreateCampaign_Submit_BUTTON.click();
	}
	
	@Step
	public void set_English_TitleTag(String string) {
		BE.TitleTag_TEXTBOX.type(string);
	}
	
	@Step
	public void set_English_MetaKeywords(String string) {
		BE.MetaKeywords_TEXTBOX.type(string);
	}
	
	@Step
	public void set_English_MetaDescription(String string) {
		BE.MetaDescription_TEXTBOX.type(string);
	}
	
	@Step
	public void set_English_PageTitle(String string) {
		BE.PageTitle_TEXTBOX.type(string);
	}

	@Step
	public void set_English_PageCopyHeadline(String string) {
		BE.PageCopyHeadline_TEXTBOX.type(string);
	}

	@Step
	public void publish_Campaign() {
		BE.Publish_BUTTON.click();
	}
	
	@Step
	public void go_Settings() {
		BE.Settings_BUTTON.click();
	}
	
	@Step
	public void set_StatusActive() {
		BE.StatusActive_CHECKBOX.click();
	}

	@Step
	public void save_changes() {
		BE.Save_BUTTON.click();
	}
	
// -----------------------------------------------------------------------------------------------------------------
// VERIFICATIONS  
	
    @Step
	public void should_see_LandingPages_module() {
    	try {
    		assertTrue(BE.AllModules_BLOCK.containsText("Landing Pages"));
    	} catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_see_campaign_in_the_list(String campaign) {
    	try {
    		assertTrue(HtmlTable.rowsFrom(BE.CampaignsList_TABLE).toString().contains(campaign));
    	} catch (NoSuchElementException ex) {}
	}





















}
