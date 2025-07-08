package starter.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import starter.saucedemo.ui.SauceDemoPage;

/**
 * Esta clase se usa para obtener el mensaje de confirmación
 * al finalizar una compra, por ejemplo: "THANK YOU FOR YOUR ORDER!".
 */
public class TheConfirmationMessage implements Question<String> {

    /**
     * Método estático para usar esta pregunta de forma clara.
     */
    public static TheConfirmationMessage displayed() {
        return new TheConfirmationMessage();
    }

    /**
     * Devuelve el texto del mensaje final de confirmación.
     */
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(SauceDemoPage.CONFIRMATION_MESSAGE).answeredBy(actor);
    }
}
