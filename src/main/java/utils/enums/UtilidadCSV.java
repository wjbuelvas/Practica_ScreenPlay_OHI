package utils.enums;

import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public final class UtilidadCSV {

    private static final String RUTA_RECURSOS_DATOS_CSV = "data/";
    private static final String EXTENSION_NOMBRE_DATOS_CSV = ".csv";
    private static final String NOMBRE_COLUMNA_FILTRO = "idFiltro";
    private static final char SEPARADOR_VALORES_CSV = ';';

    private UtilidadCSV() {
    }

    public static List<Map<String, String>> obtenerDatosPrueba(ArchivoDatoPrueba nombreCSV,
                                                               String filtro) throws IOException {
        try {
            TestDataSource datosOrigenCSV =
                    new CSVTestDataSource(RUTA_RECURSOS_DATOS_CSV + nombreCSV.toString().toLowerCase()
                            + EXTENSION_NOMBRE_DATOS_CSV, SEPARADOR_VALORES_CSV);
            return obtenerDatosFiltrados(datosOrigenCSV, filtro);
        } catch (Exception e) {
            String excepcion = String.format(
                    "Se presentó una excepción leyendo el csv '%s' buscando por el filtro '%s'.%nmensaje:'%s'",
                    nombreCSV.toString(), filtro, e.getMessage());
            throw new IOException(excepcion);
        }
    }

    private static List<Map<String, String>> obtenerDatosFiltrados(TestDataSource datosCSV,
                                                                   String cadenaListadoFiltros) {
        List<Map<String, String>> lstTotalDatosCSV = datosCSV.getData();
        if ("".equals(cadenaListadoFiltros)) {
            return lstTotalDatosCSV;
        }
        String[] arrListadoFiltros =
                cadenaListadoFiltros.split(Separador.COMA.getValor());
        return filtrarDatos(arrListadoFiltros, lstTotalDatosCSV);
    }

    private static List<Map<String, String>> filtrarDatos(String[] arrListaFiltros,
                                                          List<Map<String, String>> listaTotalDatos) {
        return listaTotalDatos
                .stream()
                .filter(
                        fila -> Utilidad.compararDatosLista(arrListaFiltros, fila.get(NOMBRE_COLUMNA_FILTRO)))
                .collect(Collectors.toList());
    }

    public static String obtenerDatoContenidoCSV(
            ArchivoDatoPrueba nomDiccionarioCSV,
            String nombreColumnaPivote,
            String valorColumnaPivote,
            String nombreColumnaRetornar)
            throws IOException {
        List<Map<String, String>> lstDiccionario =
                obtenerDatosPrueba(nomDiccionarioCSV, valorColumnaPivote);
        Optional<String> valorObtenido =
                lstDiccionario
                        .stream()
                        .filter(registro -> valorColumnaPivote.equals(registro.get(nombreColumnaPivote)))
                        .map(registro -> registro.get(nombreColumnaRetornar))
                        .findFirst();
        if (valorObtenido.isPresent()) {
            return valorObtenido.get();
        }
        throw new IllegalArgumentException(
                String.format("Columna %s NO encontrada", nombreColumnaRetornar));
    }

    /**
     * Utilice este método para obtener un registro aleatorio de un CSV que cumpla con el filtro
     * aplicado. Ideal para usarse cuando se tienen multiples datos de prueba en un CSV que cumplen
     * con un mismo filtro
     *
     * @param nombreCSV Nombre del archivo CSV que contiene los datos
     * @param filtro    Valor que se aplicará como filtro. Este se aplica sobre el primer dato de cada
     *                  registro del CSV.
     * @return Array de Strings, cada elemento es un valor del registro obtenido.
     */
    public static String[] obtenerElementoFiltrado(ArchivoDatoPrueba nombreCSV, String filtro)
            throws IOException {
        List<String[]> datosFiltrados = new ArrayList<>();
        String pathToFile =
                RUTA_RECURSOS_DATOS_CSV + nombreCSV.toString().toLowerCase() + EXTENSION_NOMBRE_DATOS_CSV;
        List<String[]> datosCsv = leerCSV(pathToFile, String.valueOf(SEPARADOR_VALORES_CSV));

        for (String[] registroActual : datosCsv) {
            if (registroActual[0].equals(filtro)) {
                datosFiltrados.add(registroActual);
            }
        }
        return datosFiltrados.get(new SecureRandom().nextInt(datosFiltrados.size()));
    }

    private static List<String[]> leerCSV(String path, String separador) throws IOException {
        List<String[]> datos = new ArrayList<>();
        BufferedReader br = null;
        String excepcion = "";
        path = System.getProperty("user.dir").concat("/src/test/resources/").concat(path);

        Path pathToFile = Paths.get(path);
        try {
            br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(separador);
                datos.add(attributes);
                line = br.readLine();
            }
        } catch (Exception e) {
            excepcion = e.getMessage();
        } finally {
            if (br != null) {
                br.close();
            }
        }

        if (!excepcion.equals("")) {
            throw new IOException(excepcion);
        }

        return datos;
    }

}
