package starter.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.saucedemo.ui.SauceDemoPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Esta clase representa la acción de agregar varios productos al carrito.
 */
public class AddProductsToCart implements Task {

    /**
     * Usamos un método estático para instanciar la tarea fácilmente.
     */
    public static AddProductsToCart multipleItems() {
        return instrumented(AddProductsToCart.class);
    }

    /**
     * Hace clic en los botones para agregar 3 productos distintos al carrito,
     * y comprueba que el carrito los tenga
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SauceDemoPage.ADD_BACKPACK),
                Click.on(SauceDemoPage.ADD_BIKE_LIGHT),
                Click.on(SauceDemoPage.ADD_BOLT_TSHIRT),
                Click.on(SauceDemoPage.SHOPPING_CART_LINK)
        );
    }
}