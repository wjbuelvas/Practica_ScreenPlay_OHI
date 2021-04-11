package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/creacion_prestadores.feature",
        glue = {"stepdefinitions"}, tags = {"@test"}
)

public class CreacionPrestadorRunner {
}
