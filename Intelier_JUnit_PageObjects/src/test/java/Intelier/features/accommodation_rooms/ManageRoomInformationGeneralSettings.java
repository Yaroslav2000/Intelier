//Manage Room Information - General Settings (INTELIER-41)

package Intelier.features.accommodation_rooms;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import Intelier.steps.serenity.LiveCMSGenericSteps;
import Intelier.steps.serenity.LiveCMSModuleRoomSteps;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManageRoomInformationGeneralSettings {

	@Managed
    public WebDriver webdriver;

    @Steps
    public LiveCMSGenericSteps LiveCMS;

    @Steps
    public LiveCMSModuleRoomSteps BackEndAdministrator;

    @Before
    public void LiveCMS_setup() {
    	LiveCMS.setup();
    	//Given (Preconditions)
    	BackEndAdministrator.navigates_to_room_module();
    }
    
    @After
    public void LiveCMS_exit() {
    	LiveCMS.teardown();
    }
         
	//Test Data Setup
    String TestRoomName = "AutomationRoom";
    
//    @Test
//    public void delete_all_rooms() {
//    	BackEndAdministrator.deletes_all_rooms();
//    	BackEndAdministrator.should_see_no_rooms_in_the_list();
//    }
    
    @Test
    @Title("Add new room")
    public void Test_Case_001_add_new_room() {
    	//When (Actions)
    	BackEndAdministrator.adds_new_room(TestRoomName);
    	//Then (Expected Result)
    	BackEndAdministrator.should_see_room_in_the_list(TestRoomName);
    }

    @Test
    @Title("Edit new room with default settings")
    public void Test_Case_002_edit_room_default_settings() {
    	//When (Actions)
    	BackEndAdministrator.edits_room_default_settings(TestRoomName);
    	//Then (Expected Result)
    	BackEndAdministrator.should_save_room_new_settings(TestRoomName);
    }
    
    @Test
    @Title("Delete new room")
    public void Test_Case_003_delete_room() {
    	//When (Actions)
    	BackEndAdministrator.deletes_room(TestRoomName);
    	//Then (Expected Result)
    	BackEndAdministrator.should_not_see_room_in_the_list(TestRoomName);
    }
    
} 