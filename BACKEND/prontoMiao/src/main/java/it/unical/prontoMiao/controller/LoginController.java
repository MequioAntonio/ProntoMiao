package it.unical.prontoMiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}