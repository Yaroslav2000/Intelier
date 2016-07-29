package Intelier.steps.serenity;

import Intelier.pages.LiveCMSModuleRooms;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

	LiveCMSModuleRooms liveCMSModuleRooms;

    @Step
    public void navigates_to_start_page() {
    	liveCMSModuleRooms.open();
    }

    @Step
    public void adds_new_room(String string) {
		// TODO Auto-generated method stub
		
	}

	public void should_see_room_in_the_list(String string) {
		// TODO Auto-generated method stub
		
	}
}