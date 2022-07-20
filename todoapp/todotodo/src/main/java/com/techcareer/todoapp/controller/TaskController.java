/*
package com.techcareer.todoapp.controller;

import com.techcareer.todoapp.entity.Task;
import com.techcareer.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    public TaskService taskService;
    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        return new ResponseEntity(taskService.getAll(), HttpStatus.OK);

    }
    @PostMapping("/{description}")
    public ResponseEntity createTask(@PathVariable String description){
        return new ResponseEntity(taskService.createTask(description), HttpStatus.CREATED);

    }
    @PutMapping("/description/{id}")
    public ResponseEntity updateDescription(@PathVariable Long id, @RequestParam String description){
        return new ResponseEntity(taskService.updateDescription(id, description), HttpStatus.ACCEPTED);

    }
    @PutMapping("/status/{id}")
    public ResponseEntity updateStatus(@PathVariable Long id){
        return new ResponseEntity(taskService.updateStatus(id), HttpStatus.ACCEPTED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTaskById(@PathVariable Long id){
        return new ResponseEntity(taskService.deleteTaskById(id), HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/all")
    public ResponseEntity deleteAllTasks(){
        return new ResponseEntity(taskService.deleteAllTasks(), HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/alldone")
    public ResponseEntity deleteTasksByStatusDone(){
        return new ResponseEntity(taskService.deleteTasksByStatusDone(), HttpStatus.ACCEPTED);

    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getAllByStatus(@PathVariable String status){
        return new ResponseEntity<>(taskService.getAllByStatus(status), HttpStatus.ACCEPTED);
    }
} */
