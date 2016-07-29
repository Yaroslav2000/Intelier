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

    @FindBy(name="username")
    private WebElementFacade username;

    @FindBy(name="password")
    private WebElementFacade password;
    
    @FindBy(name="login")
    private WebElementFacade loginButton;
  
    public void login_as_YY() {
    	username.type("YY");
    	pressAnyKeyToContinue();
    	password.type("YY");
    	loginButton.click();
    }

    private void pressAnyKeyToContinue()
    { 
           System.out.println("Press any key to continue...");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }
    
    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}

