package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RenderingAddressList implements Serializable {
    private Integer id;
    private Integer objectVersionNumber;
    private String startDate;
    private List<Link> links;
    private ServiceAddress serviceAddress;
    private static final long serialVersionUID = -38345590908961581L;

  public RenderingAddressList(String fechaInicio, ServiceAddress idDireccionAtencion) {
    this.startDate = fechaInicio;
    this.serviceAddress = idDireccionAtencion;
  }
}