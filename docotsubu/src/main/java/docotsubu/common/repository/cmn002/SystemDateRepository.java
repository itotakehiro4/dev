package docotsubu.common.repository.cmn002;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemDateRepository {

  String findLocalDate();

  String findLocalDateTime();

}
