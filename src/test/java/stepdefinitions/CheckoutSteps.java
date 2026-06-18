package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutSteps {
    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("usuario con producto en carrito")
    public void usuarioConProducto() {

        //Hooks.setUp();

        loginPage = new LoginPage(Hooks.page);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage = new ProductsPage(Hooks.page);
        productsPage.addProduct();
        productsPage.openCart();
    }

    @When("completa el checkout")
    public void completaCheckout() {
        Hooks.page.click("#checkout");
        Hooks.page.fill("#first-name", "Fatima");
        Hooks.page.fill("#last-name", "Test");
        Hooks.page.fill("#postal-code", "15001");
        Hooks.page.click("#continue");
        Hooks.page.click("#finish");
    }

    @Then("visualiza confirmación")
    public void validarConfirmacion() {
        boolean visible = Hooks.page.locator(".complete-header").isVisible();
        Assert.assertTrue(visible);
       // Hooks.tearDown();
    }
}
