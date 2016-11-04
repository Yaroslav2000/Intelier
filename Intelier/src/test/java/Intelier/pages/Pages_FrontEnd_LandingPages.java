package Intelier.pages;

import java.util.List;

import org.openqa.selenium.By;

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
	
	@FindBy(xpath=".//*[@class='homepage-content-wrapper grid']") public WebElementFacade Homepage;
	
	@FindBy(xpath="//*[@class='main-logo-left']") public WebElementFacade PageLogo;
	@FindBy(xpath="//*[@id='curr-trigger']") public WebElementFacade PageCurrency;
	@FindBy(xpath="//*[@class='icon irs-icon-language-1']") public WebElementFacade PageLanguage;
	
	@FindBy(xpath="//*[@class='page-headline grid__10--p1']") public WebElementFacade English_PageTitle;
	@FindBy(xpath="//*[@class='campaign-information grid__10--p1']") public WebElementFacade English_PageCopyHeadline;
	@FindBy(xpath="//*[@class='tc']") public WebElementFacade English_TermsConditions_Open;
	@FindBy(id="modal-tc") public WebElementFacade English_TermsConditions;
	@FindBy(xpath="//button[@title='Close (Esc)']") public WebElementFacade English_TermsConditions_Close;

	@FindBy(xpath="//*[@class='tc-button']") public WebElementFacade Offer_English_TermsConditions_Open;
	@FindBy(xpath="//*[@class='tc-copy']") public WebElementFacade Offer_English_TermsConditions;
	
	@FindBy(xpath="//*[@class='social-sharing social-icons grid__10--p1']") public WebElementFacade English_SocialSharing;
	@FindBy(xpath="//*[@class='footer-wrapper grid__12']") public WebElementFacade PageFooter;

	
	
	
// -----------------------------------------------------------------------------------------------------------------
// ACTIONS	
	
	public void open_vanity_URL(String string) {
		open("open.vanityURL", withParameters(string));
	}
	
	public String get_PropertyText(String string) {
		WebElementFacade PropertyText = $("//div[@data-propcode='"+string+"']");
		return PropertyText.getTextValue();
	}

	public WebElementFacade get_TitleXPath(String string) {
		WebElementFacade TitleXPath = $("//*[@class='offer-headline' and contains (.,'"+string+"')]");
		return TitleXPath;
	}
	
	public WebElementFacade get_TermsConditionsXPath(String string) {
		WebElementFacade TermsConditionsXPath = $("//*[@class='property-offer-information grid-12' and contains (.,'"+string.substring(0, string.indexOf(' '))+"')]//*[@class='tc-button']");
		return TermsConditionsXPath;
	}

}
