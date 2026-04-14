package com.emcaras.cv_spring_boot.cv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/skills")
public class SkillsController {
    
    @GetMapping({"","/"})
    public String getSkills(Model model){
        String skills[] = {};
        model.addAttribute("skills", skills);
        
        return "skills";
    }
}
