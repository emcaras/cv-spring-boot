package com.emcaras.cv_spring_boot.cv.controller;

import com.emcaras.cv_spring_boot.cv.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cv") //ruta base
public class CvController {
    
    @GetMapping({"", "/", "/index"})
    public String index(Model model){
        Person person = new Person("Em", "Carranza", "Engineer");
        model.addAttribute("person", person);
        return "index";
    }
    
    @GetMapping({"/home", "/dashboard", "/inicio"})
    public String pep(){
        return "pep";
    }
    
}
