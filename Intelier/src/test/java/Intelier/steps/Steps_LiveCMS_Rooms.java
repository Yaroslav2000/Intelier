package Intelier.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.Pages_LiveCMS_Rooms;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.components.HtmlTable;
import net.thucydides.core.steps.ScenarioSteps;

public class Steps_LiveCMS_Rooms extends ScenarioSteps {

	Pages_LiveCMS_Rooms BE;
    
// -----------------------------------------------------------------------------------------------------------------
// COMMON
	
	@Step
    public void navigate_to_Room_module() {
		BE.open();
    }
	
	@Step
	public void open_Add_a_Room() {
		BE.AddRoom_LINK.click();
	}
	
	@Step
	public void save_changes() {
		BE.Save_BUTTON.click();
	}
	
	@Step
	public void open_Edit_room(String string) {
		BE.open_Edit_room(string);
	}
    
    @Step
    public void open_Delete_room(String string) {
    	BE.open_Delete_room(string);
	}
    
    @Step
    public void confirm_Delete_room() {
    	BE.DeleteConfirmYes_BUTTON.click();
	}

    @Step
    public void delete_all_rooms() {
    	BE.delete_all_rooms();
	}
    
    @Step
	public void cancel_changes() {
    	BE.Close_BUTTON.click();
	}
    
    @Step
	public void make_sure_room_exists(String string) {
        if (verify_room_exists(string) != true) {
        	BE.AddRoom_LINK.click();
        	BE.General_InternalName_TEXTBOX.type(string);
        	BE.Save_BUTTON.click();
        }
	}
    
    @Step
	public void search_room(String room) {
		BE.Search_TEXTBOX.type(room);
	}
	
    @Step
	public void sorting_rooms(String room2, String room1) {
		BE.drag_and_drop(room2, room1);
	}
    
    @Step
	public void open_Room_module_Settings() {
    	BE.open_Room_module_Settings();
	}
    
    

// -----------------------------------------------------------------------------------------------------------------
// SETTINGS
    
    @Step
	public void set_Settings_English_TitleTag(String string) {
    	BE.Settings_English_TitleTag_TEXTBOX.type(string);	
	}

    @Step
	public void set_Settings_English_MetaKeywords(String string) {
    	BE.Settings_English_MetaKeywords_TEXTBOX.type(string);
	}

    @Step
	public void set_Settings_English_MetaDescription(String string) {
    	BE.Settings_English_MetaDescription_TEXTBOX.type(string);
	}

    @Step
	public void set_Settings_English_Status(String string) {
		if (string.equals("Active")) {
			BE.Settings_English_Status_Active_RADIOBUTTON.click();
		} else if (string.equals("Inactive")) {
			BE.Settings_English_Status_InActive_RADIOBUTTON.click();
		}
	}

    @Step
	public void set_Settings_English_RoomsOverview(String string) {
		if (string.equals("Matrix view only")) {
			BE.Settings_English_RoomsOverview_MatrixViewOnly_RADIOBUTTON.click();
		} else if (string.equals("List view only")) {
			BE.Settings_English_RoomsOverview_ListViewOnly_RADIOBUTTON.click();
		} else if (string.equals("Matrix and list view toggle")) {
			BE.Settings_English_RoomsOverview_MatrixAndListViewToggle_RADIOBUTTON.click();
		}
	}

    @Step
	public void set_Settings_English_Default(String string) {
    	if (string.equals("Matrix view")) {
			BE.Settings_English_Default_DROPDOWN.selectByValue(BE.getValueByLabel(string));
		} else if (string.equals("List view")) {
			BE.Settings_English_Default_DROPDOWN.selectByValue(BE.getValueByLabel(string));
		}
	}

    @Step
	public void set_Settings_English_DefaultUnitType(String string) {
		if (string.equals("m²")) {
			BE.Settings_English_DefaultUnitType_DROPDOWN.selectByValue(BE.getValueByLabel(string));
		} else if (string.equals("ft²")) {
			BE.Settings_English_DefaultUnitType_DROPDOWN.selectByValue(BE.getValueByLabel(string));
		}
	}

    @Step
	public void set_Settings_English_Filters_AddAll() {
    	if (!BE.Settings_English_Filters_FromRate_CHECKBOX.isSelected()) {
    		BE.Settings_English_Filters_FromRate_CHECKBOX.click();
    	}
    	if (!BE.Settings_English_Filters_RoomType_CHECKBOX.isSelected()) {
    	BE.Settings_English_Filters_RoomType_CHECKBOX.click();
    	}
    	if (!BE.Settings_English_Filters_Sleeps_CHECKBOX.isSelected()) {
    	BE.Settings_English_Filters_Sleeps_CHECKBOX.click();
    	}
    	if (!BE.Settings_English_Filters_Amenities_CHECKBOX.isSelected()) {
    	BE.Settings_English_Filters_Amenities_CHECKBOX.click();
    	}
	}

    
    
// -----------------------------------------------------------------------------------------------------------------
// GENERAL TAB
    
    @Step
	public void set_General_Status(String string) {
    	if (string.equals("Active")) {
    		BE.General_Status_Active_RADIOBUTTON.click();
		} else if (string.equals("Inactive")) {
			BE.General_Status_Inactive_RADIOBUTTON.click();
		}
	}
	
    @Step
	public void set_General_InternalName(String string) {
		BE.General_InternalName_TEXTBOX.type(string);
	}
    
