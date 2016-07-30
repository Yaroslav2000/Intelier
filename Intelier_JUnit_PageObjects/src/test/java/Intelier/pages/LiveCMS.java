package Intelier.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://l5.local-qa.dev.webcanada.com/")
public class LiveCMS extends PageObject {

    @FindBy(name="username")
    private WebElementFacade username;

    @FindBy(name="password")
    private WebElementFacade password;
    
    @FindBy(css="div[class='btnWrap btnWrapBlue']")
    private WebElementFacade loginButton;
  
    public void login() {
    	username.type("Yaroslav.Yasynskyy@Webcanada.com");
    	password.type("Ntbk-9@#");
    	loginButton.click();
    }

	public void logout() {
		// TODO Auto-generated method stub
		
	}

}

