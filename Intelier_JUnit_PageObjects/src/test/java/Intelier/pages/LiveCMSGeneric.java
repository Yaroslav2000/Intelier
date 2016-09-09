package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/")
public class LiveCMSGeneric extends PageObject {

    @FindBy(name="username")
    private WebElementFacade username;

    @FindBy(name="password")
    private WebElementFacade password;
    
    @FindBy(css="input[class='btn']")
    private WebElementFacade loginButton;
      
    @FindBy(linkText = "Logout")
    private WebElementFacade logoutLink;
    
    public void login() {
    	username.type("automation@Webcanada.com");
    	password.type("Automation123");
    	loginButton.click();
    }

	public void logout() {
    	logoutLink.click();
	}
}