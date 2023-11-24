package ru.testproj.book.backend.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/unseccured")
    public String unsecuredDate(){
        return "Unsecured data";
    }

    @GetMapping("/seccured")
    public String securedDate(){
        return "Secured data";
    }

    @GetMapping("/admin")
    public String adminDate(){
        return "Admin data";
    }

    @GetMapping("/info")
    public String userDate(Principal principal){
        return principal.getName();
    }



}
