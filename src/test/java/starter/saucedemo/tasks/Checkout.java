package starter.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.saucedemo.ui.SauceDemoPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Esta clase representa el proceso de finalizar una compra (checkout).
 * El actor debe completar su información personal y avanzar al resumen.
 */
public class Checkout implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    /**
     * Constructor privado. Se usa el método estático para crear una instancia.
     */
    public Checkout(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    /**
     * Permite usar la tarea de forma más clara: Checkout.withUserData(...)
     */
    public static Checkout withUserData(String firstName, String lastName, String postalCode) {
        return instrumented(Checkout.class, firstName, lastName, postalCode);
    }

    /**
     * Ejecuta los pasos de hacer clic en Checkout, completar los campos y avanzar.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SauceDemoPage.CHECKOUT_BUTTON),
                Enter.theValue(firstName).into(SauceDemoPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(SauceDemoPage.LAST_NAME_FIELD),
                Enter.theValue(postalCode).into(SauceDemoPage.POSTAL_CODE_FIELD),
                Click.on(SauceDemoPage.CONTINUE_BUTTON)
        );
    }
}
