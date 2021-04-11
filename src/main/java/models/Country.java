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
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {

    private String id;
    private String countryIndicative;
    private String nacionality;
    private String isoNumericCode;
    private String currencyCode;
    private List<Link> links = null;
    private static final long serialVersionUID = 7465887221935903758L;

    public Country(String idPais) {
        this.id = idPais;
    }
}