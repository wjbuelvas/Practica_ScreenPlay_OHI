package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class PublishDirectory implements Serializable {

  private String flexCodeDefinitionCode;
  private String descriptor;
  private final String value;
  private List<Link> links;
  private static final long serialVersionUID = -5704387879503122450L;

  public PublishDirectory(String valorDefinicion) {
    this.value = valorDefinicion;
  }
}