package docotsubu.common.bean;

import java.io.Serializable;
import org.springframework.web.context.annotation.SessionScope;
import lombok.Data;

@SessionScope
@Data
public class UserBean implements Serializable {

  private static final long serialVersionUID = 1622395702803038416L;

  private String userId;

  private String prvsrl;

}
