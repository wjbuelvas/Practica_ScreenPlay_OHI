package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class Ivr implements Serializable {

  private String flexCodeDefinitionCode;
  private String descriptor;
  private final String value;
  private List<Link> links = null;
  private static final long serialVersionUID = -4632677806621238776L;

  public Ivr(String valorIvr) {
    this.value = valorIvr;
  }
}