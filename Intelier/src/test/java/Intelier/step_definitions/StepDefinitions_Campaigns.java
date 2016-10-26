package Intelier.step_definitions;

import net.thucydides.core.annotations.Steps;

import org.openqa.selenium.JavascriptExecutor;

import Intelier.steps.Steps_FrontEnd_LandingPages;
import Intelier.steps.Steps_LiveCMS_LandingPages;
import Intelier.testdata.TestData_AccommodationRooms;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions_Campaigns {
	
    @Steps
    Steps_LiveCMS_LandingPages BE;
    
    @Steps
    Steps_FrontEnd_LandingPages FE;
    
//Background:
    
    @Given("Back-end Administrator has opened Landing Pages module")
    public void navigate_to_Landing_Pages_module() {
    	BE.navigate_to_Client_Dashboard();
    	BE.should_see_LandingPages_module();
    	BE.navigate_to_LandingPages_module();
    }
    
//Scenario: Add new campaign
    
//    @Given("No campaign '(.*)'  is in the campaigns list")
//    public void no_campaign_in_the_campaigns_list() {
//    }
    
    @When("Back-end Administrator adds new campaign '(.*)' with default settings")
    public void add_new_campaign(String campaign) {
    	BE.open_Create_Campaign();
    	BE.set_Brand("Shangri-La");
    	BE.set_Type("Single-Property");
    	BE.set_Layout("Template");
    	BE.go_Next();
    	BE.set_Account("SLIM - SLIM / Brand");
    	BE.set_InternalName(campaign);
    	BE.set_ActiveDates_default();
    	BE.set_Subdomain("promo");
    	BE.set_RandomVanityURL_generate(campaign);
    	BE.go_Next();
    	BE.set_findProperty("CWH");
    	BE.go_Next();
    	BE.set_Languages_AddAll();
    	BE.submit_Campaign();
    	BE.set_English_TitleTag("AutomationCampaign English TitleTag");
    	BE.set_English_MetaKeywords("AutomationCampaign English MetaKeywords");
    	BE.set_English_MetaDescription("AutomationCampaign English MetaDescription");
    	BE.set_English_PageTitle("AutomationCampaign English PageTitle");
    	BE.set_English_PageCopyHeadline("AutomationCampaign English PageCopyHeadline");
    	BE.publish_Campaign();
    	BE.go_Settings();
    	BE.set_StatusActive();
    	BE.save_changes();
    }

	@Then("Back-end Administrator should save campaign '(.*)' new settings")
    public void should_save_campaign_new_settings(String campaign) {
		BE.navigate_to_LandingPages_module();
		BE.search_campaign(BE.Generated_RandomCampaignName.get(campaign));
		BE.should_see_campaign_in_the_list(BE.Generated_RandomCampaignName.get(campaign));
    }
    
    @Then("Front-end User should see campaign '(.*)' new settings")
    public void should_see_campaign_new_settings_FE(String campaign) {
    	FE.open_vanity_URL(BE.Generated_RandomVanityURL.get(campaign));
    	FE.should_see_English_PageTitle("AutomationCampaign English PageTitle".toUpperCase());
    	FE.should_see_English_PageCopyHeadline("AutomationCampaign English PageCopyHeadline");
    }
    
    
}