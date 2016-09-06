package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.components.HtmlTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;

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
		//clickLinkByHref("/intelier/automation/automation-room/room/delete/id/76");
//		HtmlTable table = HtmlTable.inTable(RoomsListTable);
//        Iterator<WebElement> RowElements = table.getRowElements().iterator();
//        while(RowElements.hasNext()) {
//        	WebElement row = RowElements.next();
//		    	if (row.getAttribute("data-name").contains(string)) {
//		    	}
//        }
		System.out.println("DeleteButton");
				
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("arguments[0].click();", DeleteButton);
		
		Actions action = new Actions(getDriver());
		//action.moveToElement(DeleteButton).perform();
		
		action.moveToElement(DeleteButton).moveToElement(DeleteButton2).click().perform();
		  
		
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		//action.moveToElement(DeleteButton2).click();
	

		//action.click(DeleteButton2).perform();
		
		//DeleteButton2.click();
		System.out.println("DeleteConfirmYesButton-click");
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