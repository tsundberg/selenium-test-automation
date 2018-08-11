package se.thinkcode.selenium.executable.specifications.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PasswordSteps {
    private PasswordHelper passwordHelper;

    @Given("^(.*) browser is used$")
    public void browser_is_used(String browserName){
        passwordHelper = new PasswordHelper(browserName);
    }

    @Given("^(.*) need a new password$")
    public void need_a_new_password(String account){
        passwordHelper.setAccount(account);
    }

    @When("^the new password is requested$")
    public void the_new_password_is_requested() {
        passwordHelper.sendRequest();
    }

    @Then("^should the confirmation message (.*) be visible$")
    public void should_the_confirmation_message_be_visible(String expected) {
        String actual = passwordHelper.getConfirmationMessage();
        passwordHelper.quitBrowser();
        assertThat(actual, is(expected));
    }
}
