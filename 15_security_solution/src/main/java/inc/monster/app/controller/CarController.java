package inc.monster.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarController {

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/car/index")
    public String carIndex() {
        return "car/index";
    }

    @RequestMapping("/car/edit")
    public String carEdit() {
        return "car/edit";
    }

    @RequestMapping("/status")
    public String status() {
        return "status";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
