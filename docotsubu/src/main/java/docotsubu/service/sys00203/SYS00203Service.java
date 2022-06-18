package docotsubu.service.sys00203;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.service.sys00203.bean.SYS00203InputBean;
import docotsubu.service.sys00203.bean.SYS00203OutputBean;

@Service
@Transactional
public class SYS00203Service {

  public SYS00203OutputBean sys00203(SYS00203InputBean inputBean)
      throws DocotsubuBusinessException {

    return null;
  }
}
