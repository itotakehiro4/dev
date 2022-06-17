package docotsubu.service.login.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class LoginInputBean implements Serializable {

  private static final long serialVersionUID = 3236950598899763507L;

  private String userId;

  private String password;

}
