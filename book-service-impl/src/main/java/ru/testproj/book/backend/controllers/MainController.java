package ru.testproj.book.backend.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testproj.book.backend.entity.User;
import ru.testproj.book.backend.service.impl.UserService;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MainController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/unseccured")
    public String unsecuredDate() {
        return "Unsecured data";
    }

    @GetMapping("/seccured")
    public String securedDate() {
        return "Secured data";
    }

    @GetMapping("/admin")
    public String adminDate() {
        return "Admin data";
    }

    @GetMapping("/info")
    public String userDate(Principal principal) {
            Optional<User> user = userService.findByUsername(principal.getName());
        return "Пользователь " + user.get().getUsername() + " почта " + user.get().getEmail();
    }


}
