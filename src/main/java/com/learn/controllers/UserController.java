package com.learn.controllers;

import com.learn.models.User;
import com.learn.repo.UserRepository;
import com.learn.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    //all users
    @GetMapping("/")
    public List<User> getAllUsers(HttpSession httpSession) {
        return this.userService.getAllUsers();
    }

    //return single user
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{username}")
    public User getUser(@PathVariable String username, HttpSession httpSession) {
        User user = this.userRepository.findByUsername(username);
        if (httpSession.getAttribute("tenantName") == null) {
            log.info("Getting tenant name for " + user.getUsername());
            httpSession.setAttribute("tenantName", user.getTenantName());
        } else {
            log.info("User's tenant name is" + user.getTenantName());
        }
        return user;
    }

    // add user
    @PostMapping("/")
    public User add(@RequestBody User user) {
        return this.userService.addUser(user);
    }
}
