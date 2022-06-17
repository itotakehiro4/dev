package docotsubu.common.service.cmn001.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class CMN001InputBean implements Serializable {

  private static final long serialVersionUID = 5714959524723401103L;

  private String userId;

  private String password;

}
