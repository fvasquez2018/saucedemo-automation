package hooks;

import com.microsoft.playwright.*;

public class Hooks {
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;

    public static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
    }

    public static void tearDown() {
        browser.close();
        playwright.close();
    }
}
