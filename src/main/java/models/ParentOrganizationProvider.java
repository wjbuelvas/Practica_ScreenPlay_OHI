package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParentOrganizationProvider implements Serializable {

    private Integer id;
    private String numeroId;
    private String codeSAP;
    private String socialReason;
    private String flexCodeDefinitionCode;
    private String code;
    private String value;
    private String emailAddress1;
    private String name;
    private String startDate;
    private String subtype;
    private FlexCodeGeneric headOffice;
    private Language language;
    private InformacionPrestador informacionPrestador;
    private List<ProviderSpecialtyList> providerSpecialtyList;
    private TypeIdLegal typeIdLegal;
    private List<Link> links;
    private static final long serialVersionUID = 9047038179760549036L;

    public ParentOrganizationProvider(String proveedorPrimario) {
        this.code = (proveedorPrimario);
    }
}