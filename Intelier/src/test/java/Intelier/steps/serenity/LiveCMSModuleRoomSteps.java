package Intelier.steps.serenity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.LiveCMSModuleRoom;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.components.HtmlTable;
import net.thucydides.core.steps.ScenarioSteps;

public class LiveCMSModuleRoomSteps extends ScenarioSteps {

	LiveCMSModuleRoom ModuleRoom;

// -----------------------------------------------------------------------------------------------------------------
// TASKS
	
	@Step
    public void navigate_to_room_module() {
		ModuleRoom.open();
    }
	
	@Step
    public void add_new_room(String string) {
    	ModuleRoom.Add_a_room();
    	ModuleRoom.GeneralTab_InternalName(string);
    	ModuleRoom.Save_changes();
	}
    
    @Step
    public void delete_room(String string) {
    	ModuleRoom.Delete_room(string);
    	ModuleRoom.DeleteConfirmYes_BUTTON.click();
	}

    @Step
    public void delete_all_rooms() {
    	ModuleRoom.Delete_all_rooms();
	}
    
    @Step
	public void edit_room_default_settings(String string) {
		ModuleRoom.Edit_room(string);
		ModuleRoom.GeneralTab_Status("Active");
		ModuleRoom.GeneralTab_InternalName(string);
		ModuleRoom.GeneralTab_RoomCategory("suites");
		ModuleRoom.GeneralTab_FromRate("99");
		ModuleRoom.GeneralTab_SizeFrom("10");
		ModuleRoom.GeneralTab_SizeTo("20");
		ModuleRoom.GeneralTab_Unit("f");
		ModuleRoom.GeneralTab_AdultGuests(1);
		ModuleRoom.GeneralTab_ChildrenGuests(2);
		ModuleRoom.GeneralTab_AddAllAmenities();
		ModuleRoom.Save_changes();
	}
    
    @Step
	public void cancel_adding_new_room(String room) {
		//ModuleRoom.cancel_adding_new_room(string);
	}
    
 // -----------------------------------------------------------------------------------------------------------------
 // VERIFICATIONS    
    
    @Step
	public void should_see_room_in_the_list(String string) {
    	assertTrue(HtmlTable.rowsFrom(ModuleRoom.RoomsList_TABLE).toString().contains(string));
	}
    
    @Step
	public void should_not_see_room_in_the_list(String string) {
    	try {
	    	assertFalse(HtmlTable.rowsFrom(ModuleRoom.RoomsList_TABLE).toString().contains(string));
	    } catch (NoSuchElementException ex) {}
	}
    
    @Step
	public void should_see_no_rooms_in_the_list() {
    	try {	
	    	assertTrue(HtmlTable.rowsFrom(ModuleRoom.RoomsList_TABLE).isEmpty());
	    } catch (NoSuchElementException ex) {}
	}

    @Step
	public void should_save_room_new_settings(String string) {
    	assertTrue(HtmlTable.rowsFrom(ModuleRoom.RoomsList_TABLE).toString().contains(string));
		
	}


}