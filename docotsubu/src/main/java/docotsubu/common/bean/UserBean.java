package docotsubu.common.bean;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import lombok.Data;

@Component
@SessionScope
@Data
public class UserBean implements Serializable {

  private static final long serialVersionUID = 1622395702803038416L;

  private String userId;

  private String userName;

  private String prvsrlId;

}
