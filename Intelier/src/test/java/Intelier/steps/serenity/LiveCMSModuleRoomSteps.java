package Intelier.steps.serenity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
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
        	ModuleRoom.General_InternalName_TEXTBOX.type(string);
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
	public void Set_Settings_English_TitleTag(String string) {
    	ModuleRoom.Settings_English_TitleTag_TEXTBOX.type(string);
		
	}

    @Step
	public void Set_Settings_English_MetaKeywords(String string) {
    	ModuleRoom.Settings_English_MetaKeywords_TEXTBOX.type(string);
		
	}

    @Step
	public void Set_Settings_English_MetaDescription(String string) {
    	ModuleRoom.Settings_English_MetaDescription_TEXTBOX.type(string);
	}

    @Step
	public void Set_Settings_English_Status(String string) {
		if (string.equals("Active")) {
			ModuleRoom.Settings_English_Status_Active_RADIOBUTTON.click();
		} else if (string.equals("Inactive")) {
			ModuleRoom.Settings_English_Status_InActive_RADIOBUTTON.click();
		}
	}

    @Step
	public void Set_Settings_English_RoomsOverview(String string) {
		if (string.equals("Matrix view only")) {
			ModuleRoom.Settings_English_RoomsOverview_MatrixViewOnly_RADIOBUTTON.click();
		} else if (string.equals("List view only")) {
			ModuleRoom.Settings_English_RoomsOverview_ListViewOnly_RADIOBUTTON.click();
		} else if (string.equals("Matrix and list view toggle")) {
			ModuleRoom.Settings_English_RoomsOverview_MatrixAndListViewToggle_RADIOBUTTON.click();
		}
	}

    @Step
	public void Set_Settings_English_Default(String string) {
    	if (string.equals("Matrix view")) {
			ModuleRoom.Settings_English_Default_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		} else if (string.equals("List view")) {
			ModuleRoom.Settings_English_Default_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		}
	}

    @Step
	public void Set_Settings_English_DefaultUnitType(String string) {
		if (string.equals("m²")) {
			ModuleRoom.Settings_English_DefaultUnitType_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		} else if (string.equals("ft²")) {
			ModuleRoom.Settings_English_DefaultUnitType_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		}
	}

    @Step
	public void Set_Settings_English_AddAllFilters() {
    	if (!ModuleRoom.Settings_English_Filters_FromRate_CHECKBOX.isSelected()) {
    		ModuleRoom.Settings_English_Filters_FromRate_CHECKBOX.click();
    	}
    	if (!ModuleRoom.Settings_English_Filters_RoomType_CHECKBOX.isSelected()) {
    	ModuleRoom.Settings_English_Filters_RoomType_CHECKBOX.click();
    	}
    	if (!ModuleRoom.Settings_English_Filters_Sleeps_CHECKBOX.isSelected()) {
    	ModuleRoom.Settings_English_Filters_Sleeps_CHECKBOX.click();
    	}
    	if (!ModuleRoom.Settings_English_Filters_Amenities_CHECKBOX.isSelected()) {
    	ModuleRoom.Settings_English_Filters_Amenities_CHECKBOX.click();
    	}
	}

    
    
