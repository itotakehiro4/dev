package docotsubu.common.service.cmn002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import docotsubu.common.repository.cmn002.SystemDateRepository;

@Service
@Transactional
public class CMN002Service {

  @Autowired
  private SystemDateRepository systemDateRepository;

  public String getLocalDateToStr() {
    return systemDateRepository.findLocalDate();
  }

  public String getLocalDateTimeToStr() {
    return systemDateRepository.findLocalDateTime();
  }

}
