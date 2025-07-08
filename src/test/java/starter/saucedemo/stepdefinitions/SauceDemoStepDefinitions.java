package starter.saucedemo.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import starter.saucedemo.model.User;
import starter.saucedemo.questions.TheCartState;
import starter.saucedemo.questions.TheConfirmationMessage;
import starter.saucedemo.questions.TheLoginButton;
import starter.saucedemo.questions.ThePageTitle;
import starter.saucedemo.tasks.*;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

/**
 * Este archivo contiene todos los pasos que se relacionan
 * con el archivo de características (feature).
 * Aquí definimos cómo actúa el usuario (el actor) frente a cada paso del test.
 */
public class SauceDemoStepDefinitions {

    private Actor user;

    /**
     * Paso inicial para abrir el sitio web.
     */
    @Given("the user is on the SauceDemo website")
    public void theUserIsOnTheSauceDemoWebsite() {
        user = theActorCalled("TestUser");
        user.attemptsTo(Open.url("https://saucedemo.com"));
    }

    /**
     * Paso para que el actor inicie sesión como usuario estándar.
     */
    @Given("the user logs in as a standard user")
    public void theUserLogsInAsAStandardUser() {
        user.attemptsTo(Login.as(User.STANDARD_USER));
    }

    /**
     * Verifica que el título de la página diga "Products"
     */
    @Then("the user should see the Products page")
    public void theUserShouldSeeTheProductsPage() {
        user.should(seeThat(ThePageTitle.displayed(), equalToIgnoringCase("Products")));
    }

    /**
     * Selecciona un solo producto y lo agrega al carrito.
     */
    @When("the user selects a product and adds it to cart")
    public void theUserSelectsAProductAndAddsItToCart() {
        user.attemptsTo(SelectProduct.backpack());
    }

    /**
     * Realiza el proceso de checkout con los datos del usuario.
     */
    @When("the user proceeds to checkout with personal information")
    public void theUserProceedsToCheckoutWithPersonalInformation(DataTable dataTable) {
        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
        Map<String, String> userInfo = userData.get(0);

        user.should(seeThat(ThePageTitle.displayed(), equalToIgnoringCase("Your Cart")));

        user.attemptsTo(
                Checkout.withUserData(
                        userInfo.get("firstName"),
                        userInfo.get("lastName"),
                        userInfo.get("postalCode")
                )
        );

        user.should(seeThat(ThePageTitle.displayed(), equalToIgnoringCase("Checkout: Overview")));
    }

    /**
     * Finaliza la compra haciendo clic en el botón de Finish.
     */
    @When("the user completes the purchase")
    public void theUserCompletesThePurchase() {
        user.attemptsTo(CompletePurchase.successfully());
    }

    /**
     * Valida el mensaje final de compra exitosa.
     */
    @Then("the user should see the confirmation message {string}")
    public void theUserShouldSeeTheConfirmationMessage(String expectedMessage) {
        user.should(seeThat(TheConfirmationMessage.displayed(), equalToIgnoringCase(expectedMessage)));
    }

    /**
     * Agrega varios productos al carrito.
     */
    @When("the user adds multiple products to the cart")
    public void theUserAddsMultipleProductsToTheCart() {
        user.attemptsTo(AddProductsToCart.multipleItems());
    }

    /**
     * Valida que esté en la página del carrito.
     */
    @Then("the user should see the cart page")
    public void theUserShouldSeeTheCartPage() {
        user.should(seeThat(ThePageTitle.displayed(), equalToIgnoringCase("Your Cart")));
    }

    /**
     * Elimina todos los productos del carrito.
     */
    @When("the user removes all products from the cart")
    public void theUserRemovesAllProductsFromTheCart() {
        user.attemptsTo(RemoveProductsFromCart.allItems());
    }

    /**
     * Valida que el carrito esté vacío.
     */
    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        user.should(seeThat(TheCartState.isEmpty(), is(true)));
    }

    /**
     * Cierra la sesión del usuario.
     */
    @When("the user logs out")
    public void theUserLogsOut() {
        user.attemptsTo(Logout.fromTheApplication());
    }

    /**
     * Verifica que haya vuelto a la pantalla de login.
     */
    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        user.should(seeThat(TheLoginButton.isVisible(), is(true)));
    }
}