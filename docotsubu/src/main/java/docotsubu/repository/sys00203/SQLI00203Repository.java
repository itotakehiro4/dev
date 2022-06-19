package docotsubu.repository.sys00203;

import org.apache.ibatis.annotations.Mapper;
import docotsubu.repository.sys00203.bean.SQLI00203Params;

@Mapper
public interface SQLI00203Repository {

  int insertOne(SQLI00203Params params);

}
