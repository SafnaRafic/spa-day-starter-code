package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model ) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user,
                                     Errors errors) {
        //@NotNull(message = "Need to verify") @NotEmpty(message = "Need to verify") String verify,
        if(errors.hasErrors()) {
            return "user/add";
        }
//        } else if(user.getPassword().equals(verify)){
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }
        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
        return "user/index";
    }
}
