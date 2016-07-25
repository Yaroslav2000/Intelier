package packageTest.steps;

import packageTest.model.Category;
import packageTest.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class NavigatingUser {

	HomePage homePage;
	
	@Step
	public void openHomePage() {
		homePage.open();
		
	}
	
	@Step
	public void shouldSeePageTitleContaining(String ExpectedTitle) {
		// TODO Auto-generated method stub
		
	}

	@Step
	public void navigatesToCategory(Category category) {
		// TODO Auto-generated method stub
		
	}


}
