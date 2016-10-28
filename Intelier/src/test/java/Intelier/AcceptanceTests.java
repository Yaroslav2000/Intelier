package Intelier;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features")
public class AcceptanceTests {}


//DEBUGGING
//System.out.println("////////////////////////////////////////");
//System.out.println("some value");
//System.out.println("////////////////////////////////////////");

//JavascriptExecutor javascript = (JavascriptExecutor) getDriver();
//javascript.executeScript("alert('Element Is drag and drop by 100 pixel offset In horizontal direction.');");
//waitABit(5000);
//getDriver().switchTo().alert().accept();