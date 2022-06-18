package docotsubu.controller.sys002.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class MutterBean implements Serializable {

  private static final long serialVersionUID = -6992098897536330627L;

  private Integer id;

  private String userName;

  private String text;

}
