package Intelier.steps.serenity;

import Intelier.pages.LiveCMSModuleRoomsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class BackEndAdministratorSteps_ModuleRooms extends ScenarioSteps {

	LiveCMSModuleRoomsPage liveCMSModuleRooms;
	
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
}