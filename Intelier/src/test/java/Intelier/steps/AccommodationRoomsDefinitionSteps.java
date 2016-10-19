package Intelier.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
//	System.out.println("--------------------------------------");
//	System.out.println("some value");
//	System.out.println("--------------------------------------");
    
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
    	LiveCMSModuleRoomSteps.General_InternalName(room);
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
    	LiveCMSModuleRoomSteps.General_InternalName(room);
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
    
    @When("Back-end Administrator edits room '(.*)' with default settings")
    public void edit_room(String room) {
    	LiveCMSModuleRoomSteps.Edit_room(room);
    	LiveCMSModuleRoomSteps.General_Status("Active");
    	LiveCMSModuleRoomSteps.General_InternalName(room);
    	LiveCMSModuleRoomSteps.General_RoomCategory("Guest Rooms");
    	LiveCMSModuleRoomSteps.General_FromRate("99");
    	LiveCMSModuleRoomSteps.General_SizeFrom("10");
    	LiveCMSModuleRoomSteps.General_SizeTo("20");
    	LiveCMSModuleRoomSteps.General_Unit("ft²");
    	LiveCMSModuleRoomSteps.General_AdultGuests(1);
    	LiveCMSModuleRoomSteps.General_ChildrenGuests(2);
    	LiveCMSModuleRoomSteps.General_AddAllAmenities();
    	LiveCMSModuleRoomSteps.Open_LanguageSpecific_English();
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_TitleTag(room+" TitleTag");
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_MetaKeywords(room+" MetaKeywords");
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_MetaDescription(room+" MetaDescription");
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_Name(room);
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_Generate_RandomVanityURL(room);
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_Headline(room+" Headline");
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_Description(room+" Description");
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_BedTypes(room+" BedTypes");
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_Features(room+" Features");
    	LiveCMSModuleRoomSteps.LanguageSpecific_English_Notes(room+" Notes");
    	LiveCMSModuleRoomSteps.Save_changes();
    	
  	
    	
    	
    	
    }
    
    @Then("Back-end Administrator should save room '(.*)' new settings")
    public void should_save_room_new_settings(String room) {
    	LiveCMSModuleRoomSteps.should_save_room_new_settings(room);
    }
    
    @Then("Front-end User should see room '(.*)' new settings")
    public void should_see_FE_room_new_settings_on_FE(String room) {
    	FrontEndModuleRoomSteps.openFE();
    	FrontEndModuleRoomSteps.should_see_FE_room_in_the_list(room);
    	FrontEndModuleRoomSteps.open_vanity_URL(LiveCMSModuleRoomSteps.Generated_RandomVanityURL.get(room));
    	FrontEndModuleRoomSteps.should_see_FE_Room_Name(room+" Name");
    	FrontEndModuleRoomSteps.should_see_FE_RoomCategory("Guest Rooms");
    	FrontEndModuleRoomSteps.should_see_FE_FromRate("99");
    	FrontEndModuleRoomSteps.should_see_FE_SizeFrom("10");
    	FrontEndModuleRoomSteps.should_see_FE_SizeTo("20");
    	FrontEndModuleRoomSteps.should_see_FE_Unit("ft²");
    	FrontEndModuleRoomSteps.should_see_FE_Headline(room+" Headline");
    	FrontEndModuleRoomSteps.should_see_FE_Description(room+" Description");
    	FrontEndModuleRoomSteps.should_see_FE_BedTypes(room+" BedTypes");
    	FrontEndModuleRoomSteps.should_see_FE_Features(room+" Features");
    	FrontEndModuleRoomSteps.should_see_FE_Notes(room+" Notes");
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
    	LiveCMSModuleRoomSteps.Settings_English_TitleTag("Automation Settings Title Tag");
    	LiveCMSModuleRoomSteps.Settings_English_MetaKeywords("Automation Settings Meta Keywords");
    	LiveCMSModuleRoomSteps.Settings_English_MetaDescription("AutomationSettings Meta Description");
    	LiveCMSModuleRoomSteps.Settings_English_Status("Active");
    	LiveCMSModuleRoomSteps.Settings_English_RoomsOverview("Matrix and list view toggle");
    	LiveCMSModuleRoomSteps.Settings_English_Default("Matrix view");
    	LiveCMSModuleRoomSteps.Settings_English_DefaultUnitType("m²");
    	LiveCMSModuleRoomSteps.Settings_English_AddAllFilters();
    	LiveCMSModuleRoomSteps.Save_changes();
    }
    
    @Then("Back-end Administrator should save new rooms settings")
    public void should_save_new_rooms_settings() {
    	LiveCMSModuleRoomSteps.should_save_new_rooms_settings();
    }
    
}
