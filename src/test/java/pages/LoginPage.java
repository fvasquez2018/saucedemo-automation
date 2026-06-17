package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://www.saucedemo.com/");
        this.page.waitForTimeout(500);
    }

    public void login(String user, String pass) {
        page.fill("#user-name", user);
        this.page.waitForTimeout(500);
        page.fill("#password", pass);
        this.page.waitForTimeout(500);
        page.click("#login-button");
        this.page.waitForTimeout(500);
    }
}
