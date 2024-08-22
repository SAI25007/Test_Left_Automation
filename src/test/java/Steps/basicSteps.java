package Steps;

//import com.smartbear.testleft.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Driver;

public class basicSteps {

    public Driver driver;

    @Given("Open the App")
    public void openApp() {
        System.out.println("Application Started");
//        driver.application.runAs
    }
    @When("enter the application details")
    public void applicationDetails(){
        System.out.println("Details");
    }
    @Then("Print the Success message")
    public void successMessage(){
        System.out.println("Application Opened Successfully");
    }
}