// -----------------------------------------------------------------------------------------------------------------
// GENERAL TAB
    
    @Step
	public void Set_General_Status(String string) {
    	if (string.equals("Active")) {
    		ModuleRoom.General_Status_Active_RADIOBUTTON.click();
		} else if (string.equals("Inactive")) {
			ModuleRoom.General_Status_Inactive_RADIOBUTTON.click();
		}
	}
	
    @Step
	public void Set_General_InternalName(String string) {
		ModuleRoom.General_InternalName_TEXTBOX.type(string);
	}
    
    @Step
	public void Set_General_RoomCategory(String string) {
		if (string.equals("Guest Rooms")) {
			ModuleRoom.General_RoomCategory_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		} else if (string.equals("Suites")) {
			ModuleRoom.General_RoomCategory_DROPDOWN.selectByValue(ModuleRoom.GetValueByLabel(string));
		}
	}
	
    @Step
	public void Set_General_FromRate(String string) {
    	ModuleRoom.General_FromRate_TEXTBOX.type(string);
	}
	
    @Step
	public void Set_General_SizeFrom(String string) {
    	ModuleRoom.General_SizeFrom_TEXTBOX.type(string);
	}
	
    @Step
	public void Set_General_SizeTo(String string) {
    	ModuleRoom.General_SizeTo_TEXTBOX.type(string);
	}
	
    @Step
	public void Set_General_Unit(String string) {
		if (string.equals("m²")) {
			ModuleRoom.General_Unit_DROPDOWN.selectByValue("m");
		} else if (string.equals("ft²")) {
			ModuleRoom.General_Unit_DROPDOWN.selectByValue("f");
		}
	}
	
    @Step
	public void Set_General_AdultGuests(Integer number) {
    	ModuleRoom.General_AdultGuests_DROPDOWN.selectByIndex(number);
	}
	
    @Step
	public void Set_General_ChildrenGuests(Integer number) {
    	ModuleRoom.General_ChildrenGuests_DROPDOWN.selectByIndex(number);
	}
	
    @Step
	public void Set_General_AddAllAmenities() {
    	ModuleRoom.General_AddAllAmenities_BUTTON.click();
	}
    
// -----------------------------------------------------------------------------------------------------------------
// LANGUAGE-SPECIFIC TAB
    
    @Step
	public void Open_LanguageSpecific_English() {
		ModuleRoom.LanguageSpecific_English.click();
	}
    
    @Step
	public void Set_LanguageSpecific_English_TitleTag(String string) {
		ModuleRoom.LanguageSpecific_English_TitleTag_TEXTBOX.type(string);
	}
    
    @Step
	public void Set_LanguageSpecific_English_MetaKeywords(String string) {
		ModuleRoom.LanguageSpecific_English_MetaKeywords_TEXTBOX.type(string);
	}

    @Step
	public void Set_LanguageSpecific_English_MetaDescription(String string) {
		ModuleRoom.LanguageSpecific_English_MetaDescription_TEXTBOX.type(string);
	}
    
    @Step
	public void Set_LanguageSpecific_English_Name(String string) {
		ModuleRoom.LanguageSpecific_English_Name_TEXTBOX.type(string);
	}
    
    public Map<String, String> Generated_RandomVanityURL = new HashMap<String, String>();
    
    @Step
	public void Set_LanguageSpecific_English_Generate_RandomVanityURL(String string) {  	
    	String RandomVanityURL = string+"VanityURL"+RandomStringUtils.randomNumeric(7);
    	Generated_RandomVanityURL.put(string, RandomVanityURL);
    	ModuleRoom.LanguageSpecific_English_VanityURL_TEXTBOX.type(RandomVanityURL);	
	}
    
    @Step
	public void Set_LanguageSpecific_English_Headline(String string) {
		ModuleRoom.LanguageSpecific_English_Headline_TEXTBOX.type(string);
	}
    
    @Step
	public void Set_LanguageSpecific_English_Description(String string) {
    	ModuleRoom.LanguageSpecific_English_Description_FRAME.click();
		ModuleRoom.LanguageSpecific_English_Description_FRAME.sendKeys(string);
	}
    
    @Step
	public void Set_LanguageSpecific_English_BedTypes(String string) {
		ModuleRoom.LanguageSpecific_English_BedTypes_TEXTBOX.type(string);
	}
    
    @Step
	public void Set_LanguageSpecific_English_Features(String string) {
    	ModuleRoom.LanguageSpecific_English_Features_DROPDOWNTEXTBOX.click();
    	ModuleRoom.LanguageSpecific_English_Features_DROPDOWNTEXTBOX.typeAndEnter(string);
	}
    
    @Step
	public void Set_LanguageSpecific_English_Notes(String string) {
    	ModuleRoom.LanguageSpecific_English_Notes_FRAME.click();
    	ModuleRoom.LanguageSpecific_English_Notes_FRAME.sendKeys(string);
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

	@Step
	public void should_save_new_rooms_settings() {
    	try {
    		assertTrue(ModuleRoom.RoomsList_TABLE.isPresent());
    	} catch (NoSuchElementException ex) {}
	}

}