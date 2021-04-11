package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class FlexCodeSystem implements Serializable {

  private Integer id;
  private List<Link> links;
  private static final long serialVersionUID = -2120435892411207303L;
}