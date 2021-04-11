package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class RequiresAppointment implements Serializable {

  private String flexCodeDefinitionCode;
  private String descriptor;
  private final String value;
  private List<Link> links;
  private static final long serialVersionUID = -6283419246407229010L;

  public RequiresAppointment(String requiereCita) {
    this.value = requiereCita;
  }
}