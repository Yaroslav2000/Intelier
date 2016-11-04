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

public class StepDefinitions_LandingPagesCampaigns {
	
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
    	
//Scenario: Single-property
    
//    @Given("No campaign '(.*)'  is in the campaigns list")
//    public void no_campaign_in_the_campaigns_list() {
//    }
    
	int numberOfOffers;
    
    @When("Back-end Administrator adds new single-property, single-offer '(.*)' with default settings")
    public void add_new_campaign_single_property_single_offer(String campaign) {
    	this.numberOfOffers = 1;
    	add_new_campaign_single_property(campaign, numberOfOffers);
    }
    
    @When("Back-end Administrator adds new single-property, multi-offer '(.*)' with default settings")
    public void add_new_campaign_single_property_multi_offer(String campaign) {
    	this.numberOfOffers = 5;
    	add_new_campaign_single_property(campaign, numberOfOffers);
    }
    
    public void add_new_campaign_single_property(String campaign, int numberOfOffers) {
    	BE.open_Create_Campaign();
    	BE.set_Brand("Shangri-La");
    	BE.set_Type("Single-Property");
    	BE.set_Layout("Template");
    	BE.goto_Next();
    	BE.set_Account_SelectRandom();
    	BE.set_InternalName(campaign);
    	BE.set_ActiveDates_default();
    	BE.set_Subdomain("promo");
    	BE.set_VanityURL_GenerateRandom(campaign);
    	BE.goto_Next();
    	BE.set_Property_SelectRandom(campaign);
    	BE.goto_Next();
    	BE.set_Languages_AddAll();
    	BE.submit_Campaign();
    	BE.set_English_TitleTag(campaign+" English Title Tag");
    	BE.set_English_MetaKeywords(campaign+" English Meta Keywords");
    	BE.set_English_MetaDescription(campaign+" English Meta Description");
    	BE.set_English_HeaderColor("Black");
    	BE.set_English_Layout_default();
    	BE.set_English_PageTitle(campaign+" English Page Title");
    	BE.set_English_PageCopyHeadline(campaign+" English Page Headline");
    	BE.set_English_PageCopyContent(campaign+" English Content");
    	BE.set_English_PageCopyTermsConditions(campaign+" English Terms and Conditions");
    	BE.publish_Campaign();
    	BE.goto_Settings();
    	BE.set_StatusActive();
    	BE.save_Campaign_changes();
    	add_Offers_to_Campaign(campaign, this.numberOfOffers);
    }
    
    public void add_Offers_to_Campaign(String campaign, int numberOfoffers) {
    	int offer = 0;
    	while (offer < numberOfoffers) {
	    	offer++;
    		BE.goto_CampaignOffers();
	    	BE.open_Create_Offer();
	    	BE.set_Offer_English_InternalName(BE.CampaignName_GeneratedRandom.get(campaign)+" offer"+Integer.toString(offer));
	    	BE.set_Offer_English_StayDates_default();
	    	BE.set_Offer_English_CampaignName(campaign+"Name");
	    	BE.set_Offer_English_Title("AutomationOffer"+Integer.toString(offer)+" Title");
	    	BE.set_Offer_English_Description("AutomationOffer"+Integer.toString(offer)+" English Description");
	    	BE.set_Offer_English_TermsConditions("AutomationOffer"+Integer.toString(offer)+" English Terms and Conditions");
	    	BE.save_Offer_changes();
    	}
    }

	@Then("Back-end Administrator should save campaign '(.*)'")
    public void should_save_campaign(String campaign) {
		BE.navigate_to_LandingPages_module();
		BE.search_campaign(BE.CampaignName_GeneratedRandom.get(campaign));
		BE.should_see_campaign_in_the_list(BE.CampaignName_GeneratedRandom.get(campaign));
    }
    
    @Then("Front-end User should see campaign '(.*)' settings")
    public void should_see_campaign_settings_FE(String campaign) {
    	FE.open_vanity_URL(BE.VanityURL_GeneratedRandom.get(campaign));
    	FE.should_see_PageLogo();
    	FE.should_see_PageContactUs();
    	FE.should_see_PageFindHotel();
    	FE.should_see_PageCurrency();
    	FE.should_see_PageLanguage();
    	FE.should_see_English_PageTitle("AutomationCampaign English Page Title".toUpperCase());
    	FE.should_see_English_PageCopyHeadline("AutomationCampaign English Page Headline");
    	FE.should_see_English_PageCopyContent("AutomationCampaign English Content");
    	FE.should_see_English_PageCopyTermsConditions("AutomationCampaign English Terms and Conditions");
    	FE.should_see_Property(BE.Property_SelectedRandom.get(campaign));
    	should_see_all_Offers(this.numberOfOffers);
    	FE.should_see_English_ShareThisPage();
    	FE.should_see_PageFooter();
    }
    
    private void should_see_all_Offers(int numberOfoffers) {
    	int offer = 0;
    	while (offer < numberOfoffers) {
	    	offer++;
    		FE.should_see_Offer_English_Title("AutomationOffer"+Integer.toString(offer)+" Title");
    		FE.should_see_Offer_English_Description("AutomationOffer"+Integer.toString(offer)+" English Description");
    		FE.should_see_Offer_English_TermsConditions("AutomationOffer"+Integer.toString(offer)+" English Terms and Conditions");
    	}
	}
    
}