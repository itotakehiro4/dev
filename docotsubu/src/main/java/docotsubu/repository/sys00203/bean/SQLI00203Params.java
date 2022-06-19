package docotsubu.repository.sys00203.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class SQLI00203Params implements Serializable {

  private static final long serialVersionUID = -4142560500729632300L;

  private String userId;

  private String userName;

  private String text;

  private String dateStr;

}
