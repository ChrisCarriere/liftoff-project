package org.launchcode.todo.controllers;


import org.launchcode.todo.data.TaskData;
import org.launchcode.todo.models.Task;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("task")
public class TaskController {

    @GetMapping
    public String displayTodoList(Model model){
        model.addAttribute("tasks", TaskData.getAll());
        return "task/index";
    }

    @GetMapping("create")
    public String renderCreateTaskForm(){
        return "task/create";
    }

    @PostMapping("create")
    public String createTask(@RequestParam String taskName, @RequestParam Number taskPriority){
        TaskData.add(new Task(taskName, taskPriority));
        return "redirect:";
    }

}
