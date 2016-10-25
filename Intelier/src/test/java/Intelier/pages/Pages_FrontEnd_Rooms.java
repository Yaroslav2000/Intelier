package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://www.lps.local-qa.dev.webcanada.com/43/en/rooms")
@NamedUrls(
		  {
		    @NamedUrl(name = "open.vanityURL", url = "/{1}"),
		  }
)
public class Pages_FrontEnd_Rooms extends PageObject {

// -----------------------------------------------------------------------------------------------------------------
// LOCATORS
	
	@FindBy(xpath="//*[@class = 'guest-room-features grid__12']") public WebElementFacade FE_RoomsList;
	@FindBy(xpath="//*[@class = 'grid__12']") public WebElementFacade FE_Room_Name;
	@FindBy(xpath="//*[@class = 'room-breadcrumb grid__12']") public WebElementFacade FE_RoomCategory;	
	@FindBy(xpath="//*[@class = 'room-price']") public WebElementFacade FE_FromRate;
	@FindBy(xpath="//*[@class = 'grid__4 grid__4--first'][1]") public WebElementFacade FE_BedTypes;
	@FindBy(xpath="//*[@class = 'grid__4 grid__4--first'][2]") public WebElementFacade FE_Guests;
	@FindBy(xpath="//*[@class = 'grid__4 grid__4--first'][3]") public WebElementFacade FE_Size_Unit;
	@FindBy(xpath="//*[@class = 'heading4']") public WebElementFacade FE_Headline;
	@FindBy(xpath="//*[@class = 'room-description']") public WebElementFacade FE_Description;
	@FindBy(xpath="//*[@class = 'room-feature grid']") public WebElementFacade FE_Features;
	@FindBy(xpath="//*[@class = 'grid__10']") public WebElementFacade FE_Notes;

	
// -----------------------------------------------------------------------------------------------------------------
// ACTIONS	
	
	public void open_vanity_URL(String string) {
		open("open.vanityURL", withParameters(string));
	}
	
	public void moveToElement(WebElementFacade WebElementFacade) {
		withAction().moveToElement(WebElementFacade).perform();
	}
	
}


