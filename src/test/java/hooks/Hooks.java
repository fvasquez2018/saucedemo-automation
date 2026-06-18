package hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;
    public static Scenario scenario;

    @Before
    public static void setUp(Scenario currentScenario) {
        scenario = currentScenario;
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
    }

    @AfterStep
    public void takeStepScreenshot(Scenario scenario) {
        if (page != null && !page.isClosed()) {
            byte[] screenshot = page.screenshot();
            scenario.attach(screenshot, "image/png", "Paso ejecutado");
        }
    }

    @After
    public static void tearDown() {
        if (page != null && !page.isClosed()) page.close();
        if (browser != null && browser.isConnected()) browser.close();
        if (playwright != null) playwright.close();
    }

}
