package docotsubu.service.sys00203;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.common.service.cmn002.CMN002Service;
import docotsubu.repository.sys00203.SQLI00203Repository;
import docotsubu.repository.sys00203.bean.SQLI00203Params;
import docotsubu.service.sys00203.bean.SYS00203InputBean;
import docotsubu.service.sys00203.bean.SYS00203OutputBean;

@Service
@Transactional
public class SYS00203Service {

  @Autowired
  private SQLI00203Repository sqlisys0020301Repository;

  @Autowired
  private CMN002Service cmn002Service;

  public SYS00203OutputBean sys00203(SYS00203InputBean inputBean)
      throws DocotsubuBusinessException {

    SQLI00203Params params = new SQLI00203Params();
    params.setUserId(inputBean.getUserId());
    params.setUserName(inputBean.getUserName());
    params.setText(inputBean.getText());
    params.setDateStr(cmn002Service.getLocalDateTimeToStr());

    int result = sqlisys0020301Repository.insertOne(params);

    if (1 != result) {
      throw new DocotsubuBusinessException("つぶやき投稿の登録に失敗しました。");
    }

    SYS00203OutputBean outputBean = new SYS00203OutputBean();
    outputBean.setMessage("つぶやき投稿の登録が正常に完了しました。");
    return outputBean;
  }
}
