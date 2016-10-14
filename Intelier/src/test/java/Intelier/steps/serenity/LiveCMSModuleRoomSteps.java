package Intelier.steps.serenity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.LiveCMSModuleRoomPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.components.HtmlTable;
import net.thucydides.core.steps.ScenarioSteps;

public class LiveCMSModuleRoomSteps extends ScenarioSteps {

	LiveCMSModuleRoomPage ModuleRoom;

// -----------------------------------------------------------------------------------------------------------------
// COMMON
	
	@Step
    public void Navigate_to_room_module() {
		ModuleRoom.open();
    }
	
	@Step
	public void Add_a_room() {
		ModuleRoom.AddRoom_LINK.click();
	}
	
	@Step
	public void Save_changes() {
		ModuleRoom.Save_BUTTON.click();
	}
	
	@Step
	public void Edit_room(String string) {
		ModuleRoom.Edit_room(string);
	}
    
    @Step
    public void Delete_room(String string) {
    	ModuleRoom.Delete_room(string);
	}
    
    @Step
    public void Delete_room_confirm() {
    	ModuleRoom.DeleteConfirmYes_BUTTON.click();
	}

    @Step
    public void Delete_all_rooms() {
    	ModuleRoom.Delete_all_rooms();
	}
    
    @Step
	public void Cancel_changes() {
    	ModuleRoom.Close_BUTTON.click();
	}
    
    @Step
	public void Make_sure_room_exists(String string) {
        if (verify_room_exists(string) != true) {
        	ModuleRoom.AddRoom_LINK.click();
        	ModuleRoom.GeneralTab_InternalName_TEXTBOX.type(string);
        	ModuleRoom.Save_BUTTON.click();
        }
	}
    
    @Step
	public void Search_room(String room) {
		ModuleRoom.Search_TEXTBOX.type(room);
	}
	
    @Step
	public void Sorting_rooms(String room2, String room1) {
		ModuleRoom.Drag_and_drop(room2, room1);
	}
    
    @Step
	public void Edit_rooms_settings() {
    	ModuleRoom.Edit_rooms_settings();
	}

// -----------------------------------------------------------------------------------------------------------------
// SETTINGS
    
    @Step
	public void Settings_EnglishTab_TitleTag(String string) {
    	ModuleRoom.Settings_EnglishTab_TitleTag_TEXTBOX.type(string);
		
	}

    @Step
	public void Settings_EnglishTab_MetaKeywords(String string) {
    	ModuleRoom.Settings_EnglishTab_MetaKeywords_TEXTBOX.type(string);
		
	}

    @Step
	public void Settings_EnglishTab_MetaDescription(String string) {
    	ModuleRoom.Settings_EnglishTab_MetaDescription_TEXTBOX.type(string);
	}

    @Step
	public void Settings_EnglishTab_Status(String string) {
		if (string == "Active") {
			ModuleRoom.Settings_EnglishTab_Status_Active_RADIOBUTTON.click();
		} else if (string == "Inactive") {
			ModuleRoom.Settings_EnglishTab_Status_InActive_RADIOBUTTON.click();
		}
	}

    @Step
	public void Settings_EnglishTab_RoomsOverview(String string) {
		if (string == "Matrix view only") {
			ModuleRoom.Settings_EnglishTab_RoomsOverview_MatrixViewOnly_RADIOBUTTON.click();
		} else if (string == "List view only") {
			ModuleRoom.Settings_EnglishTab_RoomsOverview_ListViewOnly_RADIOBUTTON.click();
		} else if (string == "Matrix and list view toggle") {
			ModuleRoom.Settings_EnglishTab_RoomsOverview_MatrixAndListViewToggle_RADIOBUTTON.click();
		}
	}

    @Step
	public void Settings_EnglishTab_Default(String string) {
    	if (string == "Matrix view") {
			ModuleRoom.Settings_EnglishTab_Default_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		} else if (string == "List view") {
			ModuleRoom.Settings_EnglishTab_Default_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		}
	}

