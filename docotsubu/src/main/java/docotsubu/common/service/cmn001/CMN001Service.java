package docotsubu.common.service.cmn001;

import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.common.service.cmn001.bean.CMN001InputBean;
import docotsubu.common.service.cmn001.bean.CMN001OutputBean;

public interface CMN001Service {

  CMN001OutputBean checkHashedPassword(CMN001InputBean inputBean) throws DocotsubuBusinessException;

}
