package docotsubu.service.sys00103;

import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.service.sys00103.bean.SYS00103InputBean;
import docotsubu.service.sys00103.bean.SYS00103OutputBean;

public interface SYS00103Service {

  SYS00103OutputBean sys00103(SYS00103InputBean inputBean) throws DocotsubuBusinessException;

}
