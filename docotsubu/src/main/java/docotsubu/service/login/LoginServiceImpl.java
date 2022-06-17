package docotsubu.service.login;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import docotsubu.service.login.bean.LoginInputBean;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

  @Override
  public Void login(LoginInputBean inputBean) {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

}
