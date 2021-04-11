package models;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class LastUpdatedDate implements Serializable {

  private String value;
  private static final long serialVersionUID = 1596032134252233823L;
}