package com.axioma.axiomatrainee.api;


import com.axioma.axiomatrainee.model.Homework;
import com.axioma.axiomatrainee.requestdto.CreateHomeworkRequestDto;
import com.axioma.axiomatrainee.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homeworks")
public class HomeworkController {

    private HomeworkService homeworkService;

    @Autowired
    public void setHomeworkService(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @PostMapping("/")
    public Homework create(@RequestBody CreateHomeworkRequestDto request) {
        return homeworkService.createHomework(request);
    }
}
