package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.serenitybdd.core.Serenity;
import utils.enums.UtilidadOhi;

import java.io.Serializable;
import java.util.List;

import static models.ProviderSpecialtyList.providerSpecialtyListFactory;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class InformacionPrestador implements Serializable {

    private static final String SUBTIPO_NATURAL = "INPR";
    private static final String SUBTIPO_JURIDICO = "ORPR";
    private static final String DEFINICION_PRESTADOR = "providers";
    private static final String CORREO = "test@servicio.com.co";
    private static final String FECHA_INICIO = UtilidadOhi.obtenerFechaSistema();
    private static final String FORMATO_NOMBRE_PRESTADOR = "DFT_NAME_FORMAT_PROVIDER";
    private static final String IDIOMA = "es";
    private static final String PREFIJO = "DRA";

    private Integer id;
    private String numeroId;
    private String codeSAP;
    private String socialReason;
    private String flexCodeDefinitionCode;
    private String value;
    private String code;
    private Integer createdBy;
    private String emailAddress1;
    private String firstName;
    private String secondName;
    private String gender;
    private Integer lastUpdatedBy;
    private String middleName;
    private String name;
    private Integer objectLastUpdatedBy;
    private Integer objectVersionNumber;
    private String startDate;
    private String subtype;
    private String uuid;
    private List<Link> links;
    private TypeIdNatural typeIdNatural;
    private FlexCodeGeneric headOffice;
    private FlexCodeGeneric branchOffice;
    private List<ContactPhone> contactPhone;
    private CreationDate creationDate;
    private LastUpdatedDate lastUpdatedDate;
    private ObjectLastUpdatedDate objectLastUpdatedDate;
    private FlexCodeSystem flexCodeSystem;
    private FunctionDynamicLogic functionDynamicLogic;
    private Language language;
    private Prefix prefix;
    private ParentOrganizationProvider parentOrganizationProvider;
    private TypeIdLegal typeIdLegal;
    private Specialty specialty;
    private RequiresAppointment requiresAppointment;
    private String codigoEspecialidad;
    private List<ProviderSpecialtyList> providerSpecialtyList;
    private Country country;
    private CountryRegion countryRegion;
    private ServiceAddress serviceAddress;
    private List<RenderingAddressList> renderingAddressList;
    private List<ServiceAddressList> serviceAddressList;
    private static final long serialVersionUID = 5302918295880755563L;

    public InformacionPrestador(TypeIdLegal tipoDocumento, String numeroDocumento, String razonSocial,
                                FlexCodeGeneric tipoSede, String nombreComercial,
                                ParentOrganizationProvider prestadorPrimario, Specialty codigoEspecialidad,
                                String codigoSap, List<ServiceAddressList> datosDireccion) {
        this.typeIdLegal = tipoDocumento;
        this.numeroId = numeroDocumento;
        this.socialReason = razonSocial;
        this.headOffice = tipoSede;
        this.setProviderSpecialtyList(providerSpecialtyListFactory(codigoEspecialidad));
        this.language = new Language(IDIOMA);
        this.flexCodeDefinitionCode = DEFINICION_PRESTADOR;
        this.codeSAP = codigoSap;
        //Serenity.setSessionVariable().to(codeSAP);
        this.emailAddress1 = CORREO;
        this.startDate = FECHA_INICIO;
        this.subtype = SUBTIPO_JURIDICO;
        this.code = numeroDocumento + "-" + codigoSap;
        //Serenity.setSessionVariable().to(code);
        this.parentOrganizationProvider = prestadorPrimario;
        this.name = nombreComercial;
        this.setServiceAddressList(datosDireccion);
    }

    public InformacionPrestador(TypeIdNatural tipoDocumento, String numeroDocumento,
                                String razonSocial, FlexCodeGeneric tipoSede, String primerNombre, String segundoNombre,
                                String primerApellido, String genero, Specialty codigoEspecialidad, String codigoSap,
                                List<RenderingAddressList> datosDireccionAtencion) {
        this.typeIdNatural = tipoDocumento;
        this.numeroId = numeroDocumento;
        this.socialReason = razonSocial;
        this.headOffice = tipoSede;
        this.firstName = primerNombre;
        this.secondName = segundoNombre;
        this.name = primerApellido;
        this.gender = genero;
        this.setProviderSpecialtyList(providerSpecialtyListFactory(codigoEspecialidad));
        this.codeSAP = codigoSap;
        this.language = new Language(IDIOMA);
        this.flexCodeDefinitionCode = DEFINICION_PRESTADOR;
        this.emailAddress1 = CORREO;
        this.startDate = FECHA_INICIO;
        this.subtype = SUBTIPO_NATURAL;
        this.code = numeroDocumento + "-" + codigoSap;
        //Serenity.setSessionVariable().to(code);
        this.functionDynamicLogic = new FunctionDynamicLogic(FORMATO_NOMBRE_PRESTADOR);
        this.prefix = new Prefix(PREFIJO);
        this.setRenderingAddressList(datosDireccionAtencion);
    }

    public InformacionPrestador(String numeroDocumento) {
        this.numeroId = numeroDocumento;
    }
}