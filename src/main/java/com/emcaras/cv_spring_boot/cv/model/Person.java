package com.emcaras.cv_spring_boot.cv.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    @Schema(example = "Emiliano")
    private String firstName;
    
    @Schema(example = "Carranza")
    private String lastName;
    
    @Schema(example = "Software Developer")
    private String profession;
}
