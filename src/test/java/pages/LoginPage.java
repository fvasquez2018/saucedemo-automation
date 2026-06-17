package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        page.fill("#user-name", user);
        page.fill("#password", pass);
        page.click("#login-button");
    }
}
