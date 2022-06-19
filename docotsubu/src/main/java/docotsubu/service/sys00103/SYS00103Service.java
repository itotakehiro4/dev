package docotsubu.service.sys00103;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.common.service.cmn001.CMN001Service;
import docotsubu.common.service.cmn001.bean.CMN001InputBean;
import docotsubu.repository.sys00103.SQLS00103Repository;
import docotsubu.repository.sys00103.bean.SQLS00103Params;
import docotsubu.repository.sys00103.bean.SQLS00103Result;
import docotsubu.service.sys00103.bean.SYS00103InputBean;
import docotsubu.service.sys00103.bean.SYS00103OutputBean;

@Service
@Transactional
public class SYS00103Service {

  @Autowired
  private SQLS00103Repository sQLS00103Repository;

  @Autowired
  private CMN001Service cmn001Service;

  public SYS00103OutputBean sys00103(SYS00103InputBean inputBean)
      throws DocotsubuBusinessException {

    // ログインユーザ存在チェック
    SQLS00103Params params = new SQLS00103Params();
    params.setUserId(inputBean.getUserId());
    SQLS00103Result result = sQLS00103Repository.findOne(params);

    // ユーザ情報が存在しない場合
    if (Objects.isNull(result)) {
      // 業務例外をスロー
      throw new DocotsubuBusinessException("ユーザが存在しません。");
    }

    // ユーザ情報が無効（論理削除）の場合
    if (1 == result.getDelFlg()) {
      // 業務例外をスロー
      throw new DocotsubuBusinessException("有効なユーザではありません。");
    }

    CMN001InputBean cmn001InputBean = new CMN001InputBean();
    cmn001InputBean.setUserId(inputBean.getUserId());
    cmn001InputBean.setPassword(inputBean.getPassword());
    // パスワード整合性確認
    cmn001Service.checkHashedPassword(cmn001InputBean);

    SYS00103OutputBean outputBean = new SYS00103OutputBean();
    outputBean.setUserId(inputBean.getUserId());
    outputBean.setUserName(result.getUserName());
    outputBean.setPrvsrlId(result.getPrvsrlId());
    return outputBean;
  }
}
