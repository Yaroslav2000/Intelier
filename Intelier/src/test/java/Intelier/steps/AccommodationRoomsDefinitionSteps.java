package Intelier.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import Intelier.testdata.AccommodationRoomsTestData;

import java.io.IOException;
import java.util.Objects;

import Intelier.steps.serenity.FrontEndModuleRoomSteps;
import Intelier.steps.serenity.LiveCMSGenericSteps;
import Intelier.steps.serenity.LiveCMSModuleRoomSteps;

public class AccommodationRoomsDefinitionSteps {
	
    @Steps
    LiveCMSGenericSteps LiveCMSGenericSteps;

    @Steps
    LiveCMSModuleRoomSteps LiveCMSModuleRoomSteps;
    
    @Steps
    FrontEndModuleRoomSteps FrontEndModuleRoomSteps;
    
    @Before
    public void setup() {
    	LiveCMSGenericSteps.setup();
    }
    
    @After
    public void teardown() {
    	LiveCMSGenericSteps.teardown();
    }

    
//DEBUGGING
//	System.out.println("////////////////////////////////////////");
//	System.out.println("some value");
//	System.out.println("////////////////////////////////////////");
    
//	JavascriptExecutor javascript = (JavascriptExecutor) getDriver();
//	javascript.executeScript("alert('Element Is drag and drop by 100 pixel offset In horizontal direction.');");
//	waitAbit(5000);
//	getDriver().switchTo().alert().accept();
    
   
    
//Background:
    
    @Given("Back-end Administrator has opened room module")
    public void navigate_to_room_module() {
    	LiveCMSModuleRoomSteps.Navigate_to_room_module();
    } 
    
//Scenario: Add new room
    
    @Given("No rooms are in the room list")
    public void no_rooms() {
    	LiveCMSModuleRoomSteps.Delete_all_rooms();
    	LiveCMSModuleRoomSteps.should_see_no_rooms_in_the_list();
    }
    
    @When("Back-end Administrator adds new room '(.*)'")
    public void add_new_room(String room) {
    	LiveCMSModuleRoomSteps.Add_a_room();
    	LiveCMSModuleRoomSteps.Set_General_InternalName(room);
    	LiveCMSModuleRoomSteps.Save_changes();
    }

    @Then("Back-end Administrator should see room '(.*)' in the room list")
    public void should_see_room_in_the_list(String room) {
    	LiveCMSModuleRoomSteps.should_see_room_in_the_list_BE(room);
    }

//Scenario: Cancel adding new Room
    
    @When("Back-end Administrator cancel adding new room '(.*)'")
    public void cancel_adding_new_room(String room) {
    	LiveCMSModuleRoomSteps.Add_a_room();
    	LiveCMSModuleRoomSteps.Set_General_InternalName(room);
    	LiveCMSModuleRoomSteps.Cancel_changes();
    }
    
//Scenario: Delete room
    
    @Given("Room '(.*)' is in the room list")
    public void room_is_in_the_room_list(String room) {
    	LiveCMSModuleRoomSteps.Make_sure_room_exists(room);
    }
    
    @When("Back-end Administrator deletes room '(.*)'")
    public void delete_room(String room) {
    	LiveCMSModuleRoomSteps.Delete_room(room);
    	LiveCMSModuleRoomSteps.Delete_room_confirm();
    }
    
    @Then("Back-end Administrator should not see room '(.*)' in the room list")
    public void should_not_see_room_in_the_list(String room) {
    	LiveCMSModuleRoomSteps.should_not_see_room_in_the_list(room);
    }
    
//Scenario: Edit room
    
	@When("Back-end Administrator edits room '(.*)' with default settings \"([^\"]*)\"")
    public void edit_room(String room, long testdata) {
		AccommodationRoomsTestData.PrepareTestData(testdata);
		LiveCMSModuleRoomSteps.Edit_room(room);
    	LiveCMSModuleRoomSteps.Set_General_Status(AccommodationRoomsTestData.General_Status);
    	LiveCMSModuleRoomSteps.Set_General_InternalName(AccommodationRoomsTestData.General_InternalName);
    	LiveCMSModuleRoomSteps.Set_General_RoomCategory(AccommodationRoomsTestData.General_RoomCategory);
    	LiveCMSModuleRoomSteps.Set_General_FromRate(AccommodationRoomsTestData.General_FromRate);
    	LiveCMSModuleRoomSteps.Set_General_SizeFrom(AccommodationRoomsTestData.General_SizeFrom);
    	LiveCMSModuleRoomSteps.Set_General_SizeTo(AccommodationRoomsTestData.General_SizeTo);
    	LiveCMSModuleRoomSteps.Set_General_Unit(AccommodationRoomsTestData.General_Unit);
    	LiveCMSModuleRoomSteps.Set_General_AdultGuests(AccommodationRoomsTestData.General_AdultGuests);
    	LiveCMSModuleRoomSteps.Set_General_ChildrenGuests(AccommodationRoomsTestData.General_ChildrenGuests);
    	LiveCMSModuleRoomSteps.Set_General_AddAllAmenities();
    	LiveCMSModuleRoomSteps.Open_LanguageSpecific_English();
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_TitleTag(AccommodationRoomsTestData.LanguageSpecific_English_TitleTag);
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_MetaKeywords(AccommodationRoomsTestData.LanguageSpecific_English_MetaKeywords);
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_MetaDescription(AccommodationRoomsTestData.LanguageSpecific_English_MetaDescription);
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_Name(AccommodationRoomsTestData.LanguageSpecific_English_Name);
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_Generate_RandomVanityURL(room);
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_Headline(AccommodationRoomsTestData.LanguageSpecific_English_Headline);
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_Description(AccommodationRoomsTestData.LanguageSpecific_English_Description);
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_BedTypes(AccommodationRoomsTestData.LanguageSpecific_English_BedTypes);
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_Features(AccommodationRoomsTestData.LanguageSpecific_English_Features);
    	LiveCMSModuleRoomSteps.Set_LanguageSpecific_English_Notes(AccommodationRoomsTestData.LanguageSpecific_English_Notes);
    	LiveCMSModuleRoomSteps.Save_changes();
    }

