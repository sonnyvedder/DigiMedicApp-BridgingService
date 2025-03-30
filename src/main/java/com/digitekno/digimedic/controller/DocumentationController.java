package com.digitekno.digimedic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentationController {
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/docs")
    public String documentation() {
        return "documentation";
    }
}