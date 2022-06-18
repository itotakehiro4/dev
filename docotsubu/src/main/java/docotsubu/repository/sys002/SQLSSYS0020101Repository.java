package docotsubu.repository.sys002;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import docotsubu.repository.sys002.bean.SQLSSYS0020101Params;
import docotsubu.repository.sys002.bean.SQLSSYS0020101Result;

@Mapper
public interface SQLSSYS0020101Repository {

  List<SQLSSYS0020101Result> findAll(SQLSSYS0020101Params params);

}
