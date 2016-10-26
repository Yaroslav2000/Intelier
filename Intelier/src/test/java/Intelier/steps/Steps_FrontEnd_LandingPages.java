package Intelier.steps;

import Intelier.pages.Pages_FrontEnd_LandingPages;
import net.thucydides.core.annotations.Step;

public class Steps_FrontEnd_LandingPages {

	Pages_FrontEnd_LandingPages FE;
	
    @Step
	public void open_vanity_URL(String string) {
		FE.open_vanity_URL(string);		
	}
}
