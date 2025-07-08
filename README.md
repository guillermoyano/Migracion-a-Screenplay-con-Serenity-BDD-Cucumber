
# 🛒 Serenity BDD - Migración a Screenplay + Cucumber - Proyecto SauceDemo

Este proyecto es el resultado de una refactorización profunda sobre el repositorio original basado en Page Objects + JUnit clásico que hice anteriormente y está publicado en mi GitHub:
🔗 [SerenityBDD-JUnit-Selenium](https://github.com/guillermoyano/SerenityBDD-JUnit-Selenium) 

El objetivo fue transformar esa base funcional en una arquitectura moderna y robusta utilizando el patrón Screenplay junto con Cucumber BDD, manteniendo como caso de estudio el sitio [SauceDemo](https://www.saucedemo.com/).
Se reemplazaron todos los Steps, PageObjects y Assertions tradicionales por una estructura centrada en Actors, Tasks y Questions, más legible, escalable y alineada con buenas prácticas actuales de automatización de pruebas.

---

## 🚀 Objetivo del Proyecto

El propósito principal fue llevar un proyecto ya funcional (basado en PageObjects y JUnit clásico) hacia un diseño:

- más **escalable**
- **legible para testers y desarrolladores**
- **orientado a comportamientos (BDD)**
- y alineado con buenas prácticas de automatización de pruebas modernas.

---

## 🛠️ Tecnologías y herramientas utilizadas

- **Java 20**
- **Serenity BDD 3.9.8**
- **Cucumber JVM 7.14.0**
- **Screenplay Pattern**
- **Maven**
- **Selenium WebDriver**
- **AssertJ**
- **WebDriverManager (manual y por propiedad)**

---

## 📦 Estructura del proyecto

```
.
├── src
│   └── test
│       ├── java
│       │   └── starter.saucedemo
│       │       ├── model
│       │       ├── questions
│       │       ├── stepdefinitions
│       │       ├── tasks
│       │       ├── ui
│       │       └── runners
│       └── resources
│           └── features
│               └── saucedemo.feature
├── drivers
│   └── chromedriver.exe
├── pom.xml
└── README.md
```

---

## ⚙️ Funcionalidades Automatizadas

Se automatizan casos end-to-end para usuarios en SauceDemo:

- ✅ Login exitoso como usuario estándar
- ✅ Agregado y remoción de productos del carrito
- ✅ Checkout con datos de usuario (DataTable de Cucumber)
- ✅ Validación de mensaje de confirmación de compra
- ✅ Logout y verificación del retorno al login

---

## 🔁 Proceso de Migración

Esta fue una **migración paulatina** desde una estructura tradicional con `@Step` y `@Managed`, a un diseño centrado en **Actors**, **Tasks**, **Questions** y **Targets**.

Durante el proceso se refactorizaron:

- Clases de step definitions (`StepDefinitions`)
- Acciones repetidas como `Login`, `SelectProduct`, `Checkout`, entre otras, ahora convertidas en **Tasks** reutilizables
- Validaciones ahora expresadas como **Questions** con `seeThat(...)`
- WebElements convertidos a objetos `Target` bajo `SauceDemoPage.java`
- Configuración de `Hooks` para control total del driver y del `Stage` de actores

---

## 💡 Manejo de ChromeDriver (manual)

En vez de depender del sistema operativo o del PATH del sistema, se decidió incluir manualmente el archivo `chromedriver.exe` dentro del proyecto.

### ¿Por qué?

- 🔒 Evita errores como “no se encuentra chromedriver”
- 🔁 Permite compartir el proyecto y que funcione en cualquier máquina
- 🧩 Compatible con Serenity sin necesidad de instalar nada extra

### ¿Cómo se configura?

En el archivo `serenity.conf`:

```hocon
webdriver {
  driver = chrome
  chrome.driver = "${user.dir}/drivers/chromedriver.exe"
}
```

---

## 📌 Desafíos técnicos superados

Durante el desarrollo, surgieron diversos problemas técnicos que requirieron una **resolución profunda**, entre ellos:

- ❌ Conflictos por uso incorrecto de `By.id(...)` (mal importado desde `net.serenitybdd.core.annotations.findby`)
- ❌ Problemas de tipado entre `WebElementState` y `List<WebElement>`
- ❌ Errores como `NoClassDefFoundError: org/openqa/selenium/HasDownloads` por conflictos entre versiones de Selenium y Serenity
- ❌ Configuración manual de `chromedriver` por fallos con WebDriverManager
- ❌ Error `Cannot invoke "Object.getClass()" because "object" is null` al no cumplir con los constructores de `Tasks` instrumentados
- ❌ Detección de pop-ups inesperados tras el login que interferían con la ejecución de tests
- ❌ Migración forzada por actualizaciones de **Google Chrome 138** que exigieron:
    - Bajar manualmente el `chromedriver` compatible
    - Ubicarlo en el path correcto
    - Setearlo manualmente en los `Hooks`

---

## 👨‍💻 Sobre el proceso de aprendizaje

El proyecto fue realizado como parte de mi formación práctica en automatización de pruebas. Para lograrlo, recurrí a diferentes fuentes:

- 📚 **Documentación oficial de Serenity BDD y Screenplay**
- 🎓 **Tutoriales técnicos en línea (YouTube, Medium, GitHub, blogs)**
- 🤖 **Consultas técnicas con ChatGPT** para:
    - Interpretar errores complejos de Maven
    - Entender inyecciones fallidas (`WebCapableActorInjector`)
    - Resolver problemas con `Stage`, `Actor`, `WebDriver`
    - Evitar errores comunes en `Tasks`, `Hooks` o `@Before`

---

## 📈 Resultados

Luego de varios días de depuración y ajustes, se logró un proyecto:

- ✅ Ejecutable con `mvn verify`
- ✅ Compatible con cualquier versión de Chrome (con `chromedriver` correcto)
- ✅ Con reportes generados en `/target/site/serenity/index.html`
- ✅ Listo para ser base de futuras automatizaciones reales

---

## 🧪 Cómo ejecutar el proyecto

1. Clonar el repo
2. Ejecutar:

```bash
mvn clean verify
```

3. Ver los reportes:

```
target/site/serenity/index.html
```

---

## 👤 Autor

**Guillermo Román Moyano**  
Tester Manual y QA Automation en formación  
🐶 Papá, programador, educador canino, curioso incansable

---

¿Querés ver el proyecto funcionando o tenés dudas técnicas?  
📬 Contactame o revisá mi perfil en [LinkedIn](https://linkedin.com)
