package starter.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.saucedemo.ui.SauceDemoPage;

/**
 * Esta clase verifica si el botón de login está visible.
 * Se usa al cerrar sesión para confirmar que volvió a la pantalla de inicio.
 */

public class TheLoginButton implements Question<Boolean> {

    /**
     * Método estático para usar esta pregunta de forma sencilla.
     */
    public static TheLoginButton isVisible() {
        return new TheLoginButton();
    }

    /**
     * Responde true si el botón de login está visible.
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(SauceDemoPage.LOGIN_BUTTON).answeredBy(actor);
    }
}