package com.techcareer.todoapp.service;

import com.techcareer.todoapp.entity.Task;

import java.util.List;

public interface TaskService {
    boolean createTask(String description);
    boolean updateDescription(Long id, String description);
    boolean updateStatus(Long id);
    Task getTaskById(Long id);
    List<Task> getAll();
    boolean deleteTaskById(Long id);

    boolean deleteAllTasks();

    boolean deleteTasksByStatusDone();

    List<Task> getAllByStatus(String status);

}
