package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.entity.Dto.SubmitRequestDTO;
import com.example.demo.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public String addUser(@RequestBody User u) {
        userService.addUser(u);
        return "success add user";
    }

    @PostMapping("/request/submit")
    public String submitRequest(@RequestBody SubmitRequestDTO u) {
        userService.submitRequestUser(u);
        return "success add user";
    }

    @GetMapping("requests")
    public ResponseEntity<List<com.example.demo.security.user.User>> getRequestUsers() {
        return ResponseEntity.ok(userService.getRequestUsers());
    }

    @DeleteMapping("/idUser")
    public String deleteUser(@PathVariable("id") Integer idUser) {
        userService.deleteUser(idUser);
        return "success delete User";
    }

    @PutMapping("/idUser")
    public String updateUser(@PathVariable("id") Integer idUser, @RequestBody User user) {
        userService.updateUser(idUser, user);
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
