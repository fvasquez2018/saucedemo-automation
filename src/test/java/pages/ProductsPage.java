package pages;

import com.microsoft.playwright.Page;

public class ProductsPage {
    Page page;

    public ProductsPage(Page page) {
        this.page = page;
    }

    public void addProduct() {
        page.click("#add-to-cart-sauce-labs-backpack");
    }

    public void openCart() {
        page.click(".shopping_cart_link");
    }
}
