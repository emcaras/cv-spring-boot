package com.emcaras.cv_spring_boot.cv.rest;

import com.emcaras.cv_spring_boot.cv.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CvApiController {
    @GetMapping("/person")
    public Person getPerson(){
        return new Person("Emiliano", "Carranza", "Engineer");
//        return new Person("Emiliano", "Carranza", "Engenieer");
    }
}
