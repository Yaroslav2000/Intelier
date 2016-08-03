package Intelier.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.components.HtmlTable;
import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;
import static net.thucydides.core.pages.components.HtmlTable.filterRows;

import net.thucydides.core.pages.PageObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room/room")
public class LiveCMSModuleRooms extends PageObject {
	
	@FindBy(linkText="Add a Room")
    private WebElementFacade AddRoomLink;
	
	@FindBy(name="internalName")
    private WebElementFacade General_InternalNameTextBox;
	
	@FindBy(id="save_button-save")
    private WebElementFacade General_SaveButton;
	
	@FindBy(id="sortable")
    private WebElementFacade RoomsList;
	
	@FindBy(className="list")
    private WebElementFacade RoomsResultTable;
//	WebElement RoomsResultTable;

	public void add_new_room(String string) {
//		AddRoomLink.withTimeoutOf(600,TimeUnit.SECONDS).waitUntilNotVisible().click();
		AddRoomLink.click();
		General_InternalNameTextBox.type(string);
		General_SaveButton.click();
	}

	public List<Map<Object, String>> displayedRooms() {
        return rowsFrom(RoomsResultTable);
    }
	
	public void should_see_room_in_the_list(String string) {
		displayedRooms().get(2);
		displayedRooms();
		//SearchResultsPage();
		
	}

}