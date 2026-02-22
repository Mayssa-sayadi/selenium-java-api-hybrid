package com.tests.automation.step_definitions.front;

import com.tests.automation.actions.SeleniumUtils;
import com.tests.automation.actions.Validations;
import com.tests.automation.page_objects.LoginPage;
import com.tests.automation.utils.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class LoginStepDefinition {

    private final SeleniumUtils actionsUtils;
    private final ConfigFileReader configFileReader;
    private final LoginPage loginPage;
    Validations validations = new Validations();

    public LoginStepDefinition() {
        loginPage = new LoginPage();
        actionsUtils = new SeleniumUtils();
        configFileReader = new ConfigFileReader();
    }

    @Given("Je me connecte sur le site Web Demo Shop")
    public void jeMeConnecteSurLeSiteWebDemoShop() {
        actionsUtils.get(configFileReader.getProperty("home.url"));
    }

    @When("Je clique sur le bouton Log in")
    public void jeCliqueSurLeBoutonLogIn() {
        actionsUtils.click(loginPage.getLoginBarMenu());

    }

    @When("Je saisis une adresse mail")
    public void jeSaisisUneAdresseMail() {
        actionsUtils.clearField(loginPage.getEmailField());
        actionsUtils.writeText(loginPage.getEmailField(),configFileReader.getProperty("home.email"));

    }

    @When("Je saisis un mot de passe")
    public void jeSaisisUnMotDePasse() {
        actionsUtils.clearField(loginPage.getPasswordField());
        actionsUtils.writeText(loginPage.getPasswordField(),configFileReader.getProperty("home.password"));
    }

    @When("Je clique sur le bouton Login")
    public void jeCliqueSurLeBoutonLogin() {
        actionsUtils.click(loginPage.getBtnLogin());
    }

    @Then("Je me redirige vers la page home {string}")
    public void jeMeRedirigeVersLaPageHome(String email) throws InterruptedException {
        Assert.assertTrue("User Address found",loginPage.getUserNameAddress());
    }

    @When("Je saisis une adresse mail {string}")
    public void jeSaisisUneAdresseMail(String email) {
        actionsUtils.writeText(loginPage.getEmailField(),email);
    }

    @When("Je saisis un mot de passe {string}")
    public void jeSaisisUnMotDePasse(String password) {
        actionsUtils.writeText(loginPage.getPasswordField(),password);
    }

    @Then("Je visualise le message d'erreur {string}")
    public void jeVisualiseLeMessageDErreur(String expected) throws InterruptedException {
        validations.assertEquals(LoginPage.getErrorMessage(), expected);

    }
}


