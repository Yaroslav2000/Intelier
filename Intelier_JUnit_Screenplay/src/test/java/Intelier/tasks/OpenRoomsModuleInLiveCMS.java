package Intelier.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import Intelier.ui.LiveCMSModuleRooms;

public class OpenRoomsModuleInLiveCMS implements Task {

	LiveCMSModuleRooms liveCMSModuleRooms;

    @Step("Open Rooms Module in LiveCMS")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(liveCMSModuleRooms)
        );
    }
}