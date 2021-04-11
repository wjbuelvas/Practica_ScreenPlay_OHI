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
public class CountryRegion implements Serializable {

    private String code;
    private Integer id;
    private String indicativoRegion;
    private List<Link> links;
    private static final long serialVersionUID = -8728276081195767248L;

    public CountryRegion(String codigoRegion) {
        this.code = codigoRegion;
    }
}