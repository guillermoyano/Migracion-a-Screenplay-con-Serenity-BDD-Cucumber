package starter.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.saucedemo.ui.SauceDemoPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Esta clase representa el paso final de la compra, donde se hace clic en el botón "Finish".
 */
public class CompletePurchase implements Task {

    /**
     * Método estático para iniciar la tarea de forma clara.
     */
    public static CompletePurchase successfully() {
        return instrumented(CompletePurchase.class);
    }

    /**
     * Ejecuta el clic en el botón para completar la compra.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SauceDemoPage.FINISH_BUTTON)
        );
    }
}