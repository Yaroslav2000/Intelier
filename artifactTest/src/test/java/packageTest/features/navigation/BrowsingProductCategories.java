package packageTest.features.navigation;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import packageTest.model.Category;
import packageTest.steps.NavigatingUser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BrowsingProductCategories {

	@Steps
	NavigatingUser UserVasya;
	
    @Managed
    WebDriver browser;
	
	@Test
	//Test Case Title: Navigate to the category
	public void shouldBeAbleToNavigateToTheCategory() {
		//Given (Preconditions)
		//User is on HomePage 
		UserVasya.openHomePage();
		
		//When (Test Case Steps)
		//User navigates to category 'Motors'
		UserVasya.navigatesToCategory(Category.Motors);
		
		//Then (Expected Result)
		//Page title should contain 'New and used cars' 
		UserVasya.shouldSeePageTitleContaining("New and used cars");
	}
	
}
