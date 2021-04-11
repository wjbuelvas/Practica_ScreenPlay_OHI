package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ConfigurarInicial {

    @Before
    public void configurarActor() {
        setTheStage(new OnlineCast());
        theActorCalled("Wilson");
    }

    @Dado("que Wilson desea consumir la api de OHI")
    public void obtenerApi() {
        theActorInTheSpotlight().whoCan(CallAnApi.at("https://sura-uat-ohi-api.oracleindustry.com/cla-api/generic/"));
    }

}
