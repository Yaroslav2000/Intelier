package Intelier.steps.serenity;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.FrontEndModuleRoomPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FrontEndModuleRoomSteps extends ScenarioSteps {
	
	FrontEndModuleRoomPage FrontendModuleRoom;

// -----------------------------------------------------------------------------------------------------------------
// COMMON
	
	@Step
    public void openFE() {
		FrontendModuleRoom.open();
    }
	
    @Step
	public void open_vanity_URL(String string) {
		FrontendModuleRoom.Open_VanityURL(string);		
	}
	
// -----------------------------------------------------------------------------------------------------------------
// VERIFICATIONS 	
	
    @Step
	public void should_see_FE_room_in_the_list(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_RoomsList);
    		assertTrue(FrontendModuleRoom.FE_RoomsList.containsText(string));
    	} catch (NoSuchElementException ex) {}
	}

	@Step
	public void should_see_FE_Room_Name(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_Room_Name);
    		assertTrue(FrontendModuleRoom.FE_Room_Name.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_FE_RoomCategory(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_RoomCategory);
    		assertTrue(FrontendModuleRoom.FE_RoomCategory.containsText(string));
    	} catch (NoSuchElementException ex) {}			
	}

    @Step
	public void should_see_FE_FromRate(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_FromRate);
    		assertTrue(FrontendModuleRoom.FE_FromRate.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_FE_SizeFrom(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_Size_Unit);
    		assertTrue(FrontendModuleRoom.FE_Size_Unit.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_FE_SizeTo(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_Size_Unit);
    		assertTrue(FrontendModuleRoom.FE_Size_Unit.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_FE_Unit(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_Size_Unit);
    		if (string == "m²") {
    			assertTrue(FrontendModuleRoom.FE_Size_Unit.containsText("m"));
    		} else if (string == "ft²") {
    			assertTrue(FrontendModuleRoom.FE_Size_Unit.containsText("f"));
    		}
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_FE_Headline(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_Headline);
    		assertTrue(FrontendModuleRoom.FE_Headline.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_FE_Description(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_Description);
    		assertTrue(FrontendModuleRoom.FE_Description.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_FE_BedTypes(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_BedTypes);
    		assertTrue(FrontendModuleRoom.FE_BedTypes.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_FE_Features(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_Features);
    		assertTrue(FrontendModuleRoom.FE_Features.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_FE_Notes(String string) {
    	try {
    		FrontendModuleRoom.MoveToElement(FrontendModuleRoom.FE_Notes);
    		assertTrue(FrontendModuleRoom.FE_Notes.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

}
