package docotsubu.controller.sys002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import docotsubu.common.bean.UserBean;
import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.service.sys00201.SYS00201Service;
import docotsubu.service.sys00201.bean.SYS00201InputBean;
import docotsubu.service.sys00201.bean.SYS00201OutputBean;

@Controller
@RequestMapping("sys002")
public class SYS002Controller {

  /**
   * ページパス
   */
  private static final String VIEW_PATH = "sys002/sys002";

  @Autowired
  private SYS00201Service sys00201Service;

  @Autowired
  private UserBean userBean;

  @GetMapping("sys00201")
  public String sys00201(Model model) {

    String userId = userBean.getUserId();
    SYS00201InputBean inputBean = new SYS00201InputBean();
    inputBean.setLoginUserId(userId);

    SYS00201OutputBean outputBean = new SYS00201OutputBean();
    try {
      outputBean = sys00201Service.sys00201(inputBean);
    } catch (DocotsubuBusinessException e) {
      model.addAttribute("error", e.getMessage());
      return VIEW_PATH;
    }

    model.addAttribute("mutterList", outputBean.getMutterList());

    return VIEW_PATH;
  }

}
