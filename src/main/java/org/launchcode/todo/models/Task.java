package org.launchcode.todo.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class Task extends AbstractEntity {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Task is required")
    @Size(min = 3, max = 50, message = "Task must be between 3 and 50 characters.")
    private String name;

    @Min(1)
    @Max(5)
    private Number priority;

    public Task(String name, Number priority){
        this.name = name;
        this.priority = priority;
        this.id = nextId;
        nextId++;
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}