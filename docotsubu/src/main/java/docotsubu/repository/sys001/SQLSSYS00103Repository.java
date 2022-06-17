package docotsubu.repository.sys001;

import org.springframework.stereotype.Repository;
import docotsubu.repository.sys001.bean.SQLSSYS0010301Param;
import docotsubu.repository.sys001.bean.SQLSSYS0010301Result;

@Repository
public interface SQLSSYS00103Repository {

  SQLSSYS0010301Result findOne(SQLSSYS0010301Param params);
}
