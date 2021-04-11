package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class TypeIdNatural implements Serializable {

  private String flexCodeDefinitionCode;
  private String descriptor;
  private final String value;
  private List<Link> links;
  private static final long serialVersionUID = 8100714600525182887L;

  public TypeIdNatural(String tipoDocumento) {
    this.value = tipoDocumento;
  }
}