package com.emcaras.cv_spring_boot.cv.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Schema(example = "Java")
    private String name;

    @Schema(example = "Senior")
    private String level;
}
