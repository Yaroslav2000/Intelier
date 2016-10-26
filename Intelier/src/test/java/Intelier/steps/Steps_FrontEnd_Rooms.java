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
    		FE.moveToElement(FE.FE_RoomsList);
    		assertTrue(FE.FE_RoomsList.containsText(string));
    	} catch (NoSuchElementException ex) {}
	}

	@Step
	public void should_see_Room_Name(String string) {
    	try {
    		FE.moveToElement(FE.FE_Room_Name);
    		assertTrue(FE.FE_Room_Name.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_RoomCategory(String string) {
    	try {
    		FE.moveToElement(FE.FE_RoomCategory);
    		assertTrue(FE.FE_RoomCategory.containsText(string));
    	} catch (NoSuchElementException ex) {}			
	}

    @Step
	public void should_see_FromRate(String string) {
    	try {
    		FE.moveToElement(FE.FE_FromRate);
    		assertTrue(FE.FE_FromRate.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_SizeFrom(String string) {
    	try {
    		FE.moveToElement(FE.FE_Size_Unit);
    		assertTrue(FE.FE_Size_Unit.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_SizeTo(String string) {
    	try {
    		FE.moveToElement(FE.FE_Size_Unit);
    		assertTrue(FE.FE_Size_Unit.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Unit(String string) {
    	try {
    		FE.moveToElement(FE.FE_Size_Unit);
    		if (string.equals("m²")) {
    			assertTrue(FE.FE_Size_Unit.containsText("m"));
    		} else if (string.equals("ft²")) {
    			assertTrue(FE.FE_Size_Unit.containsText("f"));
    		}
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Headline(String string) {
    	try {
    		FE.moveToElement(FE.FE_Headline);
    		assertTrue(FE.FE_Headline.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Description(String string) {
    	try {
    		FE.moveToElement(FE.FE_Description);
    		assertTrue(FE.FE_Description.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_BedTypes(String string) {
    	try {
    		FE.moveToElement(FE.FE_BedTypes);
    		assertTrue(FE.FE_BedTypes.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Features(String string) {
    	try {
    		FE.moveToElement(FE.FE_Features);
    		assertTrue(FE.FE_Features.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

    @Step
	public void should_see_Notes(String string) {
    	try {
    		FE.moveToElement(FE.FE_Notes);
    		assertTrue(FE.FE_Notes.containsText(string));
    	} catch (NoSuchElementException ex) {}	
	}

}
