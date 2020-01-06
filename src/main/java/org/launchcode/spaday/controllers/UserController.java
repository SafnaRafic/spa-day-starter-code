package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
//    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("title", "All Events");
//        model.addAttribute("users", UserData.getAll());
//        return "user/index";
//    }
    @GetMapping("add")
    public String displayAddUserForm(){

        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        if((user.getPassword()).equals(verify)){

            model.addAttribute("title","Welcome "+user.getUsername()+"!");
            UserData.add(user);
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        }
        else {
            model.addAttribute("title","Password does not match");
            model.addAttribute("userName",user.getUsername());
            model.addAttribute("emailID",user.getEmail());
            return "user/add";
        }
    }

//    @PostMapping("index")
//    public String showDetails(Model model,@ModelAttribute UserData user, @PathVariable int id){
//        for(int i=0;i<)
//        if((user.getId()).equals(id)){
//            model.addAttribute("userName",user.getUsername());
//            model.addAttribute("email",user.getEmail());
//        }
//        return "user/details";
//    }

}
