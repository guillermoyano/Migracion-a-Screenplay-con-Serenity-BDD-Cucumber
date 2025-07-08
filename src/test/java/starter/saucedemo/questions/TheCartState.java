package starter.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.core.pages.WebElementFacade;
import starter.saucedemo.ui.SauceDemoPage;

import java.util.List;

/**
 * Esta clase pregunta si el carrito está vacío.
 * Sirve para validar que el usuario quitó todos los productos.
 */
public class TheCartState implements Question<Boolean> {

    /**
     * Método estático para usar esta pregunta de forma clara:
     * TheCartState.isEmpty()
     */
    public static TheCartState isEmpty() {
        return new TheCartState();
    }

    /**
     * Responde true si no hay ningún producto visible en el carrito.
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        // Uso WebElementFacade que es el tipo correcto que devuelve resolveAllFor
        List<WebElementFacade> items = SauceDemoPage.CART_ITEMS.resolveAllFor(actor);
        return items.isEmpty();
    }
}
