package Intelier.step_definitions;

import net.thucydides.core.annotations.Steps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Intelier.steps.FrontEnd_Steps_Rooms;
import Intelier.steps.LiveCMS_Steps_Rooms;
import Intelier.testdata.TestData_AccommodationRooms;

public class StepDefinitions_AccommodationRooms {

    @Steps
    LiveCMS_Steps_Rooms BE;
    
    @Steps
    FrontEnd_Steps_Rooms FE;
    
//Background:
    
    @Given("Back-end Administrator has opened Room module")
    public void open_Room_module() {
    	BE.navigate_to_Room_module();
    } 
    
//Scenario: Add new room
    
    @Given("No rooms are in the room list")
    public void no_rooms() {
    	BE.delete_all_rooms();
    	BE.should_see_no_rooms_in_the_list();
    }
    
    @When("Back-end Administrator adds new room '(.*)'")
    public void add_new_room(String room) {
    	BE.open_Add_a_Room();
    	BE.set_General_InternalName(room);
    	BE.save_changes();
    }

    @Then("Back-end Administrator should see room '(.*)' in the room list")
    public void should_see_room_in_the_list(String room) {
    	BE.should_see_room_in_the_list_BE(room);
    }

//Scenario: Cancel adding new Room
    
    @When("Back-end Administrator cancel adding new room '(.*)'")
    public void cancel_adding_new_room(String room) {
    	BE.open_Add_a_Room();
    	BE.set_General_InternalName(room);
    	BE.cancel_changes();
    }
    
//Scenario: Delete room
    
    @Given("Room '(.*)' is in the room list")
    public void room_is_in_the_room_list(String room) {
    	BE.make_sure_room_exists(room);
    }
    
    @When("Back-end Administrator deletes room '(.*)'")
    public void delete_room(String room) {
    	BE.open_Delete_room(room);
    	BE.confirm_Delete_room();
    }
    
    @Then("Back-end Administrator should not see room '(.*)' in the room list")
    public void should_not_see_room_in_the_list(String room) {
    	BE.should_not_see_room_in_the_list(room);
    }
    
//Scenario: Edit room
    
	@When("Back-end Administrator edits room '(.*)' with default settings \"([^\"]*)\"")
    public void edit_room(String room, long testdata) {
		TestData_AccommodationRooms.prepareTestData(testdata);
		BE.open_Edit_room(room);
    	BE.set_General_Status(TestData_AccommodationRooms.General_Status);
    	BE.set_General_InternalName(TestData_AccommodationRooms.General_InternalName);
    	BE.set_General_RoomCategory(TestData_AccommodationRooms.General_RoomCategory);
    	BE.set_General_FromRate(TestData_AccommodationRooms.General_FromRate);
    	BE.set_General_SizeFrom(TestData_AccommodationRooms.General_SizeFrom);
    	BE.set_General_SizeTo(TestData_AccommodationRooms.General_SizeTo);
    	BE.set_General_Unit(TestData_AccommodationRooms.General_Unit);
    	BE.set_General_AdultGuests(TestData_AccommodationRooms.General_AdultGuests);
    	BE.set_General_ChildrenGuests(TestData_AccommodationRooms.General_ChildrenGuests);
    	BE.set_General_Amenities_AddAll();
    	BE.open_LanguageSpecific_English_Tab();
    	BE.set_LanguageSpecific_English_TitleTag(TestData_AccommodationRooms.LanguageSpecific_English_TitleTag);
    	BE.set_LanguageSpecific_English_MetaKeywords(TestData_AccommodationRooms.LanguageSpecific_English_MetaKeywords);
    	BE.set_LanguageSpecific_English_MetaDescription(TestData_AccommodationRooms.LanguageSpecific_English_MetaDescription);
    	BE.set_LanguageSpecific_English_Name(TestData_AccommodationRooms.LanguageSpecific_English_Name);
    	BE.set_LanguageSpecific_English_RandomVanityURL_generate(room);
    	BE.set_LanguageSpecific_English_Headline(TestData_AccommodationRooms.LanguageSpecific_English_Headline);
    	BE.set_LanguageSpecific_English_Description(TestData_AccommodationRooms.LanguageSpecific_English_Description);
    	BE.set_LanguageSpecific_English_BedTypes(TestData_AccommodationRooms.LanguageSpecific_English_BedTypes);
    	BE.set_LanguageSpecific_English_Features(TestData_AccommodationRooms.LanguageSpecific_English_Features);
    	BE.set_LanguageSpecific_English_Notes(TestData_AccommodationRooms.LanguageSpecific_English_Notes);
    	BE.save_changes();
    }

