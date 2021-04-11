package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@NoArgsConstructor
public class Language implements Serializable {

  private String code;
  private String languageCode;
  private String descr;
  private Boolean defaultLanguage;
  private Boolean system;
  private String isoLanguage;
  private Integer id;
  private List<Link> links;
  private static final long serialVersionUID = -214675830923688363L;

  public Language(String code) {
    this.code = code;
  }

}