package Intelier.features.accommodation_rooms;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Intelier.steps.serenity.BackEndUserSteps;

@RunWith(SerenityRunner.class)
public class ManageRoomInformationStory {

    @Managed
    public WebDriver webdriver;

    @Steps
    public BackEndUserSteps vasya;

    @Issue("Test Case #1: Add a new room")
    @Test
    public void adding_new_room() {
    	vasya.navigates_to_start_page();
    	vasya.adds_new_room("test-room");
    	vasya.should_see_room_in_the_list("test-room");

    }

} 