	@Then("Back-end Administrator should save room '(.*)' new settings")
    public void should_save_room_new_settings(String room) {
    	LiveCMSModuleRoomSteps.should_save_room_new_settings(room);
    }
    
    @Then("Front-end User should see room '(.*)' new settings")
    public void should_see_FE_room_new_settings_on_FE(String room) {
    	FrontEndModuleRoomSteps.openFE();
    	FrontEndModuleRoomSteps.should_see_FE_room_in_the_list(AccommodationRoomsTestData.LanguageSpecific_English_Name);
    	FrontEndModuleRoomSteps.open_vanity_URL(LiveCMSModuleRoomSteps.Generated_RandomVanityURL.get(room));
    	FrontEndModuleRoomSteps.should_see_FE_Room_Name(AccommodationRoomsTestData.LanguageSpecific_English_Name);
    	FrontEndModuleRoomSteps.should_see_FE_RoomCategory(AccommodationRoomsTestData.General_RoomCategory);
    	FrontEndModuleRoomSteps.should_see_FE_FromRate(AccommodationRoomsTestData.General_FromRate);
    	FrontEndModuleRoomSteps.should_see_FE_SizeFrom(AccommodationRoomsTestData.General_SizeFrom);
    	FrontEndModuleRoomSteps.should_see_FE_SizeTo(AccommodationRoomsTestData.General_SizeTo);
    	FrontEndModuleRoomSteps.should_see_FE_Unit(AccommodationRoomsTestData.General_Unit);
    	FrontEndModuleRoomSteps.should_see_FE_Headline(AccommodationRoomsTestData.LanguageSpecific_English_Headline);
    	FrontEndModuleRoomSteps.should_see_FE_Description(AccommodationRoomsTestData.LanguageSpecific_English_Description);
    	FrontEndModuleRoomSteps.should_see_FE_BedTypes(AccommodationRoomsTestData.LanguageSpecific_English_BedTypes);
    	FrontEndModuleRoomSteps.should_see_FE_Features(AccommodationRoomsTestData.LanguageSpecific_English_Features);
    	FrontEndModuleRoomSteps.should_see_FE_Notes(AccommodationRoomsTestData.LanguageSpecific_English_Notes);
    }
    
//Scenario: Search room
    
    @When("Back-end Administrator searches for room '(.*)'")
    public void search_room(String room) {
    	LiveCMSModuleRoomSteps.Search_room(room);
    }
    
//Scenario: Sorting rooms
    
    @When("Back-end Administrator drag-and-drop room '(.*)' to room '(.*)'")
    public void sorting_rooms(String room2, String room1) {
    	LiveCMSModuleRoomSteps.Sorting_rooms(room2, room1);
    }
    
    @Then("Back-end Administrator should see room '(.*)' first in the room list")
    public void should_see_room_in_the_list_first(String room) {
    	LiveCMSModuleRoomSteps.should_see_room_in_the_list_first(room);
    }

//Scenario: Edit Rooms Settings for English language
    
    @When("Back-end Administrator edits rooms settings for English language with default parameters")
    public void edit_rooms_settings() {
    	LiveCMSModuleRoomSteps.Edit_rooms_settings();
    	LiveCMSModuleRoomSteps.Set_Settings_English_TitleTag("Automation Settings Title Tag");
    	LiveCMSModuleRoomSteps.Set_Settings_English_MetaKeywords("Automation Settings Meta Keywords");
    	LiveCMSModuleRoomSteps.Set_Settings_English_MetaDescription("AutomationSettings Meta Description");
    	LiveCMSModuleRoomSteps.Set_Settings_English_Status("Active");
    	LiveCMSModuleRoomSteps.Set_Settings_English_RoomsOverview("Matrix and list view toggle");
    	LiveCMSModuleRoomSteps.Set_Settings_English_Default("Matrix view");
    	LiveCMSModuleRoomSteps.Set_Settings_English_DefaultUnitType("m²");
    	LiveCMSModuleRoomSteps.Set_Settings_English_AddAllFilters();
    	LiveCMSModuleRoomSteps.Save_changes();
    }
    
    @Then("Back-end Administrator should save new rooms settings")
    public void should_save_new_rooms_settings() {
    	LiveCMSModuleRoomSteps.should_save_new_rooms_settings();
    }
    
}
