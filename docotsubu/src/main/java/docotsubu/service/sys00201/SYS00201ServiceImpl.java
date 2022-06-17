package docotsubu.service.sys00201;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.controller.sys002.bean.MutterBean;
import docotsubu.repository.sys002.SQLSSYS0020101Repository;
import docotsubu.repository.sys002.bean.SQLSSYS0020101Result;
import docotsubu.service.sys00201.bean.SYS00201InputBean;
import docotsubu.service.sys00201.bean.SYS00201OutputBean;

@Service
@Transactional
public class SYS00201ServiceImpl implements SYS00201Service {

  @Autowired
  private SQLSSYS0020101Repository sqlssys0020101Repository;

  @Override
  public SYS00201OutputBean sys00201(SYS00201InputBean inputBean)
      throws DocotsubuBusinessException {

    List<SQLSSYS0020101Result> sqlssys0020101Result = sqlssys0020101Repository.findAll(null);

    List<MutterBean> mutterList = new ArrayList<>();
    for (SQLSSYS0020101Result result : sqlssys0020101Result) {
      MutterBean mutter = new MutterBean();
      mutter.setUserName(result.getUserName());
      mutter.setText(result.getText());
      mutterList.add(mutter);
    }

    SYS00201OutputBean outputBean = new SYS00201OutputBean();
    outputBean.setMutterList(mutterList);
    return outputBean;
  }

}
