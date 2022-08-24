package com.axioma.axiomatrainee.service.exercises;

import com.axioma.axiomatrainee.model.exercises.DoneExercise;
import com.axioma.axiomatrainee.model.exercises.Exercise;
import com.axioma.axiomatrainee.model.exercises.ExerciseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandomExerciseService {

    private ExerciseService exerciseService;
    private DoneExerciseService doneExerciseService;

    @Autowired
    public RandomExerciseService(ExerciseService exerciseService, DoneExerciseService doneExerciseService) {
        this.exerciseService = exerciseService;
        this.doneExerciseService = doneExerciseService;
    }

    public Exercise findRandomByUserId(Long userId, ExerciseType type) {
        List<Exercise> all = exerciseService.findAllByType(type);
        List<DoneExercise> doneByUser = doneExerciseService.findAllByUserId(userId);
        return removeDoneExercises(all, doneByUser).stream().findFirst()
                .orElseThrow(() -> new RuntimeException("You have done everything!"));
    }
    
    private List<Exercise> removeDoneExercises(List<Exercise> exercises, List<DoneExercise> done) {
        for (int i = 0; i < exercises.size(); i++) {
            for (int j = 0; j < done.size(); j++) {
                if(exercises.get(i).getId().equals(done.get(j).getDoneExerciseId().getExerciseId())) {
                    exercises.remove(i);
                }
            }
        }
        return exercises;
    }
}
