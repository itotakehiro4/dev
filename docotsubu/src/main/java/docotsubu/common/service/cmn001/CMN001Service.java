package docotsubu.common.service.cmn001;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import docotsubu.common.constant.DocotsubuConstant;
import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.common.service.cmn001.bean.CMN001InputBean;
import docotsubu.common.service.cmn001.bean.CMN001OutputBean;

@Service
@Transactional
public class CMN001Service {

  public CMN001OutputBean checkHashedPassword(CMN001InputBean inputBean)
      throws DocotsubuBusinessException {

    String solt = DocotsubuConstant.Sys001.SOLT;
    String hashNet5 = DocotsubuConstant.Sys001.HashNet5;

    String hash = DigestUtils.sha256Hex(solt + inputBean.getUserId() + hashNet5);
    String hashedPassword = DigestUtils.sha256Hex(inputBean.getPassword() + hash);

    CMN001OutputBean outputBean = new CMN001OutputBean();
    outputBean.setHashedPassword(hashedPassword);
    return outputBean;
  }
}
