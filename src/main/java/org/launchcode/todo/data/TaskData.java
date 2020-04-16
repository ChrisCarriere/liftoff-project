package org.launchcode.todo.data;

import org.launchcode.todo.models.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TaskData {

    private static final Map<Integer, Task> tasks = new HashMap<>();

    public static void add(Task task){
        tasks.put(task.getId(), task);
    }

    public static Task getById(int id){
        return tasks.get(id);
    }

    public static Collection<Task> getAll(){
        return tasks.values();
    }

    public static void remove(int id){
        tasks.remove(id);
    }


}
