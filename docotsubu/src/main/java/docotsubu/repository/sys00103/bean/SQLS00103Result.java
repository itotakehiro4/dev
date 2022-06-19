package docotsubu.repository.sys00103.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class SQLS00103Result implements Serializable {

  private static final long serialVersionUID = -7614890849039695005L;

  private String userId;

  private String userName;

  private String password;

  private String prvsrlId;

  private Integer delFlg;

}
