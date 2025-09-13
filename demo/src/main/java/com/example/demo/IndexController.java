package com.example.demo;

import com.example.demo.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", tasks);
        return "index.html";
    }

    private List<Task> tasks = new ArrayList<>();

    @ResponseBody
    @PostMapping("/addTask")
    public String addTask(@RequestParam String name) {
        int id = tasks.size() + 1;

        Task newTask = new Task(id, name);
        tasks.add(newTask);

        return "Task added: " + name;
    }
}
