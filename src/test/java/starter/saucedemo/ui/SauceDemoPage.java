package starter.saucedemo.ui;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Esta clase representa todos los elementos que aparecen en las distintas páginas del sitio.
 * Se usa para que el resto del código se mantenga ordenado y reutilizable.
 */

public class SauceDemoPage {

    // Campos de login
    public static final Target USERNAME_FIELD = Target.the("username field")
            .located(By.id("user-name"));

    public static final Target PASSWORD_FIELD = Target.the("password field")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.id("login-button"));

    // Título de página (como "Products", "Your Cart", etc.)
    public static final Target PAGE_TITLE = Target.the("page title")
            .located(By.cssSelector(".title"));

    // Botones para agregar productos al carrito
    public static final Target ADD_BACKPACK = Target.the("add backpack to cart")
            .located(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']"));

    public static final Target ADD_BIKE_LIGHT = Target.the("add bike light to cart")
            .located(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']"));

    public static final Target ADD_BOLT_TSHIRT = Target.the("add bolt t-shirt to cart")
            .located(By.cssSelector("[data-test='add-to-cart-sauce-labs-bolt-t-shirt']"));

    // Carrito
    public static final Target SHOPPING_CART_LINK = Target.the("shopping cart link")
            .located(By.cssSelector("[data-test='shopping-cart-link']"));

    public static final Target CART_ITEMS = Target.the("cart items")
            .located(By.className("cart_item"));

    // Botones para eliminar productos del carrito
    public static final Target REMOVE_BACKPACK = Target.the("remove backpack from cart")
            .located(By.cssSelector("[data-test='remove-sauce-labs-backpack']"));

    public static final Target REMOVE_BIKE_LIGHT = Target.the("remove bike light from cart")
            .located(By.cssSelector("[data-test='remove-sauce-labs-bike-light']"));

    public static final Target REMOVE_BOLT_TSHIRT = Target.the("remove bolt t-shirt from cart")
            .located(By.cssSelector("[data-test='remove-sauce-labs-bolt-t-shirt']"));

    // Checkout - campos y botones
    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .located(By.cssSelector("[data-test='checkout']"));

    public static final Target FIRST_NAME_FIELD = Target.the("first name field")
            .located(By.cssSelector("[data-test='firstName']"));

    public static final Target LAST_NAME_FIELD = Target.the("last name field")
            .located(By.cssSelector("[data-test='lastName']"));

    public static final Target POSTAL_CODE_FIELD = Target.the("postal code field")
            .located(By.cssSelector("[data-test='postalCode']"));

    public static final Target CONTINUE_BUTTON = Target.the("continue button")
            .located(By.cssSelector("[data-test='continue']"));

    public static final Target FINISH_BUTTON = Target.the("finish button")
            .located(By.cssSelector("[data-test='finish']"));

    // Mensaje de confirmación
    public static final Target CONFIRMATION_MESSAGE = Target.the("confirmation message")
            .located(By.cssSelector("[data-test='complete-header']"));

    // Menú y logout
    public static final Target BURGER_MENU = Target.the("burger menu")
            .located(By.cssSelector("#react-burger-menu-btn"));

    public static final Target LOGOUT_LINK = Target.the("logout link")
            .located(By.cssSelector("[data-test='logout-sidebar-link']"));
}
