package docotsubu.repository.sys001;

import org.apache.ibatis.annotations.Mapper;
import docotsubu.repository.sys001.bean.SQLSSYS0010301Params;
import docotsubu.repository.sys001.bean.SQLSSYS0010301Result;

@Mapper
public interface SQLSSYS00103Repository {

  SQLSSYS0010301Result findOne(SQLSSYS0010301Params params);

}
