package org.launchcode.todo.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class Task extends AbstractEntity {



    @NotBlank(message = "Task is required")
    @Size(min = 3, max = 50, message = "Task must be between 3 and 50 characters.")
    private String name;

    @Min(1)
    @Max(5)
    private Integer priority;



    public Task(String name, Integer priority){
        this.name = name;
        this.priority = priority;
    }

    public Task(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }


}