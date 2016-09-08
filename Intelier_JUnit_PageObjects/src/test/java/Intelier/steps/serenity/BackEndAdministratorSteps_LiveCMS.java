package Intelier.steps.serenity;

import org.openqa.selenium.WebDriver;

import Intelier.pages.LiveCMS;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class BackEndAdministratorSteps_LiveCMS extends ScenarioSteps {
	
	LiveCMS liveCMS;

	@Step
    public void opens_LiveCMS() {
    	liveCMS.open();
    	liveCMS.login();
    }
	
	@Step
    public void closes_LiveCMS() {
    	liveCMS.logout();
    }

}