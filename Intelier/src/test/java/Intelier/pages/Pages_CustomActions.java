package Intelier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;

import net.thucydides.core.pages.PageObject;

public class Pages_CustomActions extends PageObject {
	
// -----------------------------------------------------------------------------------------------------------------
// CUSTOM ACTIONS	

	public void moveToElement(WebElementFacade webElementFacade) {
		withAction().moveToElement(webElementFacade).perform();
	}
	
	public void moveToElementByText(String string) {
		WebElement element = getDriver().findElement(By.xpath("//*[contains(text(), '"+string+"')]"));
		withAction().moveToElement(element).perform();
	}

	//*[@id='property-holder']
	
}
