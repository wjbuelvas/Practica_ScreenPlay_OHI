package models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Getter
@NoArgsConstructor
public class Prefix implements Serializable {

  private String code;
  private Integer id;
  private List<Link> links;
  private static final long serialVersionUID = -749382418627485015L;

  public Prefix(String code) {
    this.code = code;
  }
}