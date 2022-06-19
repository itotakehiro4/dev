package docotsubu.repository.sys00103;

import org.apache.ibatis.annotations.Mapper;
import docotsubu.repository.sys00103.bean.SQLS00103Params;
import docotsubu.repository.sys00103.bean.SQLS00103Result;

@Mapper
public interface SQLS00103Repository {

  SQLS00103Result findOne(SQLS00103Params params);

}
