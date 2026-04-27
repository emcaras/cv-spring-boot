package com.emcaras.cv_spring_boot.cv.controller;

import com.emcaras.cv_spring_boot.cv.model.Skill;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/skills")
public class SkillsController {

    private final List<Skill> skills = new ArrayList<>();
    private List<Skill> filteredSkills = new ArrayList<>();

//    @GetMapping({"","/"})
//    public String showSkills(){
//        return "skills";
//    }
    @GetMapping({"", "/"})
    public String showSkills(@RequestParam(defaultValue = "", required = false) String filter, Model model) {

        this.filteredSkills = this.skills.stream()
                .filter(skill -> skill.getName().toLowerCase().contains(filter.toLowerCase()))
                .toList();
        model.addAttribute("skills", filteredSkills);
        return "skills";
    }

    @GetMapping("/{id}")
    public String showSkillDetail(@PathVariable int id, Model model) {
        if (id >= 0 && id < this.skills.size()) {
            model.addAttribute("skill", this.skills.get(id));
            return "skill-detail";
        }
        return "redirect:/skills";
    }
    
    @GetMapping("/{nombre}")
    public String getSkillsByNombre(@PathVariable String nombre, Model model){
        List<Skill> filteredSkills = this.skills.stream()
                .filter(skill -> skill.getName().equalsIgnoreCase(nombre)).toList();
        model.addAttribute("skills", filteredSkills);
        return "skills";
    }

    @GetMapping("/{name}/{level}")
    public String getFilteredSkill(@PathVariable String name, @PathVariable String level, Model model) {
        List filteredList = this.skills.stream()
                .filter(skill -> skill.getName().equalsIgnoreCase(name)
                && skill.getLevel().equalsIgnoreCase(level)
                )
                .toList();
        model.addAttribute("skills", filteredList);
        return "skills";
    }
    

    @ModelAttribute(name = "skills")
    public List<Skill> getSkills() {
        return this.skills;
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "add-skill";
    }

    @PostMapping("/add")
    public String addSkill(@ModelAttribute Skill skill) {
        this.skills.add(skill);
        return "redirect:/skills";
    }

}
