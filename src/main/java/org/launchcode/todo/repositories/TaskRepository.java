package org.launchcode.todo.repositories;

import org.launchcode.todo.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}