package Intelier.features.accommodation_rooms;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Intelier.tasks.AddNewRoom;
import Intelier.tasks.OpenRoomsModuleInLiveCMS;
import Intelier.tasks.OpenTheApplication;
import Intelier.tasks.Search;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class ManageRoomInformation {

    Actor vasya = Actor.named("Vasya");

    @Managed(uniqueSession = true)
    public WebDriver hisBrowser;

    @Steps
    OpenRoomsModuleInLiveCMS openRoomsModuleInLiveCMS;

    @Before
    public void VasyaCanBrowseTheWeb() {
        vasya.can(BrowseTheWeb.with(hisBrowser));
    }
  
    @Test
    public void add_new_room() {

        givenThat(vasya).wasAbleTo(openRoomsModuleInLiveCMS);

        when(vasya).attemptsTo(AddNewRoom.WithInternalName("SeleniumNewRoom"));

        then(vasya).should(eventually(seeThat(RoomsPageList.ContainsRoom("SeleniumNewRoom"))));
        
    }
}