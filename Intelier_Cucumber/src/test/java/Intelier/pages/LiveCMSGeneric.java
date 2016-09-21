package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/")
public class LiveCMSGeneric extends PageObject {

    // -----------------------------------------------------------------------------------------------------------------
    // LOCATORS

    @FindBy(name="username")
    private WebElementFacade Username_TEXTBOX;

    @FindBy(name="password")
    private WebElementFacade Password_TEXTBOX;
    
    @FindBy(css="input[class='btn']")
    private WebElementFacade Login_BUTTON;
      
    @FindBy(linkText = "Logout")
    private WebElementFacade Logout_LINK;

    // -----------------------------------------------------------------------------------------------------------------
    // ACTIONS
    
    @Step("LiveCMS Login")
    public void login() {
    	Username_TEXTBOX.type("automation@Webcanada.com");
    	Password_TEXTBOX.type("Automation123");
    	Login_BUTTON.click();
    }

    @Step("LiveCMS Logout")
	public void logout() {
		Logout_LINK.click();
	}
}