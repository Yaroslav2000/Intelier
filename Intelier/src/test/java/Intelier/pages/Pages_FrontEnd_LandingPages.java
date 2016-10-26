package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://www.promo.plpsl.local-qa.dev.webcanada.com")
@NamedUrls(
		  {
		    @NamedUrl(name = "open.vanityURL", url = "/{1}"),
		  }
)
public class Pages_FrontEnd_LandingPages extends PageObject {

// -----------------------------------------------------------------------------------------------------------------
// LOCATORS
	
	@FindBy(xpath="//*[@class='page-headline grid__10--p1']") public WebElementFacade English_PageTitle;
	@FindBy(xpath="//*[@class='campaign-information grid__10--p1']") public WebElementFacade English_PageCopyHeadline;
	
	
// -----------------------------------------------------------------------------------------------------------------
// ACTIONS	
		
	public void open_vanity_URL(String string) {
		open("open.vanityURL", withParameters(string));
	}

	public void moveToElement(WebElementFacade WebElementFacade) {
		withAction().moveToElement(WebElementFacade).perform();
	}
	
}
