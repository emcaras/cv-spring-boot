package com.emcaras.cv_spring_boot.cv.rest;

import com.emcaras.cv_spring_boot.cv.model.ApiResponse;
import com.emcaras.cv_spring_boot.cv.model.Skill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private List<Skill> skills = new ArrayList<>();

    @PostMapping()
    public Skill addSkill(@RequestBody() Skill skill) {
        this.skills.add(skill);
        return skill;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Skill>>> getSkills(@RequestParam(required = false, defaultValue = "") String filter) {
        if (filter.isBlank()) {
            return ResponseEntity.ok(new ApiResponse<List<Skill>>(true, "Petición realizada correctamente.", this.skills ));
        }

        if (filter.matches("[0-9]+")) {
            int index = Integer.parseInt(filter);
            if (index >= 0 && index < this.skills.size()) {
                return ResponseEntity.ok(new ApiResponse<List<Skill>>(false, "Petición realizada correctamente", Collections.singletonList(this.skills.get(index))));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<List<Skill>>(false, "El id " + index + " no existe.", Collections.emptyList()));
        }

        return ResponseEntity.ok(new ApiResponse<List<Skill>>(true, "Petición realizada correctamente", this.skills.stream()
                .filter(skill -> skill.getName().equalsIgnoreCase(filter))
                .toList()));
    }
}
