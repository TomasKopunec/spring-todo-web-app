package com.kopunec.springweb.application.todo;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
@Slf4j
public class TodoController {

    TodoRepository todoRepository;

    @GetMapping("todos")
    public String showTodos(ModelMap map) {
        map.addAttribute("todos", todoRepository.findByUserName(getLoggedInUsername()));
        return "todos";
    }

    @GetMapping("add-todo")
    public String addTodo(ModelMap map) {
        map.addAttribute("todo", new Todo(
                0,
                getLoggedInUsername(),
                "",
                LocalDate.now().plusYears(1),
                false
        ));
        return "todo";
    }

    @PostMapping("add-todo")
    public String addTodoPost(ModelMap map, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getAllErrors().forEach(e -> sb.append(e.getDefaultMessage()).append("\n"));
            map.addAttribute("error", sb.toString());
            return "todo";
        }

        todo.setUserName(getLoggedInUsername());
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam Integer id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

    @GetMapping("edit-todo")
    public String editTodo(ModelMap map, @RequestParam Integer id) {
        map.addAttribute("todo", todoRepository.findById(id).get());
        return "editTodo";
    }

    @PostMapping("edit-todo")
    public String putTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getAllErrors().forEach(e -> sb.append(e.getDefaultMessage()).append("\n"));
            map.addAttribute("error", sb.toString());
            return "todo";
        }

        todo.setUserName(getLoggedInUsername());
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    private String getLoggedInUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
