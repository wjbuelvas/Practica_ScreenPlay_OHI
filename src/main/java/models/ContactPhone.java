package models;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ContactPhone implements Serializable {

  private String startDate;
  private Integer id;
  private String phone;
  private static final long serialVersionUID = -70699396657094102L;
}