package org.launchcode.todo.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Task extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 50, message = "name must be between 3 and 50 characters")
    private String name;
    private Number priority;

    public Task(String name, Number priority){
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

    public Number getPriority() {
        return priority;
    }

    public void setPriority(Number priority) {
        this.priority = priority;
    }
}