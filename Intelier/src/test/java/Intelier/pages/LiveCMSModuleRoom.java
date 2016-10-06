package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.components.HtmlTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;

import java.util.Iterator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room/room")
@NamedUrls(
		  {
		    @NamedUrl(name = "delete.room", url = "http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room/room/delete/id/{1}"),
		    @NamedUrl(name = "edit.room", url = "http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room/room/edit/id/{1}")
		  }
)
public class LiveCMSModuleRoom extends PageObject {
	
// -----------------------------------------------------------------------------------------------------------------
// LOCATORS
	
	@FindBy(linkText="Add a Room") public WebElementFacade AddRoom_LINK;
	@FindBy(className="list") public WebElementFacade RoomsList_TABLE;
    @FindBy(css="[data-id]") public WebElementFacade FirstRoom_ROW;
    @FindBy(xpath="//a[@class='delete']") public WebElementFacade Delete_BUTTON;
    @FindBy(css="input[name='Yes']") public WebElementFacade DeleteConfirmYes_BUTTON;
    
	@FindBy(id="isActive-1") public WebElementFacade GeneralTab_Active_RADIOBUTTON;	
	@FindBy(id="isActive-0") public WebElementFacade GeneralTab_Inactive_RADIOBUTTON;    
    @FindBy(name="internalName") public WebElementFacade GeneralTab_InternalName_TEXTBOX;	
	@FindBy(name="category") public WebElementFacade GeneralTab_RoomCategory_DROPDOWN;    
	@FindBy(name="fromRate") public WebElementFacade GeneralTab_FromRate_TEXTBOX;
	@FindBy(id="size_from") public WebElementFacade GeneralTab_SizeFrom_TEXTBOX;	
	@FindBy(id="size_to") public WebElementFacade GeneralTab_SizeTo_TEXTBOX;	
    @FindBy(css="select[name='unit']") public WebElementFacade GeneralTab_Unit_DROPDOWN;	
	@FindBy(name="numOfGuest[0][adults]") public WebElementFacade GeneralTab_AdultGuests_DROPDOWN;	
	@FindBy(name="numOfGuest[0][children]") public WebElementFacade GeneralTab_ChildrenGuests_DROPDOWN;			
	@FindBy(className="add-all") public WebElementFacade GeneralTab_AddAllAmenities_BUTTON;
	
    @FindBy(id="save_button-save") public WebElementFacade Save_BUTTON;
    @FindBy(id="save_button-close") public WebElementFacade Close_BUTTON;
    
    @FindBy(className="content-tab-button lang") public WebElementFacade LanguageSpecific_EnglishTab;
    @FindBy(id="langData-en_title") public WebElementFacade LanguageSpecific_EnglishTab_TitleTag_TEXTBOX;
    @FindBy(id="langData-en_metaKeywords") public WebElementFacade LanguageSpecific_EnglishTab_MetaKeywords_TEXTBOX;
    @FindBy(id="langData-en_metaDescription") public WebElementFacade LanguageSpecific_EnglishTab_MetaDescription_TEXTBOX;
    @FindBy(id="langData-en_name") public WebElementFacade LanguageSpecific_EnglishTab_Name_TEXTBOX;
    @FindBy(id="langData-en_vanityUrl") public WebElementFacade LanguageSpecific_EnglishTab_VanityURL_TEXTBOX;
    @FindBy(id="langData-en_headline") public WebElementFacade LanguageSpecific_EnglishTab_Headline_TEXTBOX;
    @FindBy(id="langData-en_description_ifr") public WebElementFacade LanguageSpecific_EnglishTab_Description_FRAME;
    @FindBy(name="langData[en_bedTypes][0][value]") public WebElementFacade LanguageSpecific_EnglishTab_BedTypes_TEXTBOX;
    @FindBy(id="langData-en_features") public WebElementFacade LanguageSpecific_EnglishTab_Features_DROPDOWNTEXTBOX;
    @FindBy(id="langData-en_notes_ifr") public WebElementFacade LanguageSpecific_EnglishTab_Notes_FRAME;
	
	
// -----------------------------------------------------------------------------------------------------------------
// ACTIONS
    
	public void Delete_room(String string) {   
		HtmlTable table = HtmlTable.inTable(RoomsList_TABLE);
        Iterator<WebElement> RowElements = table.getRowElements().iterator();
        while(RowElements.hasNext()) {
        	WebElement row = RowElements.next();
		    	if (row.getAttribute("data-name").contains(string)) {
		    		open("delete.room", withParameters(row.getAttribute("data-id")));
		    	}
        } 
	}
	
	public void Edit_room(String string) {
		HtmlTable table = HtmlTable.inTable(RoomsList_TABLE);
        Iterator<WebElement> RowElements = table.getRowElements().iterator();
        while(RowElements.hasNext()) {
        	WebElement row = RowElements.next();
		    	if (row.getAttribute("data-name").contains(string)) {
		    		open("edit.room", withParameters(row.getAttribute("data-id")));
		    	}
        }
	}
	
	public void Delete_all_rooms() {   
	    try {
	    	HtmlTable table = HtmlTable.inTable(RoomsList_TABLE);
	        Iterator<WebElement> RowElements = table.getRowElements().iterator();
	        while(RowElements.hasNext()) {
	        	FirstRoom_ROW.click();
	        	Delete_BUTTON.click();
	        	DeleteConfirmYes_BUTTON.click();       	
	        }
	    } catch (NoSuchElementException ex) {}
	}
	
}