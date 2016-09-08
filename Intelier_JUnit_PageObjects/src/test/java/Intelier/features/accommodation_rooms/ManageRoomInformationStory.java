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
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import Intelier.steps.serenity.BackEndAdministratorSteps_LiveCMS;
import Intelier.steps.serenity.BackEndAdministratorSteps_ModuleRooms;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManageRoomInformationStory {

	//Test Data Setup
    String TestRoomName = "AutomationRoom";
    //private static boolean FirstTest = true;
    //private static boolean LastTest = false;

	@Managed
    public WebDriver webdriver;

    @Steps
    public BackEndAdministratorSteps_LiveCMS BackEndAuthenticator;
    
    @Steps
    public BackEndAdministratorSteps_ModuleRooms BackEndAdministrator;

    @Before
    public void LiveCMS_setup() {
    	//Given
    	//if (FirstTest) 
    	//{
    		BackEndAuthenticator.opens_LiveCMS();
    		//FirstTest = false;
    	//}
    	BackEndAdministrator.navigates_to_room_module();
    }
    
    @After
    public void LiveCMS_exit() {
    	//if (LastTest) 
    	//{
    		BackEndAuthenticator.closes_LiveCMS();
    	//}
    }
         
    @Test
    public void Test_Case_001_add_new_room() {
    	//When
    	BackEndAdministrator.adds_new_room(TestRoomName);
    	//Then
    	BackEndAdministrator.should_see_room_in_the_list(TestRoomName);
    }

    @Test
    public void Test_Case_002_edit_room() {
//TO-DO
    }
    
    @Test
    public void Test_Case_003_delete_room() {
    	//When
    	BackEndAdministrator.deletes_room(TestRoomName);
    	//Then
    	BackEndAdministrator.should_not_see_room_in_the_list(TestRoomName);
    	//LastTest=true;
    }
    
} 