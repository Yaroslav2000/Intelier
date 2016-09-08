package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.components.HtmlTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
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
public class LiveCMSModuleRoomsPage extends PageObject {
	
	@FindBy(linkText="Add a Room")
    private WebElementFacade AddRoomLink;
	
	@FindBy(name="internalName")
    private WebElementFacade General_InternalNameTextBox;
	
	@FindBy(id="save_button-save")
    private WebElementFacade General_SaveButton;
	
	@FindBy(className="list")
    private WebElementFacade RoomsListTable;
	
    @FindBy(css="div[class='button-container']")
    private WebElementFacade DeleteButton;
    
    @FindBy(xpath="//a[@class='delete']")
    private WebElementFacade DeleteButton2;
    
    @FindBy(css="input[name='Yes']")
    private WebElementFacade DeleteConfirmYesButton;
	
    public void add_new_room(String string) {
		AddRoomLink.click();
		General_InternalNameTextBox.type(string);
		General_SaveButton.click();
	}
	
	public void delete_room(String string) {   
		HtmlTable table = HtmlTable.inTable(RoomsListTable);
        Iterator<WebElement> RowElements = table.getRowElements().iterator();
        while(RowElements.hasNext()) {
        	WebElement row = RowElements.next();
		    	if (row.getAttribute("data-name").contains(string)) {
		    		//System.out.println("before");
		    		open("delete.room", withParameters(row.getAttribute("data-id")));
		    		//System.out.println("after");
		    		//break;
		    	}
        }
		
		//Actions action = new Actions(getDriver());
		//action.moveToElement(DeleteButton).perform();
		//DeleteButton2.click();

		DeleteConfirmYesButton.click();   
	}

	public void should_see_room_in_the_list(String string) {
		assertTrue(HtmlTable.rowsFrom(RoomsListTable).toString().contains(string));
	}
	
	public void should_not_see_room_in_the_list(String string) {
	    try {
	    	assertFalse(HtmlTable.rowsFrom(RoomsListTable).toString().contains(string));
	    } catch (NoSuchElementException ex) {}
	}

}