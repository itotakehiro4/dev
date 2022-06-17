package docotsubu.controller.login.bean;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm implements Serializable {

  private static final long serialVersionUID = -5925299467247838552L;

  @NotEmpty(message = "ユーザIDは必須です")
  private String userId;

  @NotEmpty(message = "パスワードは必須です")
  private String password;

}
