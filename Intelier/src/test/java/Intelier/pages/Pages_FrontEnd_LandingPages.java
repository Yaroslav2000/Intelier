package Intelier.pages;

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
	
	
	
// -----------------------------------------------------------------------------------------------------------------
// ACTIONS	
		
	public void open_vanity_URL(String string) {
		open("open.vanityURL", withParameters(string));
	}
	
}
