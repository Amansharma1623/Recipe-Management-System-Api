package com.Geekster.Recipe.management.system.API.Controller;

import com.Geekster.Recipe.management.system.API.Model.User;
import com.Geekster.Recipe.management.system.API.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("user/signup")
    public String userSignUp(@Valid @RequestBody User newUser)
    {
        return userService.userSignUp(newUser);
    }

    //sign in
    @PostMapping("user/signIn/{email}/{password}")
    public String userSignIn(@PathVariable String email, @PathVariable String password)
    {
        return userService.userSignIn(email,password);
    }
}
