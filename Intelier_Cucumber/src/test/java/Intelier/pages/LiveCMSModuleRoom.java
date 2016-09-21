package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.components.HtmlTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.Pages;
import static net.thucydides.core.pages.PageObject.withParameters;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.mockito.BDDMockito.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.NoSuchElementException;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room/room")
@NamedUrls(
		  {
		    @NamedUrl(name = "delete.room", url = "http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room/room/delete/id/{1}"),
		    @NamedUrl(name = "edit.room", url = "http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room/room/edit/id/{1}")
		  }
)
public class LiveCMSModuleRoom extends PageObject {
	
    // -----------------------------------------------------------------------------------------------------------------
    // LOCATORS
	
	@FindBy(linkText="Add a Room")
    private WebElementFacade AddRoom_LINK;
	
	@FindBy(className="list")
    private WebElementFacade RoomsList_TABLE;
	
    @FindBy(css="[data-id]")
    private WebElementFacade FirstRoom_ROW;

    @FindBy(xpath="//a[@class='delete']")
    private WebElementFacade Delete_BUTTON;
    
    @FindBy(css="input[name='Yes']")
    private WebElementFacade DeleteConfirmYes_BUTTON;
    
	@FindBy(id="isActive-1")
    private WebElementFacade General_Active_RADIOBUTTON;
    
    @FindBy(name="internalName")
    private WebElementFacade General_InternalName_TEXTBOX;
	
	@FindBy(name="category")
    private WebElementFacade General_RoomCategory_DROPDOWN;
    
	@FindBy(name="fromRate")
    private WebElementFacade General_FromRate_TEXTBOX;

	@FindBy(id="size_from")
    private WebElementFacade General_SizeFrom_TEXTBOX;
	
	@FindBy(id="size_to")
    private WebElementFacade General_SizeTo_TEXTBOX;
	
    @FindBy(css="select[name='unit']")
    private WebElementFacade General_Unit_DROPDOWN;
	
	@FindBy(name="numOfGuest[0][adults]")
    private WebElementFacade General_AdultGuests_DROPDOWN;
	
	@FindBy(name="numOfGuest[0][children]")
    private WebElementFacade General_ChildrenGuests_DROPDOWN;
			
	@FindBy(className="add-all")
    private WebElementFacade General_AddAllAmenities_BUTTON;
	
    @FindBy(id="save_button-save")
    private WebElementFacade General_Save_BUTTON;
	
	
    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    
    public void add_new_room(String string) {
    	AddRoom_LINK.click();
    	General_InternalName_TEXTBOX.type(string);
    	General_Save_BUTTON.click();
	}
	
	public void delete_room(String string) {   
		HtmlTable table = HtmlTable.inTable(RoomsList_TABLE);
        Iterator<WebElement> RowElements = table.getRowElements().iterator();
        while(RowElements.hasNext()) {
        	WebElement row = RowElements.next();
		    	if (row.getAttribute("data-name").contains(string)) {
		    		open("delete.room", withParameters(row.getAttribute("data-id")));
		    	}
        }
        DeleteConfirmYes_BUTTON.click();   
	}
	
	public void delete_all_rooms() {   
	    try {
	    	HtmlTable table = HtmlTable.inTable(RoomsList_TABLE);
	        Iterator<WebElement> RowElements = table.getRowElements().iterator();
	        while(RowElements.hasNext()) {
	        	FirstRoom_ROW.click();
	        	Delete_BUTTON.click();
	        	DeleteConfirmYes_BUTTON.click();       	
	        }
	    } catch (NoSuchElementException ex) {}
	}
	
	public void edit_room_default_settings(String string) {
		HtmlTable table = HtmlTable.inTable(RoomsList_TABLE);
        Iterator<WebElement> RowElements = table.getRowElements().iterator();
        while(RowElements.hasNext()) {
        	WebElement row = RowElements.next();
		    	if (row.getAttribute("data-name").contains(string)) {
		    		open("edit.room", withParameters(row.getAttribute("data-id")));
		    	}
        }
        General_Active_RADIOBUTTON.click();
        General_RoomCategory_DROPDOWN.selectByValue("suites");
        General_FromRate_TEXTBOX.type("99");
        General_SizeFrom_TEXTBOX.type("10");
        General_SizeTo_TEXTBOX.type("20");
        General_Unit_DROPDOWN.selectByValue("f");
        General_AdultGuests_DROPDOWN.selectByIndex(1);
        General_ChildrenGuests_DROPDOWN.selectByIndex(2);
        General_AddAllAmenities_BUTTON.click();
    	General_Save_BUTTON.click();
	}

    // -----------------------------------------------------------------------------------------------------------------
    // VERIFICATIONS
	
	public void should_see_room_in_the_list(String string) {
		assertTrue(HtmlTable.rowsFrom(RoomsList_TABLE).toString().contains(string));
	}
	
	public void should_not_see_room_in_the_list(String string) {
	    try {
	    	assertFalse(HtmlTable.rowsFrom(RoomsList_TABLE).toString().contains(string));
	    } catch (NoSuchElementException ex) {}
	}
	
	public void should_see_no_rooms_in_the_list() {
	    try {	
	    	assertTrue(HtmlTable.rowsFrom(RoomsList_TABLE).isEmpty());
	    } catch (NoSuchElementException ex) {}
	}

	public void should_save_room_new_settings(String string) {
		assertTrue(HtmlTable.rowsFrom(RoomsList_TABLE).toString().contains(string));
	}

}