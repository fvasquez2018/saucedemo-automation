package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Given("el usuario abre SauceDemo")
    public void abrirPagina() {
        Hooks.setUp();
        loginPage = new LoginPage(Hooks.page);
        loginPage.open();
    }

    @When("ingresa usuario {string} y password {string}")
    public void login(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("visualiza la página de productos")
    public void validarLogin() {
        Assert.assertTrue(Hooks.page.url().contains("inventory"));
        Hooks.tearDown();
    }

    @Then("visualiza mensaje de error")
    public void validarError() {
        boolean visible = Hooks.page.locator("[data-test='error']").isVisible();
        Assert.assertTrue(visible);
        Hooks.tearDown();
    }
}