    @Step
	public void Settings_EnglishTab_DefaultUnitType(String string) {
		if (string == "m²") {
			ModuleRoom.Settings_EnglishTab_DefaultUnitType_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		} else if (string == "ft²") {
			ModuleRoom.Settings_EnglishTab_DefaultUnitType_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		}
	}

    @Step
	public void Settings_EnglishTab_AddAllFilters() {
    	if (!ModuleRoom.Settings_EnglishTab_Filters_FromRate_CHECKBOX.isSelected()) {
    		ModuleRoom.Settings_EnglishTab_Filters_FromRate_CHECKBOX.click();
    	}
    	if (!ModuleRoom.Settings_EnglishTab_Filters_RoomType_CHECKBOX.isSelected()) {
    	ModuleRoom.Settings_EnglishTab_Filters_RoomType_CHECKBOX.click();
    	}
    	if (!ModuleRoom.Settings_EnglishTab_Filters_Sleeps_CHECKBOX.isSelected()) {
    	ModuleRoom.Settings_EnglishTab_Filters_Sleeps_CHECKBOX.click();
    	}
    	if (!ModuleRoom.Settings_EnglishTab_Filters_Amenities_CHECKBOX.isSelected()) {
    	ModuleRoom.Settings_EnglishTab_Filters_Amenities_CHECKBOX.click();
    	}
	}

    
    
// -----------------------------------------------------------------------------------------------------------------
// GENERAL TAB
    
    @Step
	public void GeneralTab_Status(String string) {
		if (string == "Active") {
			ModuleRoom.GeneralTab_Status_Active_RADIOBUTTON.click();
		} else if (string == "Inactive") {
			ModuleRoom.GeneralTab_Status_Inactive_RADIOBUTTON.click();
		}
	}
	
    @Step
	public void GeneralTab_InternalName(String string) {
		ModuleRoom.GeneralTab_InternalName_TEXTBOX.type(string);
	}
    
    @Step
	public void GeneralTab_RoomCategory(String string) {
		if (string == "Guest Rooms") {
			ModuleRoom.GeneralTab_RoomCategory_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		} else if (string == "Suites") {
			ModuleRoom.GeneralTab_RoomCategory_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		}
	}
	
    @Step
	public void GeneralTab_FromRate(String string) {
    	ModuleRoom.GeneralTab_FromRate_TEXTBOX.type(string);
	}
	
    @Step
	public void GeneralTab_SizeFrom(String string) {
    	ModuleRoom.GeneralTab_SizeFrom_TEXTBOX.type(string);
	}
	
    @Step
	public void GeneralTab_SizeTo(String string) {
    	ModuleRoom.GeneralTab_SizeTo_TEXTBOX.type(string);
	}
	
    @Step
	public void GeneralTab_Unit(String string) {
		if (string == "m²") {
			ModuleRoom.GeneralTab_Unit_DROPDOWN.selectByValue("m");
		} else if (string == "ft²") {
			ModuleRoom.GeneralTab_Unit_DROPDOWN.selectByValue("f");
		}
	}
	
    @Step
	public void GeneralTab_AdultGuests(Integer number) {
    	ModuleRoom.GeneralTab_AdultGuests_DROPDOWN.selectByIndex(number);
	}
	
    @Step
	public void GeneralTab_ChildrenGuests(Integer number) {
    	ModuleRoom.GeneralTab_ChildrenGuests_DROPDOWN.selectByIndex(number);
	}
	
    @Step
	public void GeneralTab_AddAllAmenities() {
    	ModuleRoom.GeneralTab_AddAllAmenities_BUTTON.click();
	}
    
// -----------------------------------------------------------------------------------------------------------------
// LANGUAGE-SPECIFIC TAB
    
    @Step
	public void Open_LanguageSpecific_EnglishTab() {
		ModuleRoom.LanguageSpecific_EnglishTab.click();
	}
    
