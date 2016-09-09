package Intelier.features.accommodation_rooms;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import Intelier.steps.serenity.BackEndAdministratorGeneric;
import Intelier.steps.serenity.BackEndAdministratorModuleRoom;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManageRoomInformationStory {

	@Managed
    public WebDriver webdriver;

    @Steps
    public BackEndAdministratorGeneric BackEndAdministratorGeneric;
    
    @Steps
    public BackEndAdministratorModuleRoom BackEndAdministratorModuleRoom;

    @Before
    public void LiveCMS_setup() {
    	BackEndAdministratorGeneric.opens_LiveCMS();
    	//Given
    	BackEndAdministratorModuleRoom.navigates_to_room_module();
    }
    
    @After
    public void LiveCMS_exit() {
    	BackEndAdministratorGeneric.closes_LiveCMS();
    }
         
	//Test Data Setup
    String TestRoomName = "AutomationRoom";
    
//    @Test
//    public void Test_Case_001_add_new_room() {
//    	//When
//    	BackEndAdministrator.adds_new_room(TestRoomName);
//    	//Then
//    	BackEndAdministrator.should_see_room_in_the_list(TestRoomName);
//    }
//
//    @Test
//    public void Test_Case_002_edit_room() {
////TO-DO
//    }
//    
//    @Test
//    public void Test_Case_003_delete_room() {
//    	//When
//    	BackEndAdministrator.deletes_room(TestRoomName);
//    	//Then
//    	BackEndAdministrator.should_not_see_room_in_the_list(TestRoomName);
//    }
    
    @Test
    public void delete_all_rooms() {
    	//When
    	BackEndAdministratorModuleRoom.deletes_all_rooms();
    	//Then
    	BackEndAdministratorModuleRoom.should_see_no_rooms_in_the_list();
    }
    
} 