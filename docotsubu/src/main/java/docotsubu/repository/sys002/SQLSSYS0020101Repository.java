package docotsubu.repository.sys002;

import java.util.List;
import org.springframework.stereotype.Repository;
import docotsubu.repository.sys002.bean.SQLSSYS0020101Param;
import docotsubu.repository.sys002.bean.SQLSSYS0020101Result;

@Repository
public interface SQLSSYS0020101Repository {

  List<SQLSSYS0020101Result> findAll(SQLSSYS0020101Param params);

}