    @Step
	public void LanguageSpecific_EnglishTab_TitleTag(String string) {
		ModuleRoom.LanguageSpecific_EnglishTab_TitleTag_TEXTBOX.type(string);
	}
    
    @Step
	public void LanguageSpecific_EnglishTab_MetaKeywords(String string) {
		ModuleRoom.LanguageSpecific_EnglishTab_MetaKeywords_TEXTBOX.type(string);
	}

    @Step
	public void LanguageSpecific_EnglishTab_MetaDescription(String string) {
		ModuleRoom.LanguageSpecific_EnglishTab_MetaDescription_TEXTBOX.type(string);
	}
    
    @Step
	public void LanguageSpecific_EnglishTab_Name(String string) {
		ModuleRoom.LanguageSpecific_EnglishTab_Name_TEXTBOX.type(string);
	}
    
    @Step
	public void LanguageSpecific_EnglishTab_VanityURL(String string) {
		ModuleRoom.LanguageSpecific_EnglishTab_VanityURL_TEXTBOX.type(string);
	}
    
    @Step
	public void LanguageSpecific_EnglishTab_Headline(String string) {
		ModuleRoom.LanguageSpecific_EnglishTab_Headline_TEXTBOX.type(string);
	}
    
    @Step
	public void LanguageSpecific_EnglishTab_Description(String string) {
    	ModuleRoom.LanguageSpecific_EnglishTab_Description_FRAME.click();
		ModuleRoom.LanguageSpecific_EnglishTab_Description_FRAME.sendKeys(string);
	}
    
    @Step
	public void LanguageSpecific_EnglishTab_BedTypes(String string) {
		ModuleRoom.LanguageSpecific_EnglishTab_BedTypes_TEXTBOX.type(string);
	}
    
    @Step
	public void LanguageSpecific_EnglishTab_Features(String string) {
    	ModuleRoom.LanguageSpecific_EnglishTab_Features_DROPDOWNTEXTBOX.click();
    	ModuleRoom.LanguageSpecific_EnglishTab_Features_DROPDOWNTEXTBOX.typeAndEnter(string);
	}
    
    @Step
	public void LanguageSpecific_EnglishTab_Notes(String string) {
    	ModuleRoom.LanguageSpecific_EnglishTab_Notes_FRAME.click();
    	ModuleRoom.LanguageSpecific_EnglishTab_Notes_FRAME.sendKeys(string);
	}
    
 // -----------------------------------------------------------------------------------------------------------------
 // VERIFICATIONS    
    
    @Step
	public void should_see_room_in_the_list_BE(String string) {
    	try {
    		assertTrue(HtmlTable.rowsFrom(ModuleRoom.RoomsList_TABLE).toString().contains(string));
    	} catch (NoSuchElementException ex) {}
	}
    
    @Step
	public void should_not_see_room_in_the_list(String string) {
    	try {
	    	assertFalse(HtmlTable.rowsFrom(ModuleRoom.RoomsList_TABLE).toString().contains(string));
	    } catch (NoSuchElementException ex) {}
	}
    
    @Step
	public void should_see_no_rooms_in_the_list() {
    	try {	
	    	assertTrue(HtmlTable.rowsFrom(ModuleRoom.RoomsList_TABLE).toString().isEmpty());
	    } catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_save_room_new_settings(String string) {
    	try {
    		assertTrue(HtmlTable.rowsFrom(ModuleRoom.RoomsList_TABLE).toString().contains(string));
    	} catch (NoSuchElementException ex) {}
	}
    
	public boolean verify_room_exists(String string) {
    	try {
    		if (HtmlTable.rowsFrom(ModuleRoom.RoomsList_TABLE).toString().contains(string)) {;
    			return true;
    		}
    	} catch (NoSuchElementException ex) {}
    	return false;
	}

	@Step
	public void should_see_room_in_the_list_first(String string) {
    	try {
    		assertTrue(ModuleRoom.FirstRoom_ROW.getAttribute("data-name").toString().contains(string));
    	} catch (NoSuchElementException ex) {}
	}


}