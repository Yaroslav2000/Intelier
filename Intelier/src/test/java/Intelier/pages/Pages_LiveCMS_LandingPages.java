package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/shangri-la")
@NamedUrls(
		  {
		    @NamedUrl(name = "navigate.to.LandingPages", url = "/shangri-la-lpb")
		  }
)
public class Pages_LiveCMS_LandingPages extends PageObject {

// -----------------------------------------------------------------------------------------------------------------
// LOCATORS
		
	@FindBy(xpath="//div[@class='cnt-body']") public WebElementFacade AllModules_BLOCK;
	@FindBy(xpath="//a[@class='icon plus create-campaign-button']") public WebElementFacade CreateCampaign_BUTTON;
	@FindBy(className="list") public WebElementFacade CampaignsList_TABLE;
	@FindBy(xpath="//input[@value='Search']") public WebElementFacade Search_TEXTBOX;
	
	@FindBy(xpath="//iframe") public WebElementFacade IFRAME;
	@FindBy(xpath="//*[@data-value='GC']") public WebElementFacade Brand_GC_BUTTON;
	@FindBy(xpath="//*[@data-value='HJ']") public WebElementFacade Brand_HJ_BUTTON;
	@FindBy(xpath="//*[@data-value='KH']") public WebElementFacade Brand_KH_BUTTON;
	@FindBy(xpath="//*[@data-value='SL']") public WebElementFacade Brand_SL_BUTTON;
	@FindBy(xpath="//*[@data-value='multi']") public WebElementFacade Type_MultiProperty_BUTTON;
	@FindBy(xpath="//*[@data-value='no']") public WebElementFacade Type_NoProperty_BUTTON;
	@FindBy(xpath="//*[@data-value='single']") public WebElementFacade Type_SingleProperty_BUTTON;
	@FindBy(xpath="//*[@data-value='1']") public WebElementFacade Layout_Template_BUTTON;
	@FindBy(xpath="//input[@value='Next']") public WebElementFacade Next_BUTTON;
    @FindBy(id="subscription") public WebElementFacade Account_DROPDOWN;
    @FindBy(id="internal_name") public WebElementFacade InternalName_TEXTBOX;	
    @FindBy(id="start_date") public WebElementFacade ActiveDates_StartDate_TEXTBOX;	
    @FindBy(id="no_expiry") public WebElementFacade NoExpiry_CHECKBOX;	
    @FindBy(id="subdomain") public WebElementFacade Subdomain_DROPDOWN;	
    @FindBy(id="vanity_url") public WebElementFacade VanityURL_TEXTBOX;
    @FindBy(xpath="//input[@class='text autocomplete-input']") public WebElementFacade FindProperty_TEXTBOX;
    @FindBy(className="add-all") public WebElementFacade AddAllLanguages_BUTTON;
    @FindBy(xpath="//input[@value='Create Campaign']") public WebElementFacade CreateCampaign_Submit_BUTTON;
    
    @FindBy(id="title") public WebElementFacade TitleTag_TEXTBOX;
    @FindBy(id="keywords") public WebElementFacade MetaKeywords_TEXTBOX;
    @FindBy(id="description") public WebElementFacade MetaDescription_TEXTBOX;
    @FindBy(xpath="//input[@name='page_headline[headline]']") public WebElementFacade PageTitle_TEXTBOX;
    @FindBy(xpath="//input[@name='headline2[headline]']") public WebElementFacade PageCopyHeadline_TEXTBOX;
    @FindBy(id="action_buttons-save") public WebElementFacade Publish_BUTTON;
    
    @FindBy(xpath="//a[@class='icon settings-icon']") public WebElementFacade Settings_BUTTON;
    @FindBy(id="status-active") public WebElementFacade StatusActive_CHECKBOX;
    @FindBy(id="save_button-save") public WebElementFacade Save_BUTTON;
    
	
// -----------------------------------------------------------------------------------------------------------------
// ACTIONS	
	
	public void navigate_to_Client() {
		open();
	}
    
    public void navigate_to_LandingPages_module() {
		open("navigate.to.LandingPages", withParameters());
	}

	public void select_Property(String string) {
		WebElementFacade Property_ITEM = $("//div[@data-id='"+string+"']");
		Property_ITEM.click();
	}

	
}
