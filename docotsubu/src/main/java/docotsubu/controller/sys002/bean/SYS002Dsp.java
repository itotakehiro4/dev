package docotsubu.controller.sys002.bean;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class SYS002Dsp implements Serializable {

  private static final long serialVersionUID = 1687291069172926381L;

  private List<MutterBean> mutterList;

}
