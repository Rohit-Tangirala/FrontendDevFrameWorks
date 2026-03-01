package com.studentprofile.Student_CRUD.controller;


import com.studentprofile.Student_CRUD.model.User;
import com.studentprofile.Student_CRUD.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "users";
    }

    @GetMapping("/addUserForm")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUserForm/{id}")
    public String updateUserForm(@PathVariable Long id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "add-user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/exit")
    public String exitPage() {
        return "redirect:/";
    }
}
