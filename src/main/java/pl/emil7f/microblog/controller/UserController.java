package pl.emil7f.microblog.controller;

import org.springframework.web.bind.annotation.*;
import pl.emil7f.microblog.model.User;
import pl.emil7f.microblog.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.findAllUsers();
    }


}
