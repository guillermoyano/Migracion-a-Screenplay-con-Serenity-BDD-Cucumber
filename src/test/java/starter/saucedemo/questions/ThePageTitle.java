
package starter.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import starter.saucedemo.ui.SauceDemoPage;

/**
 * Esta clase sirve para obtener el título de la página.
 * Se usa para validar que el usuario está en la sección correcta,
 * como "Products", "Your Cart", etc.
 */
public class ThePageTitle implements Question<String> {

    /**
     * Método estático para usar esta pregunta de forma cómoda.
     */
    public static ThePageTitle displayed() {
        return new ThePageTitle();
    }

    /**
     * Devuelve el texto del título que ve el actor en la página.
     */
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(SauceDemoPage.PAGE_TITLE).answeredBy(actor);
    }
}

