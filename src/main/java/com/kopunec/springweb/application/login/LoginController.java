package com.kopunec.springweb.application.login;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Slf4j
@AllArgsConstructor
@SessionAttributes("name")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoginController {

    AuthenticationService authService;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String loginPost(@RequestParam String username, @RequestParam String password, ModelMap map) {
        if(authService.authenticate(username, password)) {
            map.addAttribute("username", username);
            return "welcome";
        }

        map.addAttribute("errorMessage", "Invalid Credentials. Please try again.");
        return "login";
    }
}
