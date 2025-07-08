package starter.saucedemo.model;

public enum User {

    // Estos son los usuarios que ofrece el sitio SauceDemo para testear.
    STANDARD_USER("standard_user", "secret_sauce", "A standard user"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce", "A locked out_user user"),
    PROBLEM_USER("problem_user", "secret_sauce", "A problem user user"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", "secret_sauce", "A performance glitch user user"),
    ERROR_USER("error_user", "secret_sauce", "A error user user"),
    VISUAL_USER("visual_user", "secret_sauce", "A visual user user");

    // Campos que cada usuario tiene
    private final String username;
    private final String password;
    private final String description;

    User(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
    }

    // Métodos públicos para obtener los datos del usuario
    public String getDescription() {
        return description;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
