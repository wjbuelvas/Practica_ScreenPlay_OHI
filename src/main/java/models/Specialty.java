package models;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class Specialty implements Serializable {

  private final String code;
  private Integer id;
  private List<Link> links;
  private static final long serialVersionUID = -4633202762607053346L;

  public Specialty(String code) {
    this.code = code;
  }
}