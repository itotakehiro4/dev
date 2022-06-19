package docotsubu.controller.sys002.bean;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SYS002Form implements Serializable {

  private static final long serialVersionUID = -4329860699202934584L;

  @NotEmpty(message = "つぶやきが未入力です")
  private String text;

}
