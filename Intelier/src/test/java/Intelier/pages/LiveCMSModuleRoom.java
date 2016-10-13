package Intelier.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.components.HtmlTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room")
@NamedUrls(
		  {
		    @NamedUrl(name = "delete.room", url = "/room/delete/id/{1}"),
		    @NamedUrl(name = "edit.room", url = "/room/edit/id/{1}"),
		    @NamedUrl(name = "edit.settings", url = "/site/edit")	  
		  }
)
public class LiveCMSModuleRoom extends PageObject {
	
// -----------------------------------------------------------------------------------------------------------------
// LOCATORS
	
	@FindBy(linkText="Add a Room") public WebElementFacade AddRoom_LINK;
	@FindBy(className="list") public WebElementFacade RoomsList_TABLE;
	@FindBy(xpath="//tr[@data-id]") public WebElementFacade FirstRoom_ROW;
    //@FindBy(xpath="tr[data-id]") public Iterator<WebElementFacade> AllRooms_ITERATOR;
    //@FindBy(xpath="tr[data-id]") public List<WebElementFacade> AllRooms_LIST;
    @FindBy(xpath="//a[@class='delete']") public WebElementFacade Delete_BUTTON;
    @FindBy(css="input[name='Yes']") public WebElementFacade DeleteConfirmYes_BUTTON;
    @FindBy(css="input[value='Search']") public WebElementFacade Search_TEXTBOX;

    @FindBy(id="langData-en_title") public WebElementFacade Settings_EnglishTab_TitleTag_TEXTBOX;
    @FindBy(id="langData-en_metaKeywords") public WebElementFacade Settings_EnglishTab_MetaKeywords_TEXTBOX;
    @FindBy(id="langData-en_metaDescription") public WebElementFacade Settings_EnglishTab_MetaDescription_TEXTBOX;
    @FindBy(id="isActive-1") public WebElementFacade Settings_EnglishTab_Status_Active_RADIOBUTTON;
    @FindBy(id="isActive-0") public WebElementFacade Settings_EnglishTab_Status_InActive_RADIOBUTTON;
    @FindBy(id="viewType-matrix") public WebElementFacade Settings_EnglishTab_RoomsOverview_MatrixViewOnly_RADIOBUTTON;
    @FindBy(id="viewType-list") public WebElementFacade Settings_EnglishTab_RoomsOverview_ListViewOnly_RADIOBUTTON;
    @FindBy(id="viewType-toggle") public WebElementFacade Settings_EnglishTab_RoomsOverview_MatrixAndListViewToggle_RADIOBUTTON;
    @FindBy(id="toggleDefault") public WebElementFacade Settings_EnglishTab_Default_DROPDOWN;
    @FindBy(id="defaultUnitType") public WebElementFacade Settings_EnglishTab_DefaultUnitType_DROPDOWN;
    @FindBy(id="filters-from_rate") public WebElementFacade Settings_EnglishTab_Filters_FromRate_CHECKBOX;
    @FindBy(id="filters-room_types") public WebElementFacade Settings_EnglishTab_Filters_RoomType_CHECKBOX;
    @FindBy(id="filters-sleeps") public WebElementFacade Settings_EnglishTab_Filters_Sleeps_CHECKBOX;
    @FindBy(id="filters-amenities") public WebElementFacade Settings_EnglishTab_Filters_Amenities_CHECKBOX;
    
	@FindBy(id="isActive-1") public WebElementFacade GeneralTab_Status_Active_RADIOBUTTON;	
	@FindBy(id="isActive-0") public WebElementFacade GeneralTab_Status_Inactive_RADIOBUTTON;    
    @FindBy(name="internalName") public WebElementFacade GeneralTab_InternalName_TEXTBOX;	
	@FindBy(name="category") public WebElementFacade GeneralTab_RoomCategory_DROPDOWN;    
	@FindBy(name="fromRate") public WebElementFacade GeneralTab_FromRate_TEXTBOX;
	@FindBy(id="size_from") public WebElementFacade GeneralTab_SizeFrom_TEXTBOX;	
	@FindBy(id="size_to") public WebElementFacade GeneralTab_SizeTo_TEXTBOX;	
    @FindBy(css="select[name='unit']") public WebElementFacade GeneralTab_Unit_DROPDOWN;	
	@FindBy(name="numOfGuest[0][adults]") public WebElementFacade GeneralTab_AdultGuests_DROPDOWN;	
	@FindBy(name="numOfGuest[0][children]") public WebElementFacade GeneralTab_ChildrenGuests_DROPDOWN;			
	@FindBy(className="add-all") public WebElementFacade GeneralTab_AddAllAmenities_BUTTON;
    
    @FindBy(xpath="//div[@class='content-tab-button lang']") public WebElementFacade LanguageSpecific_EnglishTab;
    @FindBy(id="langData-en_title") public WebElementFacade LanguageSpecific_EnglishTab_TitleTag_TEXTBOX;
    @FindBy(id="langData-en_metaKeywords") public WebElementFacade LanguageSpecific_EnglishTab_MetaKeywords_TEXTBOX;
    @FindBy(id="langData-en_metaDescription") public WebElementFacade LanguageSpecific_EnglishTab_MetaDescription_TEXTBOX;
    @FindBy(id="langData-en_name") public WebElementFacade LanguageSpecific_EnglishTab_Name_TEXTBOX;
    @FindBy(id="langData-en_vanityUrl") public WebElementFacade LanguageSpecific_EnglishTab_VanityURL_TEXTBOX;
    @FindBy(id="langData-en_headline") public WebElementFacade LanguageSpecific_EnglishTab_Headline_TEXTBOX;
    @FindBy(id="langData-en_description_ifr") public WebElementFacade LanguageSpecific_EnglishTab_Description_FRAME;   
    @FindBy(name="langData[en_bedTypes][0][value]") public WebElementFacade LanguageSpecific_EnglishTab_BedTypes_TEXTBOX;
    @FindBy(xpath="//*[@id='langData-en_features-element']/span/span[1]/span/ul/li/input") public WebElementFacade LanguageSpecific_EnglishTab_Features_DROPDOWNTEXTBOX;
    @FindBy(id="langData-en_notes_ifr") public WebElementFacade LanguageSpecific_EnglishTab_Notes_FRAME;

    @FindBy(id="save_button-save") public WebElementFacade Save_BUTTON;
    @FindBy(id="save_button-close") public WebElementFacade Close_BUTTON;
    
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

}