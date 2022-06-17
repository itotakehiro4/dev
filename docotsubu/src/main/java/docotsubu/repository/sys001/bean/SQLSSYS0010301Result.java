package docotsubu.repository.sys001.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class SQLSSYS0010301Result implements Serializable {

  private static final long serialVersionUID = -7614890849039695005L;

  private String userId;

  private String password;

  private Integer delFlg;

}
