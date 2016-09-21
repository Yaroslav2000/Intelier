package Intelier.steps.serenity;

import Intelier.pages.LiveCMSModuleRoom;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LiveCMSModuleRoomSteps extends ScenarioSteps {

	LiveCMSModuleRoom liveCMSModuleRoom;
	
	@Step
    public void navigates_to_room_module() {
		liveCMSModuleRoom.open();
    }

    @Step
    public void adds_new_room(String string) {
    	liveCMSModuleRoom.add_new_room(string);
	}
    
    @Step
    public void deletes_room(String string) {
    	liveCMSModuleRoom.delete_room(string);
	}

    @Step
	public void should_see_room_in_the_list(String string) {
    	liveCMSModuleRoom.should_see_room_in_the_list(string);
	}
    
    @Step
	public void should_not_see_room_in_the_list(String string) {
    	liveCMSModuleRoom.should_not_see_room_in_the_list(string);
	}
    
    @Step
    public void deletes_all_rooms() {
    	liveCMSModuleRoom.delete_all_rooms();
	}
    
    @Step
	public void should_see_no_rooms_in_the_list() {
    	liveCMSModuleRoom.should_see_no_rooms_in_the_list();
	}

    @Step
	public void edits_room_default_settings(String string) {
		liveCMSModuleRoom.edit_room_default_settings(string);
		
	}

    @Step
	public void should_save_room_new_settings(String string) {
		liveCMSModuleRoom.should_save_room_new_settings(string);
		
	}

    @Step
	public void cancels_adding_new_room(String room) {
		//liveCMSModuleRoom.cancels_adding_new_room(string);
		
	}
}