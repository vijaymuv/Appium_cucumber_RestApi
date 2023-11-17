package CucumberRevision;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepCucumberRevision {
    @Given("user navigates to url")
    public void user_navigates_to_url() {
        System.out.println("user_navigates_to_url");
    }
    @When("user enters {string}")
    public void user_enters(String string) {
        System.out.println("user_enters email"+string);
    }
    @When("user enters {string} into tx")
    public void user_enters_into_tx(String string) {
        System.out.println("user_enters_into_tx"+string);
    }

    @Then("validate outcomes")
    public void validate_outcomes() {
        System.out.println("validate_outcomes");
    }
}
