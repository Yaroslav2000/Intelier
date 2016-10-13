package Intelier.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import Intelier.steps.serenity.LiveCMSGenericSteps;
import Intelier.steps.serenity.LiveCMSModuleRoomSteps;

public class AccommodationRoomsDefinitionSteps {
	
    @Steps
    LiveCMSModuleRoomSteps ModuleRoomSteps;
    
    @Steps
    LiveCMSGenericSteps GenericSteps;

    @Before
    public void setup() {
    	GenericSteps.setup();
    }
    
    @After
    public void teardown() {
    	GenericSteps.teardown();
    }
    
//DEBUGGING
//	System.out.println("--------------------------------------");
//	System.out.println("some value");
//	System.out.println("--------------------------------------");
    
//	JavascriptExecutor javascript = (JavascriptExecutor) getDriver();
//	javascript.executeScript("alert('Element Is drag and drop by 100 pixel offset In horizontal direction.');");
//	waitABit(5000);
//	getDriver().switchTo().alert().accept();
    
//Background:
    
    @Given("Back-end Administrator has opened room module")
    public void navigate_to_room_module() {
    	ModuleRoomSteps.Navigate_to_room_module();
    } 
    
//Scenario: Add new room
    
    @Given("No rooms are in the room list")
    public void no_rooms() {
    	ModuleRoomSteps.Delete_all_rooms();
    	ModuleRoomSteps.should_see_no_rooms_in_the_list();
    }
    
    @When("Back-end Administrator adds new room '(.*)'")
    public void add_new_room(String room) {
    	ModuleRoomSteps.Add_a_room();
    	ModuleRoomSteps.GeneralTab_InternalName(room);
    	ModuleRoomSteps.Save_changes();
    }

    @Then("Back-end Administrator should see room '(.*)' in the room list")
    public void should_see_room_in_the_list(String room) {
    	ModuleRoomSteps.should_see_room_in_the_list(room);
    }

//Scenario: Cancel adding new Room
    
    @When("Back-end Administrator cancel adding new room '(.*)'")
    public void cancel_adding_new_room(String room) {
    	ModuleRoomSteps.Add_a_room();
    	ModuleRoomSteps.GeneralTab_InternalName(room);
    	ModuleRoomSteps.Cancel_changes();
    }
    
//Scenario: Delete room
    
    @Given("Room '(.*)' is in the room list")
    public void room_is_in_the_room_list(String room) {
    	ModuleRoomSteps.Make_sure_room_exists(room);
    }
    
    @When("Back-end Administrator deletes room '(.*)'")
    public void delete_room(String room) {
    	ModuleRoomSteps.Delete_room(room);
    	ModuleRoomSteps.Delete_room_confirm();
    }
    
    @Then("Back-end Administrator should not see room '(.*)' in the room list")
    public void should_not_see_room_in_the_list(String room) {
    	ModuleRoomSteps.should_not_see_room_in_the_list(room);
    }
    
//Scenario: Edit room - General settings
    
    @When("Back-end Administrator edits room '(.*)' with default general settings")
    public void edit_room_general_settings(String room) {
    	ModuleRoomSteps.Edit_room(room);
    	ModuleRoomSteps.GeneralTab_Status("Active");
    	ModuleRoomSteps.GeneralTab_InternalName(room);
    	ModuleRoomSteps.GeneralTab_RoomCategory("Suites");
    	ModuleRoomSteps.GeneralTab_FromRate("99");
    	ModuleRoomSteps.GeneralTab_SizeFrom("10");
    	ModuleRoomSteps.GeneralTab_SizeTo("20");
    	ModuleRoomSteps.GeneralTab_Unit("ft²");
    	ModuleRoomSteps.GeneralTab_AdultGuests(1);
    	ModuleRoomSteps.GeneralTab_ChildrenGuests(2);
    	ModuleRoomSteps.GeneralTab_AddAllAmenities();
    	ModuleRoomSteps.Save_changes();
    }
    
    @Then("Back-end Administrator should save room '(.*)' new settings")
    public void should_save_room_new_settings(String room) {
    	ModuleRoomSteps.should_save_room_new_settings(room);
    }
    
//Scenario: Edit room - Language-specific settings
    
    @When("Back-end Administrator edits room '(.*)' with English language-specific settings")
    public void edit_room_language_specific_settings(String room) {
    	ModuleRoomSteps.Edit_room(room);
    	ModuleRoomSteps.Open_LanguageSpecific_EnglishTab();
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_TitleTag("AutomationRoom Title Tag");
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_MetaKeywords("AutomationRoom Meta Keywords");
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_MetaDescription("AutomationRoom Meta Description");
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_Name("AutomationRoom Name");
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_VanityURL("AutomationRoom Vanity URL");
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_Headline("AutomationRoom Headline");
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_Description("AutomationRoom Description");
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_BedTypes("AutomationRoom Bed Types");
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_Features("AutomationRoom Features");
    	ModuleRoomSteps.LanguageSpecific_EnglishTab_Notes("AutomationRoom Notes");
    	ModuleRoomSteps.Save_changes();
    }
    
//Scenario: Search room
    
    @When("Back-end Administrator searches for room '(.*)'")
    public void search_room(String room) {
    	ModuleRoomSteps.Search_room(room);
    	ModuleRoomSteps.should_see_room_in_the_list(room);
    }
    
//Scenario: Sorting rooms
    
    @When("Back-end Administrator drag-and-drop room '(.*)' to room '(.*)'")
    public void sorting_rooms(String room2, String room1) {
    	ModuleRoomSteps.Sorting_rooms(room2, room1);
    }
    
    @Then("Back-end Administrator should see room '(.*)' first in the room list")
    public void should_see_room_in_the_list_first(String room) {
    	ModuleRoomSteps.should_see_room_in_the_list_first(room);
    }

//Scenario: Edit Rooms Settings for English language
    
    @When("Back-end Administrator edits rooms settings for English language with default parameters")
    public void edit_rooms_settings() {
    	ModuleRoomSteps.Edit_rooms_settings();
    	ModuleRoomSteps.Settings_EnglishTab_TitleTag("Automation Settings Title Tag");
    	ModuleRoomSteps.Settings_EnglishTab_MetaKeywords("Automation Settings Meta Keywords");
    	ModuleRoomSteps.Settings_EnglishTab_MetaDescription("AutomationSettings Meta Description");
    	ModuleRoomSteps.Settings_EnglishTab_Status("Active");
    	ModuleRoomSteps.Settings_EnglishTab_RoomsOverview("Matrix and list view toggle");
    	ModuleRoomSteps.Settings_EnglishTab_Default("Matrix view");
    	ModuleRoomSteps.Settings_EnglishTab_DefaultUnitType("m²");
    	ModuleRoomSteps.Settings_EnglishTab_AddAllFilters();
    	ModuleRoomSteps.Save_changes();
    }
    
    @Then("^Back-end Administrator should save new rooms settings$")
    public void back_end_Administrator_should_save_new_rooms_settings() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
