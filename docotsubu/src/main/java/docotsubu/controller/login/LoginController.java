package docotsubu.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import docotsubu.controller.login.bean.LoginForm;
import docotsubu.service.login.LoginService;
import docotsubu.service.login.bean.LoginInputBean;

@Controller
@RequestMapping("login")
public class LoginController {


  private static final String VIEW_PATH = "login/login";

  @Autowired
  private LoginService loginService;

  @GetMapping("index")
  public String index(Model model) {
    return VIEW_PATH;
  }


  @PostMapping("login")
  public String login(@Validated LoginForm formData, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return index(model);
    }

    LoginInputBean inputBean = new LoginInputBean();
    inputBean.setUserId(formData.getUserId());
    inputBean.setPassword(formData.getPassword());


    try {
      loginService.login(inputBean);
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
      return index(model);
    }

    return "redirect:/docotsubu/main";
  }
}
