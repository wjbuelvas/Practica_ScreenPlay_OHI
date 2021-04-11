package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class TypeIdLegal implements Serializable {

  private static final String TIPO_PROVEEDOR_JURIDICO = "typeIdLegalProvider";

  private final String flexCodeDefinitionCode;
  private final String value;
  private String descriptor;
  private List<Link> links;
  private static final long serialVersionUID = -4718042538733764691L;

  public TypeIdLegal(String tipoDocumento) {
    this.flexCodeDefinitionCode = TIPO_PROVEEDOR_JURIDICO;
    this.value = tipoDocumento;
  }
}