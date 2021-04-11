package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.apache.http.HttpStatus;
import org.hamcrest.core.IsEqual;
import questions.ResponseCode;
import task.Consultar;
import task.Crear;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearPrestadorStepDefinitions {

    @Cuando("se consulta un prestador de {word}")
    public void consultarPrestador(String tipoPrestador) {
        theActorInTheSpotlight().attemptsTo(Consultar.prestadorEnOhi(tipoPrestador));

    }

    @Cuando("se crea el nuevo prestador {string} de tipo {word}")
    public void crearPrestador(String nombrePrestador, String tipoPrestador) {
        theActorInTheSpotlight().attemptsTo(Crear.prestadorEnOhi(nombrePrestador, tipoPrestador));
    }

    @Cuando("se crea el nuevo prestador {string} de tipo juridico")
    public void se_crea_el_nuevo_prestador_de_tipo_juridico(String string) {

    }

    @Cuando("se crean las sucursales del prestador")
    public void se_crean_las_sucursales_del_prestador(io.cucumber.datatable.DataTable dataTable) {

    }

    @Entonces("muestra la lista de prestadores existentes en OHI")
    public void validarPrestadores() {
        theActorInTheSpotlight().should(seeThat("El codigo de respuesta", ResponseCode.was(), IsEqual.equalTo(HttpStatus.SC_OK)));
    }

    @Entonces("el prestador quedará guardado correctamente")
    public void el_prestador_quedará_guardado_correctamente() {
        theActorInTheSpotlight().should(seeThat("El codigo de respuesta", ResponseCode.was(), IsEqual.equalTo(HttpStatus.SC_CREATED)));
    }

    @Entonces("la sede principal quedará relacionada a las sedes sucursales")
    public void la_sede_principal_quedará_relacionada_a_las_sedes_sucursales() {

    }
}
