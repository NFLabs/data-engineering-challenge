package com.jihoon.service;

import com.jihoon.model.Task;
import com.jihoon.model.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getTodos();
    public Todo createTodo(String name);
    public List<Task> getTasks(String todoId);
    public Task createTask(String todoId, String name, String description);
    public Task getTask(String taskId);
    public List<Task> getTasksDone(String todoId);
    public List<Task> getTasksNotDone(String todoId);
}
