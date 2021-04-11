package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link implements Serializable {

  private String href;
  private String rel;
  private static final long serialVersionUID = 7262772278067892708L;
}