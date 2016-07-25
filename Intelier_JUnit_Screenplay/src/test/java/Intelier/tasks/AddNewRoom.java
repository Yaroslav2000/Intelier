package Intelier.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import Intelier.ui.LiveCMSModuleRooms;

public class AddNewRoom implements Task {
 
    private final String internalName;

    protected AddNewRoom(String internalName) {
        this.internalName = internalName;
    }
    
    @Step("Add a room #internalName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
//TO DO
        );
    }
    
	public static Performable WithInternalName(String internalName) {
		return instrumented(AddNewRoom.class, internalName);
	}

	
}