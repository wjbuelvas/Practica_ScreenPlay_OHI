package models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceAddressList implements Serializable {

    private Integer id;
    private String startDate;
    private String city;
    private Integer objectVersionNumber;
    private Integer lastUpdatedBy;
    private Integer createdBy;
    private String uuid;
    private String latitude;
    private String longitude;
    private String address;
    private String location;
    private Country country;
    private ServiceAddress serviceAddress;
    private CountryRegion countryRegion;
    private LastUpdatedDate lastUpdatedDate;
    private String ultimaDireccion;
    private CreationDate creationDate;
    private List<Link> links = null;
    private static final long serialVersionUID = -38345590908961581L;

    public ServiceAddressList(String fechaInicio, String direccion, String ciudad, String latitud, String longitud, String ubicacion, Country idPais, CountryRegion idRegion) {
        this.setStartDate(fechaInicio);
        this.setAddress(direccion);
        this.setCity(ciudad);
        this.setLatitude(latitud);
        this.setLongitude(longitud);
        this.setLocation(ubicacion);
        this.setCountry(idPais);
        this.setCountryRegion(idRegion);
    }

}

