package Intelier.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import Intelier.pages.LiveCMSGeneric;
import Intelier.steps.serenity.LiveCMSGenericSteps;
import Intelier.steps.serenity.LiveCMSModuleRoomSteps;

public class AccommodationRoomsDefinitionSteps {
	
    @Steps
    LiveCMSModuleRoomSteps LiveCMSModuleRoomSteps;
    
    @Steps
    LiveCMSGenericSteps LiveCMSGenericSteps;

    @Before
    public void Setup() {
    	LiveCMSGenericSteps.setup();
    }
    
    @After
    public void Teardown() {
    	LiveCMSGenericSteps.teardown();
    }

//Background:
    
    @Given("Back-end Administrator has opened room module")
    public void Navigate_to_room_module() {
    	LiveCMSModuleRoomSteps.navigate_to_room_module();
    }

//Samples
    
//  @And("Should be able to add new room '(.*)'")
//  public void Add_new_room(String room) {
//  	//BackEndAdministrator.add_new_room(room);
//  	//BackEndAdministrator.should_see_room_in_the_list(room);
//  }      
    
//Scenario: Add new room
    
    @Given("No rooms are in the room list")
    public void No_rooms() {
    	LiveCMSModuleRoomSteps.delete_all_rooms();
    	LiveCMSModuleRoomSteps.should_see_no_rooms_in_the_list();
    }
    
    @When("Back-end Administrator adds new room '(.*)'")
    public void add_new_room(String room) {
    	LiveCMSModuleRoomSteps.add_new_room(room);
    }

    @Then("Back-end Administrator should see room '(.*)' in the room list")
    public void should_see_room_in_the_list(String room) {
    	LiveCMSModuleRoomSteps.should_see_room_in_the_list(room);
    }

//Scenario: Cancel adding new Room
    
    @When("Back-end Administrator cancel adding new room '(.*)'")
    public void cancel_adding_new_room(String room) {
    	LiveCMSModuleRoomSteps.cancel_adding_new_room(room);
    }
    
//Scenario: Delete room
    
    @Given("'(.*)' room is in the room list")
    public void room_is_in_the_room_list(String room) {
    	LiveCMSModuleRoomSteps.add_new_room(room);
    }
    
    @When("Back-end Administrator deletes room '(.*)'")
    public void delete_room(String room) {
    	LiveCMSModuleRoomSteps.delete_room(room);
    }
    
    @Then("Back-end Administrator should not see room '(.*)' in the room list")
    public void should_not_see_room_in_the_list(String room) {
    	LiveCMSModuleRoomSteps.should_not_see_room_in_the_list(room);
    }
    
//Scenario: Edit room - General settings
    
    @When("Back-end Administrator edits room '(.*)' general settings")
    public void edit_room_general_settings(String room) {
    	LiveCMSModuleRoomSteps.edit_room_default_settings(room);
    }
    
    @Then("Back-end Administrator should save room '(.*)' new settings")
    public void should_save_room_new_settings(String room) {
    	LiveCMSModuleRoomSteps.should_save_room_new_settings(room);
    }
    
//Scenario: Edit room - Language-specific settings
    
    @When("Back-end Administrator edits room '(.*)' language-specific settings")
    public void edit_room_language_specific_settings(String room) {
    	//LiveCMSModuleRoomSteps.edit_room_default_settings(room);
    }
    
}
