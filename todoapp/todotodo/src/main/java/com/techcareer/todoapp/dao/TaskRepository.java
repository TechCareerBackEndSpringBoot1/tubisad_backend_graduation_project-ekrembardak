package com.techcareer.todoapp.dao;

import com.techcareer.todoapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    void deleteTasksByStatus(String status);

    List<Task> getAllByStatus(String status);

}
