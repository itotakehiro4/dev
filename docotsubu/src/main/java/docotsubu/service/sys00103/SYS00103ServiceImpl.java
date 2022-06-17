package docotsubu.service.sys00103;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.common.service.cmn001.CMN001Service;
import docotsubu.common.service.cmn001.bean.CMN001InputBean;
import docotsubu.repository.sys001.SQLSSYS00103Repository;
import docotsubu.repository.sys001.bean.SQLSSYS0010301Param;
import docotsubu.repository.sys001.bean.SQLSSYS0010301Result;
import docotsubu.service.sys00103.bean.SYS00103InputBean;
import docotsubu.service.sys00103.bean.SYS00103OutputBean;

@Service
@Transactional
public class SYS00103ServiceImpl implements SYS00103Service {

  @Autowired
  private SQLSSYS00103Repository sQLSSYS00103Repository;

  @Autowired
  private CMN001Service cmn001Service;

  @Override
  public SYS00103OutputBean sys00103(SYS00103InputBean inputBean) throws DocotsubuBusinessException {

    // ログインユーザ存在チェック
    SQLSSYS0010301Param params = new SQLSSYS0010301Param();
    params.setUserId(inputBean.getUserId());
    SQLSSYS0010301Result result = sQLSSYS00103Repository.findOne(params);

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
    outputBean.setPrvsrl(null);
    return outputBean;
  }

}
