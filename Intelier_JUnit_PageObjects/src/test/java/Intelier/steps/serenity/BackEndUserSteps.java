package Intelier.steps.serenity;

import Intelier.pages.LiveCMSModuleRooms;
import Intelier.pages.LiveCMS;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class BackEndUserSteps extends ScenarioSteps {

	LiveCMSModuleRooms liveCMSModuleRooms;
	LiveCMS liveCMS;

	@Step
    public void opens_LiveCMS() {
    	liveCMS.open();
    	liveCMS.login();
    }
	
	@Step
    public void closes_LiveCMS() {
    	liveCMS.logout();
    }
	
	@Step
    public void navigates_to_room_module() {
    	liveCMSModuleRooms.open();
    }

    @Step
    public void adds_new_room(String string) {
    	liveCMSModuleRooms.add_new_room(string);
	}

	public void should_see_room_in_the_list(String string) {
		liveCMSModuleRooms.should_see_room_in_the_list(string);
	}
}