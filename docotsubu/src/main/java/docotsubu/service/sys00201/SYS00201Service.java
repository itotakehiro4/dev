package docotsubu.service.sys00201;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.controller.sys002.bean.MutterBean;
import docotsubu.repository.sys002.SQLSSYS0020101Repository;
import docotsubu.repository.sys002.bean.SQLSSYS0020101Params;
import docotsubu.repository.sys002.bean.SQLSSYS0020101Result;
import docotsubu.service.sys00201.bean.SYS00201InputBean;
import docotsubu.service.sys00201.bean.SYS00201OutputBean;

@Service
@Transactional
public class SYS00201Service {

  @Autowired
  private SQLSSYS0020101Repository sqlssys0020101Repository;

  public SYS00201OutputBean sys00201(SYS00201InputBean inputBean)
      throws DocotsubuBusinessException {

    SQLSSYS0020101Params params = new SQLSSYS0020101Params();
    params.setUserId(inputBean.getLoginUserId());

    List<SQLSSYS0020101Result> sqlssys0020101Result = sqlssys0020101Repository.findAll(params);

    List<MutterBean> mutterList = sqlssys0020101Result.stream().map(m -> {
      MutterBean mutter = new MutterBean();
      mutter.setId(m.getMutterId());
      mutter.setUserName(m.getUserName());
      mutter.setText(m.getMutterText());
      return mutter;
    }).collect(Collectors.toList());

    SYS00201OutputBean outputBean = new SYS00201OutputBean();
    outputBean.setMutterList(mutterList);
    return outputBean;
  }
}
