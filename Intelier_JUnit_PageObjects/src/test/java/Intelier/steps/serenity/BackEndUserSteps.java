package Intelier.steps.serenity;

import Intelier.pages.LiveCMSModuleRooms;
import Intelier.pages.LiveCMS;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class BackEndUserSteps extends ScenarioSteps {

	LiveCMSModuleRooms liveCMSModuleRooms;
	LiveCMS liveCMS;

    @Step
    public void navigates_to_start_page() {
    	liveCMS.open();
    	liveCMS.login();
    	liveCMSModuleRooms.open();
//    	liveCMS.logout();
    }

    @Step
    public void adds_new_room(String string) {
    	liveCMSModuleRooms.AddNewRoom(string);
	}

	public void should_see_room_in_the_list(String string) {
		// TODO Auto-generated method stub
		
	}
}