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
	
	@FindBy(xpath="//*[@class='guest-room-features grid__12']") public WebElementFacade RoomsList;
	@FindBy(xpath="//*[@class='grid__12']") public WebElementFacade Room_Name;
	@FindBy(xpath="//*[@class='room-breadcrumb grid__12']") public WebElementFacade RoomCategory;	
	@FindBy(xpath="//*[@class='room-price']") public WebElementFacade FromRate;
	@FindBy(xpath="//*[@class='grid__4 grid__4--first'][1]") public WebElementFacade BedTypes;
	@FindBy(xpath="//*[@class='grid__4 grid__4--first'][2]") public WebElementFacade Guests;
	@FindBy(xpath="//*[@class='grid__4 grid__4--first'][3]") public WebElementFacade Size_Unit;
	@FindBy(xpath="//*[@class='heading4']") public WebElementFacade Headline;
	@FindBy(xpath="//*[@class='room-description']") public WebElementFacade Description;
	@FindBy(xpath="//*[@class='room-feature grid']") public WebElementFacade Features;
	@FindBy(xpath="//*[@class='grid__10']") public WebElementFacade Notes;

	
// -----------------------------------------------------------------------------------------------------------------
// ACTIONS	
	
	public void open_vanity_URL(String string) {
		open("open.vanityURL", withParameters(string));
	}
	
}


