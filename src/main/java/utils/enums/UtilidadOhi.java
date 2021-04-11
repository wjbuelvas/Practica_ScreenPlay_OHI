package utils.enums;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilidadOhi {

  public static String obtenerFechaSistema(){
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }

  public String generarCodigoEntidades(int cantidadNumeros) {
    String letrasCodigo;
    String numerosCodigo;
    String codigoAleatorio;
    letrasCodigo = "CON_";
    numerosCodigo = Utilidad.generarAleatoriosNumeros(cantidadNumeros);
    codigoAleatorio = letrasCodigo + numerosCodigo;
    return codigoAleatorio;
  }
}