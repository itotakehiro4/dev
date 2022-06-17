package docotsubu.common.service.cmn001.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class CMN001OutputBean implements Serializable {

  private static final long serialVersionUID = 7854816121466495792L;

  private String hashedPassword;

}
