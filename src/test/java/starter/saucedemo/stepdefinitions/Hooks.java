package starter.saucedemo.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setTheStage() {
        // Ruta manual al chromedriver
        String projectRoot = System.getProperty("user.dir");
        String driverPath = projectRoot + File.separator + "drivers" + File.separator + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Configuración del navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // ✅ MODO INCOGNITO
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Lanzar navegador
        driver = new ChromeDriver(options);

        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("TestUser").can(BrowseTheWeb.with(driver));
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
        OnStage.drawTheCurtain();
    }
}
