package com.techcareer.todoapp.controller;

import com.techcareer.todoapp.dao.TaskRepository;
import com.techcareer.todoapp.entity.Task;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@org.springframework.stereotype.Controller
@Log4j2

public class Controller {

    @Autowired
    TaskRepository taskRepository;

    //save
    // http://localhost:8080/tasks/save
    @GetMapping("/tasks/save")
    public String saveTask(){
        int i;
        Task task = new Task();
        for (i = 0; i < 10; i++){
            task.setDescription("yapılacak " + i);
            taskRepository.save(task);
        }
        return i + "adet task kaydedildi" ;

    }

    //Listeleme
    // http://localhost:8080/tasks/list
    @GetMapping("/tasks/list")
    public String getAllTasks(Model model){
        List<Task> list =  taskRepository.findAll();
        model.addAttribute("task_key",list);
        return "task_list";
    }

    //find
    // http://localhost:8080/tasks/find/task/1
    @GetMapping("/tasks/find/task/{id}")
    public String findTaskById (@PathVariable Long id, Model model){
        Task task = taskRepository.getById(id);
        model.addAttribute("task_details", task);
        return "task_detail_pages";

    }

    // http://localhost:8080/tasks/form
    @GetMapping("/tasks/form")
    public String getForm(Model model){
        model.addAttribute("task_save", new Task());
        return "task_save";
    }

    // http://localhost:8080/tasks/form
    @PostMapping("/tasks/form")
    public String postForm(@ModelAttribute("task_save") Task task, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "task_save";
        }
        Task newTask = new Task();
        newTask.setDescription(task.getDescription());
        newTask.setStatus("undone");
        taskRepository.save(newTask);
        return "redirect:/tasks/list" ;
    }

    // http://localhost:8080/tasks/delete/1
    @GetMapping("/tasks/delete/{id}")
    public String deleteTaskById(@PathVariable Long id, Model model) {
        Task task = taskRepository.getById(id);
        taskRepository.deleteById(id);
        model.addAttribute("delete_success", task);
        return "redirect:/tasks/list" ;
    }

    //http://localhost:8080/tasks/update/1
    @PostMapping("/tasks/update/{id}")
    public String taskUpdate(@PathVariable Long id, Model model) {
        Task task = taskRepository.getById(id);
        System.out.println("id: " + id);
        model.addAttribute("task_save", task);
        return "redirect:/tasks/list";
    }

    @GetMapping("/somePostAction")
    public String somePostAction(Model model, RedirectAttributes redirectAttributes){
        if(true) {
            redirectAttributes.addFlashAttribute("error", "The error XYZ occurred");
            return "redirect:/tasks/list";
        }
        redirectAttributes.addFlashAttribute("success", "Everything went just fine");
        return "redirect:/tasks/list";
    }

}
