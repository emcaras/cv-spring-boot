package com.emcaras.cv_spring_boot.cv.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Person {
    @Value("${person.firstname}")
    private String firstName;

    @Value("${person.lastname}")
    private String lastName;

    @Value("${person.profession}")
    private String profession;
}
