package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@NoArgsConstructor
public class FunctionDynamicLogic implements Serializable {

  private String code;
  private Boolean active;
  private String descr;
  private String subtype;
  private Integer id;
  private List<Link> links;
  private static final long serialVersionUID = -7023549050764999175L;

  public FunctionDynamicLogic(String code) {
    this.code = code;
  }
}