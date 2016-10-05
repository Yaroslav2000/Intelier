package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/")
public class LiveCMSGeneric extends PageObject {

// -----------------------------------------------------------------------------------------------------------------
// LOCATORS

    @FindBy(name="username")
    public WebElementFacade Username_TEXTBOX;

    @FindBy(name="password")
    public WebElementFacade Password_TEXTBOX;
    
    @FindBy(css="input[class='btn']")
    public WebElementFacade Login_BUTTON;
      
    @FindBy(linkText = "Logout")
    public WebElementFacade Logout_LINK;

// -----------------------------------------------------------------------------------------------------------------
// ACTIONS
    
    public void login(String Username, String Password) {
    	Username_TEXTBOX.type(Username);
    	Password_TEXTBOX.type(Password);
    	Login_BUTTON.click();
    }

	public void logout() {
		Logout_LINK.click();
	}
}