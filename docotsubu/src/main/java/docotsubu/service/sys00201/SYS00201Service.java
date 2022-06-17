package docotsubu.service.sys00201;

import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.service.sys00201.bean.SYS00201InputBean;
import docotsubu.service.sys00201.bean.SYS00201OutputBean;

public interface SYS00201Service {

  SYS00201OutputBean sys00201(SYS00201InputBean inputBean) throws DocotsubuBusinessException;

}
