package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartSteps {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Given("usuario logueado")
    public void usuarioLogueado() {
        Hooks.setUp();

        loginPage = new LoginPage(Hooks.page);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("agrega un producto al carrito")
    public void agregaProducto() {
        productsPage = new ProductsPage(Hooks.page);
        productsPage.addProduct();
        productsPage.openCart();
    }

    @Then("visualiza producto en carrito")
    public void validaProducto() {
        cartPage = new CartPage(Hooks.page);

        Assert.assertTrue(cartPage.productVisible());

        Hooks.tearDown();
    }
}
