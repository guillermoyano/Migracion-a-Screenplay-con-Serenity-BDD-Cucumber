package starter.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.saucedemo.model.User;
import starter.saucedemo.ui.SauceDemoPage;


/**
 * Esta clase representa la acción de iniciar sesión (login) como un determinado usuario.
 * Se usa en los escenarios donde queremos que el actor acceda al sitio con distintos tipos de usuarios.
 */
public class Login implements Task {

    private final User user;

    /**
     * Constructor privado para que la clase sea utilizada solo desde el método estático as()
     */
    private Login(User user) {
        this.user = user;
    }

    /**
     * Método estático para instanciar la tarea de login con un usuario específico.
     * Esto mejora la legibilidad cuando usamos la tarea en los tests.
     */
    public static Login as(User user) {
        return new Login(user);
    }

    /**
     * Este método define paso a paso qué hace el actor para completar el login.
     * Entra el usuario, la contraseña y hace clic en el botón de inicio de sesión.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getUsername()).into(SauceDemoPage.USERNAME_FIELD),
                Enter.theValue(user.getPassword()).into(SauceDemoPage.PASSWORD_FIELD),
                Click.on(SauceDemoPage.LOGIN_BUTTON)
        );
    }
}