	@Then("Back-end Administrator should save room '(.*)' new settings")
    public void should_save_room_new_settings(String room) {
    	BE.should_save_room_new_settings(room);
    }
    
    @Then("Front-end User should see room '(.*)' new settings")
    public void should_see_room_new_settings_FE(String room) {
    	FE.openFE();
    	FE.should_see_FE_room_in_the_list(TestData_AccommodationRooms.LanguageSpecific_English_Name);
    	FE.open_vanity_URL(BE.Generated_RandomVanityURL.get(room));
    	FE.should_see_FE_Room_Name(TestData_AccommodationRooms.LanguageSpecific_English_Name);
    	FE.should_see_FE_RoomCategory(TestData_AccommodationRooms.General_RoomCategory);
    	FE.should_see_FE_FromRate(TestData_AccommodationRooms.General_FromRate);
    	FE.should_see_FE_SizeFrom(TestData_AccommodationRooms.General_SizeFrom);
    	FE.should_see_FE_SizeTo(TestData_AccommodationRooms.General_SizeTo);
    	FE.should_see_FE_Unit(TestData_AccommodationRooms.General_Unit);
    	FE.should_see_FE_Headline(TestData_AccommodationRooms.LanguageSpecific_English_Headline);
    	FE.should_see_FE_Description(TestData_AccommodationRooms.LanguageSpecific_English_Description);
    	FE.should_see_FE_BedTypes(TestData_AccommodationRooms.LanguageSpecific_English_BedTypes);
    	FE.should_see_FE_Features(TestData_AccommodationRooms.LanguageSpecific_English_Features);
    	FE.should_see_FE_Notes(TestData_AccommodationRooms.LanguageSpecific_English_Notes);
    }
    
//Scenario: Search room
    
    @When("Back-end Administrator searches for room '(.*)'")
    public void search_room(String room) {
    	BE.search_room(room);
    }
    
//Scenario: Sorting rooms
    
    @When("Back-end Administrator drag-and-drop room '(.*)' to room '(.*)'")
    public void sorting_rooms(String room2, String room1) {
    	BE.sorting_rooms(room2, room1);
    }
    
    @Then("Back-end Administrator should see room '(.*)' first in the room list")
    public void should_see_room_in_the_list_first(String room) {
    	BE.should_see_room_in_the_list_first(room);
    }

//Scenario: Edit Rooms Settings for English language
    
    @When("Back-end Administrator edits Room module settings for English language with default parameters")
    public void edit_Room_module_settings() {
    	BE.open_Room_module_Settings();
    	BE.set_Settings_English_TitleTag("Automation Settings Title Tag");
    	BE.set_Settings_English_MetaKeywords("Automation Settings Meta Keywords");
    	BE.set_Settings_English_MetaDescription("AutomationSettings Meta Description");
    	BE.set_Settings_English_Status("Active");
    	BE.set_Settings_English_RoomsOverview("Matrix and list view toggle");
    	BE.set_Settings_English_Default("Matrix view");
    	BE.set_Settings_English_DefaultUnitType("m²");
    	BE.set_Settings_English_Filters_AddAll();
    	BE.save_changes();
    }
    
    @Then("Back-end Administrator should save Room module new settings")
    public void should_save_Room_module_new_settings() {
    	BE.should_save_Room_module_new_settings();
    }
    
}
