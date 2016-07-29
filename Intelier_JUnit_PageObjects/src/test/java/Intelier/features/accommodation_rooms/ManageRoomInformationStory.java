package Intelier.features.accommodation_rooms;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Intelier.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class ManageRoomInformationStory {

    @Managed
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Issue("#WIKI-1")
    @Test
    public void adding_new_room() {
        anna.navigates_to_start_page();
        anna.adds_new_room("test-room");
        anna.should_see_room_in_the_list("test-room");

    }

} 