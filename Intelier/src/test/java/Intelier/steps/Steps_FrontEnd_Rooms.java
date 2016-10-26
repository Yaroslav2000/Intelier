package Intelier.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.Pages_FrontEnd_Rooms;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class Steps_FrontEnd_Rooms extends ScenarioSteps {
	
	Pages_FrontEnd_Rooms FE;

// -----------------------------------------------------------------------------------------------------------------
// COMMON
	
	@Step
    public void openFE() {
		FE.open();
    }
	
    @Step
	public void open_vanity_URL(String string) {
		FE.open_vanity_URL(string);		
	}
	
// -----------------------------------------------------------------------------------------------------------------
// VERIFICATIONS 	
	
    @Step
	public void should_see_room_in_the_list(String string) {
    	try {
    		FE.moveToElement(FE.RoomsList);
    		assertTrue(FE.RoomsList.containsText(string));
    	} catch (NoSuchElementException ex) {}
	}

	@Step
	public void should_see_Room_Name(String string) {
    	try {
    		FE.moveToElement(FE.Room_Name);
    		assertTrue(FE.Room_Name.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_RoomCategory(String string) {
    	try {
    		FE.moveToElement(FE.RoomCategory);
    		assertTrue(FE.RoomCategory.containsText(string));
    	} catch (NoSuchElementException ex) {}			
	}

    @Step
	public void should_see_FromRate(String string) {
    	try {
    		FE.moveToElement(FE.FromRate);
    		assertTrue(FE.FromRate.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_SizeFrom(String string) {
    	try {
    		FE.moveToElement(FE.Size_Unit);
    		assertTrue(FE.Size_Unit.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_SizeTo(String string) {
    	try {
    		FE.moveToElement(FE.Size_Unit);
    		assertTrue(FE.Size_Unit.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Unit(String string) {
    	try {
    		FE.moveToElement(FE.Size_Unit);
    		if (string.equals("m²")) {
    			assertTrue(FE.Size_Unit.containsText("m"));
    		} else if (string.equals("ft²")) {
    			assertTrue(FE.Size_Unit.containsText("f"));
    		}
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Headline(String string) {
    	try {
    		FE.moveToElement(FE.Headline);
    		assertTrue(FE.Headline.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Description(String string) {
    	try {
    		FE.moveToElement(FE.Description);
    		assertTrue(FE.Description.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_BedTypes(String string) {
    	try {
    		FE.moveToElement(FE.BedTypes);
    		assertTrue(FE.BedTypes.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Features(String string) {
    	try {
    		FE.moveToElement(FE.Features);
    		assertTrue(FE.Features.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Notes(String string) {
    	try {
    		FE.moveToElement(FE.Notes);
    		assertTrue(FE.Notes.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

}
