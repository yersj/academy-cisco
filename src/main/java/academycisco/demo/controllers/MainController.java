package academycisco.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/signin")
    public String signIn(){
        return "signin";
    }


    @GetMapping(value = "/profile")
    public String profilePage(){
        return "profile";
    }


}
