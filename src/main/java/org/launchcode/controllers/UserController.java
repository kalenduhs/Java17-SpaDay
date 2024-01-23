package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayUsers(Model model, @RequestParam(required = false) String value) {
        model.addAttribute("users", UserData.getAll());
            return"user/index";
    }

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "user/add";
    }
    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if (user.getPassword().equals(verify)) {
            UserData.add(user);
            return "redirect:/user";
        } else {
            model.addAttribute("error", "Please Enter the Same Password");
            return "user/add";
        }
    }
}
