package task;

import com.sun.xml.bind.v2.model.core.ID;
import lombok.SneakyThrows;
import models.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import utils.enums.UtilidadCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.enums.ArchivoDatoPrueba.PRESTADORES;
import static utils.enums.RecursoServicio.PRESTADOR_JURIDICO;
import static utils.enums.RecursoServicio.PRESTADOR_NATURAL;

public class Crear implements Task {

    private static final String TIPO_DOCUMENTO = "tipoDocumento";
    private static final String TIPO_SEDE = "tipoSede";
    private static final String CODIGO_ESPECIALIDAD = "codigoEspecialidad";
    private static final String PRESTADOR_PRIMARIO = "Prestador Primario";
    private static final String NUMERO_DOCUMENTO = "numeroDocumento";
    private static final String RAZON_SOCIAL = "razonSocial";
    private static final String NOMBRE_COMERCIAL = "nombreComercial";
    private static final String PRIMER_NOMBRE = "primerNombre";
    private static final String SEGUNDO_NOMBRE = "segundoNombre";
    private static final String PRIMER_APELLIDO = "primerApellido";
    private static final String GENERO = "genero";
    private static final String JURIDICO = "Juridico";
    private static final String FECHA_INICIO = "fechaInicio";
    private static final String DIRECCION = "direccion";
    private static final String ID_PAIS = "idPais";
    private static final String ID_REGION = "idRegion";
    private static final String ID_CIUDAD = "idCiudad";
    private static final String LATITUD = "latitud";
    private static final String LONGITUD = "longitud";
    private static final String UBICACION = "ubicacion";
    private static final Integer ID_DIRECCIÓN = 24021;
    String codigoSap = String.valueOf(new Random().nextInt(99999));
    List<ServiceAddressList> datosDireccion = new ArrayList<>();


    private final String nombrePrestador;
    private final String tipoPrestador;

    public Crear(String nombrePrestador, String tipoPrestador) {
        this.nombrePrestador = nombrePrestador;
        this.tipoPrestador = tipoPrestador;
    }

    public static Crear prestadorEnOhi(String nombrePrestador, String tipoPrestador) {
        return instrumented(Crear.class, nombrePrestador, tipoPrestador);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> datosPrestador = UtilidadCSV.obtenerDatosPrueba(PRESTADORES, nombrePrestador);
        Specialty codigoEspecialidad = new Specialty(datosPrestador.get(0).get(CODIGO_ESPECIALIDAD));
        FlexCodeGeneric codigoFlexibleGenerico = new FlexCodeGeneric(datosPrestador.get(0).get(TIPO_SEDE));
        if (tipoPrestador.equalsIgnoreCase(JURIDICO)) {
            TypeIdLegal tipoIdPrestadorJuridico = new TypeIdLegal(datosPrestador.get(0).get(TIPO_DOCUMENTO));
            Country pais = new Country(datosPrestador.get(0).get(ID_PAIS));
            CountryRegion region = new CountryRegion(datosPrestador.get(0).get(ID_REGION));
            ServiceAddressList listaDireccionAtencion = new ServiceAddressList(
                    datosPrestador.get(0).get(FECHA_INICIO),
                    datosPrestador.get(0).get(DIRECCION),
                    datosPrestador.get(0).get(ID_CIUDAD),
                    datosPrestador.get(0).get(LATITUD),
                    datosPrestador.get(0).get(LONGITUD),
                    datosPrestador.get(0).get(UBICACION), pais, region);
            datosDireccion.add(listaDireccionAtencion);
            ParentOrganizationProvider codigoPrestadorPrimario = new ParentOrganizationProvider(
                    datosPrestador.get(0).get(PRESTADOR_PRIMARIO));
            InformacionPrestador informacionPrestador = new InformacionPrestador(tipoIdPrestadorJuridico,
                    datosPrestador.get(0).get(NUMERO_DOCUMENTO),
                    datosPrestador.get(0).get(RAZON_SOCIAL), codigoFlexibleGenerico,
                    datosPrestador.get(0).get(NOMBRE_COMERCIAL), codigoPrestadorPrimario, codigoEspecialidad,
                    codigoSap, datosDireccion);
            actor.attemptsTo(Post.to(PRESTADOR_JURIDICO.getRecurso())
                    .with(request -> request.header("Content-Type", "application/json")
                            .body(informacionPrestador).log().all()));
        }else{
            TypeIdNatural tipoIdPrestadorNatural = new TypeIdNatural(
                    datosPrestador.get(0).get(TIPO_DOCUMENTO));
            ServiceAddress direccionAtencion = new ServiceAddress(ID_DIRECCIÓN);
            RenderingAddressList datosListaDirecciones = new RenderingAddressList(datosPrestador.get(0).get(FECHA_INICIO),
                    direccionAtencion);
            List<RenderingAddressList> datosDireccionAtencion = new ArrayList<>();
            datosDireccionAtencion.add(datosListaDirecciones);
            InformacionPrestador informacionPrestador = new InformacionPrestador(tipoIdPrestadorNatural,
                    datosPrestador.get(0).get(NUMERO_DOCUMENTO),
                    datosPrestador.get(0).get(NOMBRE_COMERCIAL),
                    codigoFlexibleGenerico,
                    datosPrestador.get(0).get(PRIMER_NOMBRE),
                    datosPrestador.get(0).get(SEGUNDO_NOMBRE),
                    datosPrestador.get(0).get(PRIMER_APELLIDO),
                    datosPrestador.get(0).get(GENERO), codigoEspecialidad, codigoSap, datosDireccionAtencion);
            actor.attemptsTo(Post.to(PRESTADOR_NATURAL.getRecurso())
                    .with(request -> request.header("Content-Type", "application/json")
                            .body(informacionPrestador).log().all()));
        }
    }
}
