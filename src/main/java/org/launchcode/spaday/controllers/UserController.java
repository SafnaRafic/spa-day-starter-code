package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";
    }
    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        System.out.println(user.getPassword());
        System.out.println(verify);

        if((user.getPassword()).equals(verify)){

            model.addAttribute("title","Welcome "+user.getUsername()+"!");
            return "user/index";
        }
        else {
            model.addAttribute("title","Password does not match");
            model.addAttribute("userName",user.getUsername());
            model.addAttribute("emailID",user.getEmail());
            return "user/add";
        }
    }

}
