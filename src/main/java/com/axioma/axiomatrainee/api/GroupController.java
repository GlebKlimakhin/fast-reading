package com.axioma.axiomatrainee.api;

import com.axioma.axiomatrainee.model.Group;
import com.axioma.axiomatrainee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {


    private GroupService groupService;

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group findById(@PathVariable Long id) {
        return groupService.findById(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Group> findAll() {
        return groupService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Group save(@RequestParam Group group) {
        return groupService.save(group);
    }

    @GetMapping("/name={name}")
    @ResponseStatus(HttpStatus.OK)
    public Group findByName(@PathVariable String name){
        return groupService.findByName(name);
    }

    @GetMapping("/userid={userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Group> findAllByUserId(@PathVariable Long userId) {
        return groupService.findAllByUserId(userId);
    }

    @PutMapping("/insert/groupId={groupId}&userId={userId}")
    @ResponseStatus(HttpStatus.OK)
    public Group insertUserIntoGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        return groupService.insertUserIntoGroup(groupId, userId);
    }

    @PutMapping("/delete/groupId={groupId}&userId={userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserFromGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        groupService.deleteUserFromGroup(groupId, userId);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        groupService.deleteGroupById(id);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Group addHomework(@RequestParam Long groupId, @RequestParam Long homeworkId) {
        return groupService.setHomeworks(groupId, homeworkId);
    }
}
