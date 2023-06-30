package com.kopunec.springweb.application.todo;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@Controller
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("todos")
    public String showTodos(ModelMap map) {
        map.addAttribute("todos", todoService.findByUsername("in28minutes"));
        return "todos";
    }

    @GetMapping("add-todo")
    public String addTodo() {
        return "todo";
    }

    @PostMapping("add-todo")
    public String addTodoPost(@RequestParam String description, ModelMap map) {
        todoService.addTodo(
                (String) map.get("name"),
                description,
                LocalDate.now().plusYears(2)
        );
        return "redirect:/todos";
    }
}
