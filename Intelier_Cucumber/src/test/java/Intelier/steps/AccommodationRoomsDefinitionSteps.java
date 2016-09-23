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
	LiveCMSGeneric liveCMSGenericSteps;
	
	LiveCMSGeneric liveCMSGeneric;
	
    @Steps
    LiveCMSModuleRoomSteps BackEndAdministrator;
    
    @Steps
    LiveCMSGenericSteps LiveCMSGenericSteps;

    @Before
    public void LiveCMS_setup() {
    	liveCMSGeneric.open();
    	liveCMSGenericSteps.login();
//    	LiveCMSGenericSteps.openLiveCMS();
//    	LiveCMSGenericSteps.login();
    }
    
    @After
    public void LiveCMS_exit() {
    	liveCMSGenericSteps.logout();
//    	LiveCMSGenericSteps.logout();
    }

//Background:
    
    @Given("Back-end Administrator has opened room module")
    public void Navigate_to_room_module() {
    	BackEndAdministrator.navigates_to_room_module();
    }

//Samples1
    
//  @And("Should be able to add new room '(.*)'")
//  public void Add_new_room(String room) {
//  	//BackEndAdministrator.adds_new_room(room);
//  	//BackEndAdministrator.should_see_room_in_the_list(room);
//  }      
    
//Scenario: Add new room
    
    @Given("No rooms are in the room list")
    public void Delete_all_rooms() {
    	//BackEndAdministrator.deletes_all_rooms();
    	//BackEndAdministrator.should_see_no_rooms_in_the_list();
    }
    
    @When("Back-end Administrator adds new room '(.*)'")
    public void When_BackEndAdministrator_adds_new_room(String room) {
    	//BackEndAdministrator.adds_new_room(room);
    }

    @Then("Back-end Administrator should see room '(.*)' in the room list")
    public void Then_BackEndAdministrator_should_see_room_in_the_list(String room) {
    	//BackEndAdministrator.should_see_room_in_the_list(room);
    }

//Scenario: Cancel adding new Room
    
    @When("Back-end Administrator cancels adding new room '(.*)'")
    public void When_BackEndAdministrator_cancels_adding_new_room(String room) {
    	//BackEndAdministrator.cancels_adding_new_room(room);
    }
    
//Scenario: Delete room
    
    @Given("'(.*)' room is in the room list")
    public void Given_room_is_in_the_room_list(String room) {
    	//BackEndAdministrator.adds_new_room(room);
    }
    
    @When("Back-end Administrator deletes room '(.*)'")
    public void When_BackEndAdministrator_deletes_new_room(String room) {
    	//BackEndAdministrator.deletes_room(room);
    }
    
    @Then("Back-end Administrator should not see room '(.*)' in the room list")
    public void Then_BackEndAdministrator_should__not_see_room_in_the_list(String room) {
    	//BackEndAdministrator.should_not_see_room_in_the_list(room);
    }
    
//Scenario: Edit room - General settings
    
    @When("Back-end Administrator edits room '(.*)' general settings")
    public void When_BackEndAdministrator_edits_room_general_settings(String room) {
    	//BackEndAdministrator.edits_room_default_settings(room);
    }
    
    @Then("Back-end Administrator should save room '(.*)' new settings")
    public void Then_BackEndAdministrator_should_save_room_new_settings(String room) {
    	//BackEndAdministrator.should_save_room_new_settings(room);
    }
    
//Scenario: Edit room - Language-specific settings
    
    @When("Back-end Administrator edits room '(.*)' language-specific settings")
    public void When_BackEndAdministrator_edits_room_language_specific_settings(String room) {
    	//BackEndAdministrator.edits_room_default_settings(room);
    }
    
}
