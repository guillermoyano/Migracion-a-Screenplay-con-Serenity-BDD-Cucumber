package starter.saucedemo;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Esta clase es el punto de entrada para ejecutar los tests de Cucumber con Serenity.
 *
 * Acá se configuran las siguientes cosas:
 *
 * - `@RunWith(CucumberWithSerenity.class)`: Le dice a JUnit que use Serenity para correr los tests.
 * - `features`: Indica dónde están ubicados los archivos `.feature` (los escenarios escritos en Gherkin).
 * - `glue`: Especifica dónde están los step definitions que conectan los pasos con el código.
 * - `plugin`: Agrega reportes adicionales, como uno HTML.
 * - `tags`: Permite filtrar escenarios por etiquetas (por ahora usamos todos excepto los que tengan @ignore).
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "starter.saucedemo.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "not @ignore"
)
public class CucumberTestSuite {
    // No necesita ningún código dentro.
}