package docotsubu.controller.sys001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import docotsubu.common.bean.UserBean;
import docotsubu.common.exception.DocotsubuBusinessException;
import docotsubu.controller.sys001.bean.SYS001Form;
import docotsubu.service.sys00103.SYS00103Service;
import docotsubu.service.sys00103.bean.SYS00103InputBean;
import docotsubu.service.sys00103.bean.SYS00103OutputBean;

@Controller
@RequestMapping("sys001")
public class SYS001Controller {

  private static final String VIEW_PATH = "login/login";

  @Autowired
  private UserBean userBean;

  @Autowired
  private SYS00103Service sys00103Service;

  /**
   * 初期表示
   * 
   * @param model
   * @return
   */
  @GetMapping("sys00101")
  public String sys00101(Model model) {
    return VIEW_PATH;
  }

  /**
   * ログイン
   * 
   * @param formData
   * @param bindingResult
   * @param model
   * @return
   */
  @PostMapping("sys00103")
  public String sys00103(@Validated SYS001Form formData, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return sys00101(model);
    }

    SYS00103InputBean inputBean = new SYS00103InputBean();
    inputBean.setUserId(formData.getUserId());
    inputBean.setPassword(formData.getPassword());

    SYS00103OutputBean outputBean = new SYS00103OutputBean();
    try {
      outputBean = sys00103Service.sys00103(inputBean);
    } catch (DocotsubuBusinessException e) {
      model.addAttribute("error", e.getMessage());
      return sys00101(model);
    }

    userBean.setUserId(outputBean.getUserId());
    userBean.setPrvsrl(outputBean.getPrvsrl());

    return "redirect:/sys002/sys00201";
  }
}
