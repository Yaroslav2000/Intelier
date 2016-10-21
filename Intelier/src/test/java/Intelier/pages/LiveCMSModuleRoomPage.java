package Intelier.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.components.HtmlTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

import java.util.Iterator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

//@DefaultUrl("http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room")
//@DefaultUrl("http://l5.local-qa.dev.webcanada.com/set-hotels/ihw/4/ihw-set-room")
@DefaultUrl("http://l5.local-qa.dev.webcanada.com/starwood/lps2/198/lps2-rooms")
@NamedUrls(
		  {
		    @NamedUrl(name = "delete.room", url = "/room/delete/id/{1}"),
		    @NamedUrl(name = "edit.room", url = "/room/edit/id/{1}"),
		    @NamedUrl(name = "edit.settings", url = "/site/edit"),
		  }
)
public class LiveCMSModuleRoomPage extends PageObject {
	
// -----------------------------------------------------------------------------------------------------------------
// LOCATORS
	
	@FindBy(linkText="Add a Room") public WebElementFacade AddRoom_LINK;
	@FindBy(className="list") public WebElementFacade RoomsList_TABLE;
	@FindBy(css="[data-id]") public WebElementFacade FirstRoom_ROW;
    @FindBy(xpath="//a[@class='delete']") public WebElementFacade Delete_BUTTON;
    @FindBy(css="input[name='Yes']") public WebElementFacade DeleteConfirmYes_BUTTON;
    @FindBy(css="input[value='Search']") public WebElementFacade Search_TEXTBOX;

    @FindBy(id="langData-en_title") public WebElementFacade Settings_English_TitleTag_TEXTBOX;
    @FindBy(id="langData-en_metaKeywords") public WebElementFacade Settings_English_MetaKeywords_TEXTBOX;
    @FindBy(id="langData-en_metaDescription") public WebElementFacade Settings_English_MetaDescription_TEXTBOX;
    @FindBy(id="isActive-1") public WebElementFacade Settings_English_Status_Active_RADIOBUTTON;
    @FindBy(id="isActive-0") public WebElementFacade Settings_English_Status_InActive_RADIOBUTTON;
    @FindBy(id="viewType-matrix") public WebElementFacade Settings_English_RoomsOverview_MatrixViewOnly_RADIOBUTTON;
    @FindBy(id="viewType-list") public WebElementFacade Settings_English_RoomsOverview_ListViewOnly_RADIOBUTTON;
    @FindBy(id="viewType-toggle") public WebElementFacade Settings_English_RoomsOverview_MatrixAndListViewToggle_RADIOBUTTON;
    @FindBy(id="toggleDefault") public WebElementFacade Settings_English_Default_DROPDOWN;
    @FindBy(id="defaultUnitType") public WebElementFacade Settings_English_DefaultUnitType_DROPDOWN;
    @FindBy(id="filters-from_rate") public WebElementFacade Settings_English_Filters_FromRate_CHECKBOX;
    @FindBy(id="filters-room_types") public WebElementFacade Settings_English_Filters_RoomType_CHECKBOX;
    @FindBy(id="filters-sleeps") public WebElementFacade Settings_English_Filters_Sleeps_CHECKBOX;
    @FindBy(id="filters-amenities") public WebElementFacade Settings_English_Filters_Amenities_CHECKBOX;
    
	@FindBy(id="isActive-1") public WebElementFacade General_Status_Active_RADIOBUTTON;	
	@FindBy(id="isActive-0") public WebElementFacade General_Status_Inactive_RADIOBUTTON;    
    @FindBy(name="internalName") public WebElementFacade General_InternalName_TEXTBOX;	
	@FindBy(name="category") public WebElementFacade General_RoomCategory_DROPDOWN;    
	@FindBy(name="fromRate") public WebElementFacade General_FromRate_TEXTBOX;
	@FindBy(id="size_from") public WebElementFacade General_SizeFrom_TEXTBOX;	
	@FindBy(id="size_to") public WebElementFacade General_SizeTo_TEXTBOX;	
    @FindBy(css="select[name='unit']") public WebElementFacade General_Unit_DROPDOWN;	
	@FindBy(name="numOfGuest[0][adults]") public WebElementFacade General_AdultGuests_DROPDOWN;	
	@FindBy(name="numOfGuest[0][children]") public WebElementFacade General_ChildrenGuests_DROPDOWN;			
	@FindBy(className="add-all") public WebElementFacade General_AddAllAmenities_BUTTON;
    
    @FindBy(xpath="//div[@class='content-tab-button lang']") public WebElementFacade LanguageSpecific_English;
    @FindBy(id="langData-en_title") public WebElementFacade LanguageSpecific_English_TitleTag_TEXTBOX;
    @FindBy(id="langData-en_metaKeywords") public WebElementFacade LanguageSpecific_English_MetaKeywords_TEXTBOX;
    @FindBy(id="langData-en_metaDescription") public WebElementFacade LanguageSpecific_English_MetaDescription_TEXTBOX;
    @FindBy(id="langData-en_name") public WebElementFacade LanguageSpecific_English_Name_TEXTBOX;
    @FindBy(id="langData-en_vanityUrl") public WebElementFacade LanguageSpecific_English_VanityURL_TEXTBOX;
    @FindBy(id="langData-en_headline") public WebElementFacade LanguageSpecific_English_Headline_TEXTBOX;
    @FindBy(id="langData-en_description_ifr") public WebElementFacade LanguageSpecific_English_Description_FRAME;   
    @FindBy(name="langData[en_bedTypes][0][value]") public WebElementFacade LanguageSpecific_English_BedTypes_TEXTBOX;
    @FindBy(xpath="//*[@id='langData-en_features-element']/span/span[1]/span/ul/li/input") public WebElementFacade LanguageSpecific_English_Features_DROPDOWNTEXTBOX;
    @FindBy(id="langData-en_notes_ifr") public WebElementFacade LanguageSpecific_English_Notes_FRAME;

    @FindBy(xpath="//input[@value='Save']") public WebElementFacade Save_BUTTON;
    @FindBy(xpath="//div[@class='standard_form_button']") public WebElementFacade Close_BUTTON;
    
// -----------------------------------------------------------------------------------------------------------------
// ACTIONS
       
	public void Delete_room(String string) {   
		HtmlTable table = HtmlTable.inTable(RoomsList_TABLE);
        Iterator<WebElement> RowElements = table.getRowElements().iterator();
        while(RowElements.hasNext()) {
        	WebElement row = RowElements.next();
		    	if (row.getAttribute("data-name").contains(string)) {
		    		open("delete.room", withParameters(row.getAttribute("data-id")));
		    		break;
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
		    		break;
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
	
	public void Drag_and_drop(String room2, String room1) {
		WebElementFacade Test2Room_ROW = $("//tr[@data-name='"+room2+"']");
		WebElementFacade Test1Room_ROW = $("//tr[@data-name='"+room1+"']");
		withAction().clickAndHold(Test2Room_ROW).perform();
		withAction().moveToElement(Test1Room_ROW).perform();
		withAction().release().perform();
	}
	
	public void Edit_rooms_settings() {
		open("edit.settings", withParameters());
	}

	public String GetValueByLabel(String string) {
		return $("//option[@label = '"+string+"']").getAttribute("value");
	}
	
}