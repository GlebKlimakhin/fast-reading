package com.axioma.axiomatrainee.api;

import com.axioma.axiomatrainee.model.exercises.Exercise;
import com.axioma.axiomatrainee.model.exercises.ExerciseType;
import com.axioma.axiomatrainee.service.exercises.ExerciseService;
import com.axioma.axiomatrainee.service.exercises.RandomExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/reading")
public class ReadingSpeedExerciseController {

    private ExerciseService exerciseService;
    private RandomExerciseService randomExerciseService;

    public static final ExerciseType TYPE = ExerciseType.READING_SPEED;


    @Autowired
    public void setService(ExerciseService service, RandomExerciseService randomExerciseService) {
        this.exerciseService = service;
        this.randomExerciseService = randomExerciseService;
    }

//    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Exercise> findAll() {
        return exerciseService.findAllByType(TYPE);
    }

//    @PreAuthorize("hasAuthority('admin:write')")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Exercise findById(@PathVariable Long id) {
        return exerciseService.findById(id, TYPE).orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Long id) {
        exerciseService.findAllByType(TYPE).forEach(e -> {
            if(e.getId().equals(id)) {
                exerciseService.deleteById(id);
            }
        });
        exerciseService.findAll();
    }

    @GetMapping("/random/")
    public Exercise findRandomByUserId(Long userId) {
        return randomExerciseService.findRandomByUserId(userId, TYPE);
    }

}
