package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class FlexCodeGeneric implements Serializable {

  private static final String TIPO_SEDE = "headOffice";

  private final String flexCodeDefinitionCode;
  private String descriptor;
  private final String value;
  private List<Link> links;
  private static final long serialVersionUID = 1L;

  public FlexCodeGeneric(String value) {
    this.flexCodeDefinitionCode = TIPO_SEDE;
    this.value = value;
  }

}