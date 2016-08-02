package Intelier.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/intelier/automation/automation-room/room")
public class LiveCMSModuleRooms extends PageObject {
    
	@FindBy(linkText="Add a Room")
    private WebElementFacade AddRoomLink;

	public void AddNewRoom(String string) {
		AddRoomLink.click();
	}

}