package docotsubu.repository.sys00201;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import docotsubu.repository.sys00201.bean.SQLS00201Params;
import docotsubu.repository.sys00201.bean.SQLS00201Result;

@Mapper
public interface SQLS00201Repository {

  List<SQLS00201Result> findAll(SQLS00201Params params);

}
