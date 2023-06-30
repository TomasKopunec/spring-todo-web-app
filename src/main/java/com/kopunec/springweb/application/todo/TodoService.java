package com.kopunec.springweb.application.todo;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<>(List.of(
            new Todo(
                    "1",
                    "in28minutes",
                    "Learn Spring MVC",
                    LocalDate.now().plusYears(1),
                    false
            ),
            new Todo(
                    "2",
                    "in28minutes",
                    "Learn Struts",
                    LocalDate.now().plusYears(2),
                    false
            ),
            new Todo(
                    "3",
                    "in28minutes",
                    "Learn Hibernate",
                    LocalDate.now().plusYears(3),
                    false
            )
    ));

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate dateTime) {
        todos.add(new Todo(
                String.valueOf(todos.size() + 1),
                username,
                description,
                dateTime,
                false
        ));
    }
}
