package Intelier.steps;

import net.thucydides.core.annotations.Steps;

import org.junit.Test;

import Intelier.steps.serenity.LiveCMSGenericSteps;
import Intelier.steps.serenity.LiveCMSModuleRoomSteps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class LiveCMSModuleRoomDefinitionSteps {

    @Steps
    LiveCMSModuleRoomSteps BackEndAdministrator;
    
    @Steps
    LiveCMSGenericSteps LiveCMS;

    @Before
    public void LiveCMS_setup() {
    	LiveCMS.setup();
    }
    
//    @After
//    public void LiveCMS_exit() {
//    	LiveCMS.teardown();
//    }
    
//    @And("Adds new room '(.*)'")
//    public void Adds_new_room(String room) {
//    	//When
//    	BackEndAdministrator.adds_new_room(room);
//    	//Then
//    	BackEndAdministrator.should_see_room_in_the_list(room);
//    }
//    
//    @And("Edits room '(.*)' with default settings'")
//    public void Edits_room_default_settings(String room) {
//    	//When
//    	BackEndAdministrator.edits_room_default_settings(room);
//    	//Then
//    	BackEndAdministrator.should_save_room_new_settings(room);
//    }
//    
//    @And("Deletes room '(.*)'")
//    public void Deletes_room(String room) {
//    	//When
//    	BackEndAdministrator.deletes_room(room);
//    	//Then
//    	BackEndAdministrator.should_not_see_room_in_the_list(room);
//    }    
    
    @Given("BackEnd Administrator navigates to Room module")
    public void Given_BackEndAdministrator_navigates_to_room_module() {
    	BackEndAdministrator.navigates_to_room_module();
    }

    @When("BackEnd Administrator adds new room '(.*)'")
    public void When_BackEndAdministrator_adds_new_room(String room) {
    	BackEndAdministrator.adds_new_room(room);
    }

    @Then("BackEnd Administrator should see room '(.*)' in the room list table")
    public void Then_BackEndAdministrator_should_see_room_in_the_list(String room) {
    	BackEndAdministrator.should_see_room_in_the_list(room);
    }

    @When("BackEnd Administrator deletes room '(.*)'")
    public void When_BackEndAdministrator_deletes_new_room(String room) {
    	BackEndAdministrator.deletes_room(room);
    }
    
    @Then("BackEnd Administrator should not see room '(.*)' in the room list table")
    public void Then_BackEndAdministrator_should__not_see_room_in_the_list(String room) {
    	BackEndAdministrator.should_not_see_room_in_the_list(room);
    }
    
    @When("BackEnd Administrator edits room '(.*)' with default settings")
    public void When_BackEndAdministrator_edits_room_default_settings(String room) {
    	BackEndAdministrator.edits_room_default_settings(room);
    }
    
    @Then("BackEnd Administrator should save room '(.*)' new settings")
    public void Then_BackEndAdministrator_should_save_room_new_settings(String room) {
    	BackEndAdministrator.should_save_room_new_settings(room);
    }
}
