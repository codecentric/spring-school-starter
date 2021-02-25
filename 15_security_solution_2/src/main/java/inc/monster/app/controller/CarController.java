package inc.monster.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@PreAuthorize("hasRole('USER')")
public class CarController {

    @RequestMapping("/car/index")
    public String carIndex() {
        return "car/index";
    }

    @RolesAllowed({"ADMIN"})
    @RequestMapping("/car/edit")
    public String carEdit() {
        return "car/edit";
    }

    @RequestMapping("/status")
    public String status() {
        return "status";
    }


}
