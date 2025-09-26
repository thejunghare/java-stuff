package com.example.demo;

import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            return ResponseEntity.ok(existingTask.get());
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Task with ID " + id + " not found.");
    }

    /*
     * @GetMapping
     * public List<Task> getAllTasks() {
     * return entityManager.createQuery("SELECT * FROM Task t",
     * Task.class).getResultList();
     * }
     */

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }


//      @PutMapping("/{id}")
//     public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody
//      Task taskData) {
//     System.out.println("Trying to update task with ID: " + id);
//
//      Task existingTask = taskRepository.findById(id).orElse(null);
//
//      if (existingTask == null) {
//      System.out.println("Task not found!");
//      return ResponseEntity.notFound().build();
//      }
//
//     existingTask.setName(taskData.getName());
//      Task updatedTask = taskRepository.save(existingTask);
//
//      return ResponseEntity.ok(updatedTask);
//     }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);

        if (existingTask.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Task with ID " + id + " not found.");
        }

        task.setId(id);
        Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);

        if (existingTask.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Task with ID " + id + " not found.");
        }

        taskRepository.deleteById(id);

        return ResponseEntity
                .ok("Task with ID " + id + " has been deleted successfully.");
    }

}
