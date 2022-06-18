package docotsubu.service.sys00201.bean;

import java.io.Serializable;
import java.util.List;
import docotsubu.controller.sys002.bean.MutterBean;
import lombok.Data;

@Data
public class SYS00201OutputBean implements Serializable {

  private static final long serialVersionUID = -1545204411945746067L;

  private List<MutterBean> mutterList;

}
