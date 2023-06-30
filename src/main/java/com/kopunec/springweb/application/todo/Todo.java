package com.kopunec.springweb.application.todo;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Todo {
    String id;
    String userName;
    String description;
    LocalDate targetDate;
    boolean isDone;
}
