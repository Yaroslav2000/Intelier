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

import Intelier.steps.serenity.BackEndUserSteps;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManageRoomInformationStory {

    @Managed
    public WebDriver webdriver;

    @Steps
    public BackEndUserSteps vasya;

    @Before
    public void LiveCMS_setup() {
    	vasya.opens_LiveCMS();
    	vasya.navigates_to_room_module();
    }
    
    @After
    public void LiveCMS_exit() {
    	vasya.closes_LiveCMS();
    }
    
	String TestRoomName = "AutomationRoom";
     
//@Ignore
	@Issue("Test Case #001: Add new room")
    @Test
    public void Test_001_add_new_room() {
    	vasya.adds_new_room(TestRoomName);
    	vasya.should_see_room_in_the_list(TestRoomName);
    }

    @Issue("Test Case #002: Delete room")
    @Test
    public void Test_002_delete_room() {
    	//vasya.should_see_room_in_the_list(TestRoomName);
    	vasya.deletes_room(TestRoomName);
    	vasya.should_not_see_room_in_the_list(TestRoomName);
    }
    
} 