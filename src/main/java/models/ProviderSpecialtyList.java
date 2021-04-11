package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import utils.enums.UtilidadOhi;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ProviderSpecialtyList implements Serializable {

  private static final String REQUIERE_CITA = "S";
  private static final String PUBLICAR_DIRECTORIO = "N";
  private static final String AUDIO_RESPUESTA = "N";
  private static final String FECHA_INICIO = UtilidadOhi.obtenerFechaSistema();

  private Integer id;
  private Integer createdBy;
  private Integer lastUpdatedBy;
  private Integer objectVersionNumber;
  private String startDate;
  private String uuid;
  private List<Link> links;
  private RequiresAppointment requiereCita;
  private Ivr ivr;
  private PublishDirectory publicarDirectorio;
  private CreationDate creationDate;
  private LastUpdatedDate lastUpdatedDate;
  private Specialty specialty;
  private static final long serialVersionUID = 601695579004787307L;

  public static List<ProviderSpecialtyList> providerSpecialtyListFactory(Specialty codigoEspecialidad) {
    ProviderSpecialtyList listaEspecialidades = new ProviderSpecialtyList();
    listaEspecialidades.setStartDate(FECHA_INICIO);
    listaEspecialidades.setRequiereCita(new RequiresAppointment(REQUIERE_CITA));
    listaEspecialidades.setIvr(new Ivr(AUDIO_RESPUESTA));
    listaEspecialidades.setPublicarDirectorio(new PublishDirectory(PUBLICAR_DIRECTORIO));
    listaEspecialidades.setSpecialty(codigoEspecialidad);
    return Collections.singletonList(listaEspecialidades);
  }
}