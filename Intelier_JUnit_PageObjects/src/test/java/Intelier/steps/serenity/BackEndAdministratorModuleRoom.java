package Intelier.steps.serenity;

import Intelier.pages.LiveCMSModuleRooms;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class BackEndAdministratorModuleRoom extends ScenarioSteps {

	LiveCMSModuleRooms liveCMSModuleRooms;
	
	@Step
    public void navigates_to_room_module() {
    	liveCMSModuleRooms.open();
    }

    @Step
    public void adds_new_room(String string) {
    	liveCMSModuleRooms.add_new_room(string);
	}
    
    @Step
    public void deletes_room(String string) {
    	liveCMSModuleRooms.delete_room(string);
	}

    @Step
	public void should_see_room_in_the_list(String string) {
		liveCMSModuleRooms.should_see_room_in_the_list(string);
	}
    
    @Step
	public void should_not_see_room_in_the_list(String string) {
		liveCMSModuleRooms.should_not_see_room_in_the_list(string);
	}
    
    @Step
    public void deletes_all_rooms() {
    	liveCMSModuleRooms.delete_all_rooms();
	}
    
    @Step
	public void should_see_no_rooms_in_the_list() {
		liveCMSModuleRooms.should_see_no_rooms_in_the_list();
	}
}