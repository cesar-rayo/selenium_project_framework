package com.selenium.stepdefinitions;

import com.selenium.pages.SignUpServices;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = {DriverConfig.class})
public class SignUpStepDefs {

    @Autowired
    private SignUpServices signUp;

    @Given("Pepito wants to have an account")
    public void pepito_wants_to_have_an_account() {
        signUp.go("http://demo.automationtesting.in/Register.html");
        signUp.writeFirstName("estefan");
    }
}
