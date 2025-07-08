package starter.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.saucedemo.ui.SauceDemoPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

/**
 * Esta clase representa la acción de cerrar sesión desde el menú (burger menu).
 * Primero se espera a que el botón esté listo, se abre el menú y se hace clic en Logout.
 */
public class Logout implements Task {

    /**
     * Método estático para que sea más claro cuando se llama a esta acción:
     * Logout.fromTheApplication()
     */
    public static Logout fromTheApplication() {
        return instrumented(Logout.class);
    }

    /**
     * Espera a que el botón de menú esté disponible,
     * luego lo abre y hace clic en el link de Logout.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SauceDemoPage.BURGER_MENU, isClickable()),
                Click.on(SauceDemoPage.BURGER_MENU),
                Click.on(SauceDemoPage.LOGOUT_LINK)
        );
    }
}

