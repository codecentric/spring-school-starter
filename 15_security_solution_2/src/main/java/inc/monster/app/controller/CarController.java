package inc.monster.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@Secured({ "ROLE_USER" })
public class CarController {

    @RequestMapping("/car/index")
    public String carIndex() {
        return "car/index";
    }

    @RequestMapping("/car/edit")
    @Secured({ "ROLE_ADMIN" })
    public String carEdit() {
        return "car/edit";
    }

    @RequestMapping("/status")
    public String status() {
        return "status";
    }


}
