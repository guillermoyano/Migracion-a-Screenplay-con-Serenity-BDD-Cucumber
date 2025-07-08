package starter.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.saucedemo.ui.SauceDemoPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Esta clase representa la acción de quitar todos los productos
 * que están en el carrito de compras.
 */
public class RemoveProductsFromCart implements Task {

    /**
     * Método estático para usar la tarea de forma simple:
     * RemoveProductsFromCart.allItems()
     */
    public static RemoveProductsFromCart allItems() {
        return instrumented(RemoveProductsFromCart.class);
    }

    /**
     * El actor hace clic en los botones para remover cada producto.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SauceDemoPage.REMOVE_BACKPACK),
                Click.on(SauceDemoPage.REMOVE_BIKE_LIGHT),
                Click.on(SauceDemoPage.REMOVE_BOLT_TSHIRT)
        );
    }
}