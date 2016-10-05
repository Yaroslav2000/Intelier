package Intelier.steps.serenity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.LiveCMSModuleRoom;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.components.HtmlTable;
import net.thucydides.core.steps.ScenarioSteps;

public class LiveCMSModuleRoomSteps extends ScenarioSteps {

	LiveCMSModuleRoom liveCMSModuleRoom;

// -----------------------------------------------------------------------------------------------------------------
// TASKS
	
	@Step
    public void navigate_to_room_module() {
		liveCMSModuleRoom.open();
    }

    @Step
    public void add_new_room(String string) {
    	liveCMSModuleRoom.add_new_room(string);
	}
    
    @Step
    public void delete_room(String string) {
    	liveCMSModuleRoom.delete_room(string);
	}

    @Step
    public void delete_all_rooms() {
    	liveCMSModuleRoom.delete_all_rooms();
	}
    
    @Step
	public void edit_room_default_settings(String string) {
		liveCMSModuleRoom.edit_room_default_settings(string);
	}
    
    @Step
	public void cancel_adding_new_room(String room) {
		//liveCMSModuleRoom.cancel_adding_new_room(string);
	}
    
 // -----------------------------------------------------------------------------------------------------------------
 // VERIFICATIONS    
    
    @Step
	public void should_see_room_in_the_list(String string) {
    	assertTrue(HtmlTable.rowsFrom(liveCMSModuleRoom.RoomsList_TABLE).toString().contains(string));
	}
    
    @Step
	public void should_not_see_room_in_the_list(String string) {
    	try {
	    	assertFalse(HtmlTable.rowsFrom(liveCMSModuleRoom.RoomsList_TABLE).toString().contains(string));
	    } catch (NoSuchElementException ex) {}
	}
    
    @Step
	public void should_see_no_rooms_in_the_list() {
    	try {	
	    	assertTrue(HtmlTable.rowsFrom(liveCMSModuleRoom.RoomsList_TABLE).isEmpty());
	    } catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_save_room_new_settings(String string) {
    	assertTrue(HtmlTable.rowsFrom(liveCMSModuleRoom.RoomsList_TABLE).toString().contains(string));
		
	}


}