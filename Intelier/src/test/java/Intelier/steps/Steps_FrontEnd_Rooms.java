package Intelier.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import Intelier.pages.Pages_CustomActions;
import Intelier.pages.Pages_FrontEnd_Rooms;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class Steps_FrontEnd_Rooms extends ScenarioSteps {
	
	Pages_FrontEnd_Rooms FE;
	Pages_CustomActions Custom;

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
    		assertTrue(FE.RoomsList.containsText(string));
    		Custom.moveToElement(FE.RoomsList);
    	} catch (NoSuchElementException ex) {}
	}

	@Step
	public void should_see_Room_Name(String string) {
    	try {
    		assertTrue(FE.Room_Name.containsText(string));
    		Custom.moveToElement(FE.Room_Name);
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_RoomCategory(String string) {
    	try {
    		assertTrue(FE.RoomCategory.containsText(string));
    		Custom.moveToElement(FE.RoomCategory);
    	} catch (NoSuchElementException ex) {}			
	}

    @Step
	public void should_see_FromRate(String string) {
    	try {
    		assertTrue(FE.FromRate.containsText(string));
    		Custom.moveToElement(FE.FromRate);
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_SizeFrom(String string) {
    	try {
    		assertTrue(FE.Size_Unit.containsText(string));
    		Custom.moveToElement(FE.Size_Unit);
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_SizeTo(String string) {
    	try {
    		assertTrue(FE.Size_Unit.containsText(string));
    		Custom.moveToElement(FE.Size_Unit);
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Unit(String string) {
    	try {
    		Custom.moveToElement(FE.Size_Unit);
    	} catch (NoSuchElementException ex) {}	
    	try {
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
    		assertTrue(FE.Headline.containsText(string));
    		Custom.moveToElement(FE.Headline);
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Description(String string) {
    	try {
    		assertTrue(FE.Description.containsText(string));
    		Custom.moveToElement(FE.Description);
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_BedTypes(String string) {
    	try {
    		assertTrue(FE.BedTypes.containsText(string));
    		Custom.moveToElement(FE.BedTypes);
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Features(String string) {
    	try {
    		assertTrue(FE.Features.containsText(string));
    		Custom.moveToElement(FE.Features);
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Notes(String string) {
    	try {
    		assertTrue(FE.Notes.containsText(string));
    		Custom.moveToElement(FE.Notes);
    	} catch (NoSuchElementException ex) {}	
	}

}
