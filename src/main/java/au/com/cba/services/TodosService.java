package au.com.cba.services;

import au.com.cba.models.Todo;

import java.util.List;

public interface TodosService {
    Todo saveTodo(Todo todo);
    List<Todo> getAllTodos();
    Todo getTodoById();
}
