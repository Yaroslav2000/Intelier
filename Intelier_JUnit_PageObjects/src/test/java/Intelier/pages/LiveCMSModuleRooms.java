package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.components.HtmlTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import static org.junit.Assert.assertTrue;


@DefaultUrl("http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room/room")
public class LiveCMSModuleRooms extends PageObject {
	
	@FindBy(linkText="Add a Room")
    private WebElementFacade AddRoomLink;
	
	@FindBy(name="internalName")
    private WebElementFacade General_InternalNameTextBox;
	
	@FindBy(id="save_button-save")
    private WebElementFacade General_SaveButton;
	
	@FindBy(className="list")
    private WebElementFacade RoomsListTable;
	
	public void add_new_room(String string) {
		AddRoomLink.click();
		General_InternalNameTextBox.type(string);
		General_SaveButton.click();
	}

	public void should_see_room_in_the_list(String string) {
		assertTrue(HtmlTable.rowsFrom(RoomsListTable).toString().contains(string));
	}

}