    @Step
	public void set_General_RoomCategory(String string) {
		if (string.equals("Guest Rooms")) {
			BE.General_RoomCategory_DROPDOWN.selectByValue(BE.getValueByLabel(string));
		} else if (string.equals("Suites")) {
			BE.General_RoomCategory_DROPDOWN.selectByValue(BE.getValueByLabel(string));
		}
	}
	
    @Step
	public void set_General_FromRate(String string) {
    	BE.General_FromRate_TEXTBOX.type(string);
	}
	
    @Step
	public void set_General_SizeFrom(String string) {
    	BE.General_SizeFrom_TEXTBOX.type(string);
	}
	
    @Step
	public void set_General_SizeTo(String string) {
    	BE.General_SizeTo_TEXTBOX.type(string);
	}
	
    @Step
	public void set_General_Unit(String string) {
		if (string.equals("m²")) {
			BE.General_Unit_DROPDOWN.selectByValue("m");
		} else if (string.equals("ft²")) {
			BE.General_Unit_DROPDOWN.selectByValue("f");
		}
	}
	
    @Step
	public void set_General_AdultGuests(Integer number) {
    	BE.General_AdultGuests_DROPDOWN.selectByIndex(number);
	}
	
    @Step
	public void set_General_ChildrenGuests(Integer number) {
    	BE.General_ChildrenGuests_DROPDOWN.selectByIndex(number);
	}
	
    @Step
	public void set_General_Amenities_AddAll() {
    	BE.General_AddAllAmenities_BUTTON.click();
	}
    
// -----------------------------------------------------------------------------------------------------------------
// LANGUAGE-SPECIFIC TAB
    
    @Step
	public void open_LanguageSpecific_English_Tab() {
		BE.LanguageSpecific_English.click();
	}
    
    @Step
	public void set_LanguageSpecific_English_TitleTag(String string) {
		BE.LanguageSpecific_English_TitleTag_TEXTBOX.type(string);
	}
    
    @Step
	public void set_LanguageSpecific_English_MetaKeywords(String string) {
		BE.LanguageSpecific_English_MetaKeywords_TEXTBOX.type(string);
	}

    @Step
	public void set_LanguageSpecific_English_MetaDescription(String string) {
		BE.LanguageSpecific_English_MetaDescription_TEXTBOX.type(string);
	}
    
    @Step
	public void set_LanguageSpecific_English_Name(String string) {
		BE.LanguageSpecific_English_Name_TEXTBOX.type(string);
	}
    
    public Map<String, String> Generated_RandomVanityURL = new HashMap<String, String>();
    
    @Step
	public void set_LanguageSpecific_English_RandomVanityURL_generate(String room) {  	
    	String RandomVanityURL = room+"VanityURL"+RandomStringUtils.randomNumeric(7);
    	BE.LanguageSpecific_English_VanityURL_TEXTBOX.type(RandomVanityURL);
    	Generated_RandomVanityURL.put(room, RandomVanityURL);
	}
    
    @Step
	public void set_LanguageSpecific_English_Headline(String string) {
		BE.LanguageSpecific_English_Headline_TEXTBOX.type(string);
	}
    
    @Step
	public void set_LanguageSpecific_English_Description(String string) {
    	BE.LanguageSpecific_English_Description_FRAME.click();
		BE.LanguageSpecific_English_Description_FRAME.sendKeys(string);
	}
    
    @Step
	public void set_LanguageSpecific_English_BedTypes(String string) {
		BE.LanguageSpecific_English_BedTypes_TEXTBOX.type(string);
	}
    
    @Step
	public void set_LanguageSpecific_English_Features(String string) {
    	BE.LanguageSpecific_English_Features_DROPDOWNTEXTBOX.click();
    	BE.LanguageSpecific_English_Features_DROPDOWNTEXTBOX.typeAndEnter(string);
	}
    
    @Step
	public void set_LanguageSpecific_English_Notes(String string) {
    	BE.LanguageSpecific_English_Notes_FRAME.click();
    	BE.LanguageSpecific_English_Notes_FRAME.sendKeys(string);
	}
    
// -----------------------------------------------------------------------------------------------------------------
// VERIFICATIONS    
    
    @Step
	public void should_see_room_in_the_list(String string) {
    	try {
    		assertTrue(HtmlTable.rowsFrom(BE.RoomsList_TABLE).toString().contains(string));
    	} catch (NoSuchElementException ex) {}
	}
    
    @Step
	public void should_not_see_room_in_the_list(String string) {
    	try {
	    	assertFalse(HtmlTable.rowsFrom(BE.RoomsList_TABLE).toString().contains(string));
	    } catch (NoSuchElementException ex) {}
	}
    
    @Step
	public void should_see_no_rooms_in_the_list() {
    	try {	
	    	assertTrue(HtmlTable.rowsFrom(BE.RoomsList_TABLE).toString().isEmpty());
	    } catch (NoSuchElementException ex) {}
	}
    
	public boolean verify_room_exists(String string) {
    	try {
    		if (HtmlTable.rowsFrom(BE.RoomsList_TABLE).toString().contains(string)) {;
    			return true;
    		}
    	} catch (NoSuchElementException ex) {}
    	return false;
	}

	@Step
	public void should_see_room_in_the_list_first(String string) {
    	try {
    		assertTrue(BE.FirstRoom_ROW.getAttribute("data-name").toString().contains(string));
    	} catch (NoSuchElementException ex) {}
	}

	@Step
	public void should_save_Room_module_settings() {
    	try {
    		assertTrue(BE.RoomsList_TABLE.isPresent());
    	} catch (NoSuchElementException ex) {}
	}

}