package task;

import io.restassured.builder.RequestSpecBuilder;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.preemptive;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.enums.RecursoServicio.PRESTADOR_JURIDICO;
import static utils.enums.RecursoServicio.PRESTADOR_NATURAL;

@AllArgsConstructor
public class Consultar implements Task {

    private final String tipoPrestador;
    private static final String NATURAL = "Natural";


    public static Consultar prestadorEnOhi(String tipoPrestador) {
        return instrumented(Consultar.class, tipoPrestador);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (tipoPrestador.equalsIgnoreCase(NATURAL)) {
            SerenityRest.setDefaultRequestSpecification(new RequestSpecBuilder()
                    .setAuth(preemptive().basic("rafapagr", "Contrasena157*"))
                    .build());
            actor.attemptsTo(Get.resource(PRESTADOR_NATURAL.getRecurso()).with(request -> request.header("Content-Type", "application/json").log().all()));
            SerenityRest.lastResponse().getBody().prettyPrint();
        } else {
            actor.attemptsTo(Get.resource(PRESTADOR_JURIDICO.getRecurso())   .with(request -> request.header("Content-Type", "application/json").log().all()));
            SerenityRest.lastResponse().getBody().prettyPrint();
        }
    }
}
