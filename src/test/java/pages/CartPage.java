package pages;

import com.microsoft.playwright.Page;

public class CartPage {
    Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public boolean productVisible() {
        return page.locator(".inventory_item_name").isVisible();
    }
}
