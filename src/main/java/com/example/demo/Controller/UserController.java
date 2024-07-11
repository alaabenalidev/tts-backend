package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public String addUser(@RequestBody User u) {
        userService.addUser((org.springframework.security.core.userdetails.User) u);
        return "success add user";
    }

    @DeleteMapping("/idUser")
    public String deleteUser(@PathVariable("id") Integer idUser) {
        userService.deleteUser(idUser);
        return "success delete User";
    }

    @PutMapping("/idUser")
    public String updateUser(@PathVariable("id") Integer idUser, @RequestBody User User) {
        userService.updateUser(idUser, (org.springframework.security.core.userdetails.User) User);
        return "success update User";
    }


    @GetMapping("/get/{idUser}")
    public User getUser(@PathVariable Integer idUser) {
        return (User) userService.getUser(idUser);

    }

    @GetMapping("/fetchAll")
    public String getAllUser() {
        userService.getAllUser();
        return "success get all User";
    }
}
