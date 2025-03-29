package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


import web.model.User;

import web.servise.UserService;



@Controller
@RequestMapping("/users")
public class UserController {



    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "user-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/add")
    public String addUser (@RequestParam(value = "name") String name, @RequestParam(value = "lastName")
    String lastName, @RequestParam(value = "age") Integer age) {
        User user = new User(name, lastName, age);
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam(value = "id",required = false) Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user-edit-form";
    }

    @PostMapping("/edit")
    public String editUser (@RequestParam(value = "name") String name, @RequestParam(value = "lastName")
            String lastName, @RequestParam(value = "age") Integer age,@RequestParam(value = "id",required = false) Integer id ) {
        User user = new User(name, lastName, age);
        userService.updateUser(id,user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser (@RequestParam(value = "id",required = false) Integer id) {
        userService.deleteUser (id);
        return "redirect:/users";

    }
}




