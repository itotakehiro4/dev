package docotsubu.service.sys00103.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class SYS00103OutputBean implements Serializable {

  private static final long serialVersionUID = -3729312038340935275L;

  private String userId;

  private String userName;

  private String password;

  private String prvsrlId;

}
