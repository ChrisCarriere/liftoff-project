package org.launchcode.todo.controllers;


import org.launchcode.todo.models.Task;
import org.launchcode.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public String displayTodoList(Model model){
        model.addAttribute("tasks", taskRepository.findAll());
        return "task/index";
    }

    @GetMapping("create")
    public String renderCreateTaskForm(Model model){
        model.addAttribute("title", "Create Task");
        model.addAttribute(new Task());
        return "task/create";
    }

    @PostMapping("create")
    public String createTask(@ModelAttribute @Valid Task newTask, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("title", "Create Task");
            return "task/create";
        }

        taskRepository.save(newTask);
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("tasks", taskRepository.findAll());
        return "task/delete";
        }

    @PostMapping("delete")
    public String deleteTask(@RequestParam(required = false) int[] taskIds){

        if(taskIds != null) {
            for (int id : taskIds) {
                taskRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}

