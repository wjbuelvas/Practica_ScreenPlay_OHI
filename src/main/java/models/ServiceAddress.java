package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAddress implements Serializable {

    private Integer id;
    private String city;
    private Integer createdBy;
    private Integer lastUpdatedBy;
    private Integer objectVersionNumber;
    private String startDate;
    private String uuid;
    private String address;
    private String latitude;
    private String location;
    private String longitude;
    private List<Link> links;
    private CreationDate creationDate;
    private LastUpdatedDate lastUpdatedDate;
    private Country country;
    private CountryRegion countryRegion;
    private List<ServiceAddressList> serviceAddressList;
    private static final long serialVersionUID = -38345590908961581L;

    public ServiceAddress(String fechaInicio, String direccion, String idCiudad, String latitud, String longitud,
                          String ubicacion, Country idPais, CountryRegion idRegion) {
        this.startDate = fechaInicio;
        this.address = direccion;
        this.city = idCiudad;
        this.latitude = latitud;
        this.longitude = longitud;
        this.location = ubicacion;
        this.country = idPais;
        this.countryRegion = idRegion;
    }

    public ServiceAddress(Integer idDireccionAtencion) {

        this.id = idDireccionAtencion;
    }
}