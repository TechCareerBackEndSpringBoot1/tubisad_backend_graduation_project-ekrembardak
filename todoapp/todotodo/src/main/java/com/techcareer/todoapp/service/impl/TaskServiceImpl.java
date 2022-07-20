package com.techcareer.todoapp.service.impl;

import com.techcareer.todoapp.dao.TaskRepository;
import com.techcareer.todoapp.entity.Task;
import com.techcareer.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public boolean createTask(String description) {
        try{
            Task task = new Task();
            task.setDescription(description);
            task.setStatus("undone");
            taskRepository.save(task);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateDescription(Long id, String description) {
        try{
            Task task = taskRepository.getById(id);
            task.setDescription(description);
            taskRepository.save(task);
            return true;

        }catch(Exception e){
            return false;
        }

    }

    @Override
    public boolean updateStatus(Long id) {
        try{
            Task task = taskRepository.getById(id);
            task.setStatus("done");
            taskRepository.save(task);
            return true;

        }catch(Exception e){
            return false;
        }

    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public boolean deleteTaskById(Long id) {
        try{
            taskRepository.deleteById(id);
            return true;

        }catch(Exception e){
            return false;

        }

    }

    @Override
    public boolean deleteAllTasks() {
        try{
            taskRepository.deleteAll();
            return true;

        }catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean deleteTasksByStatusDone() {
        try{
            taskRepository.deleteTasksByStatus("done");
            return true;

        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public List<Task> getAllByStatus(String status) {
        return taskRepository.getAllByStatus(status);

    }
}
