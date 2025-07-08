package starter.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.saucedemo.ui.SauceDemoPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Esta clase representa la acción de seleccionar un solo producto (la mochila) y agregarlo al carrito.
 */
public class SelectProduct implements Task {

    /**
     * Método estático para que la tarea se vea más legible al usarse:
     * por ejemplo: SelectProduct.backpack()
     */
    public static SelectProduct backpack() {
        return instrumented(SelectProduct.class);
    }

    /**
     * El actor hace clic en el botón para agregar la mochila
     * y luego entra al carrito.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SauceDemoPage.ADD_BACKPACK),
                Click.on(SauceDemoPage.SHOPPING_CART_LINK)
        );
    }
}

