package com.ecommerce.project.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminAuthController {
    @GetMapping("login")
    public String getLoginPage()
    {
        return "login";
    }
}
