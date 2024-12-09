package au.com.cba.services.impl;

import au.com.cba.models.Todo;
import au.com.cba.services.TodosService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodosServiceInMemoryDBImpl implements TodosService {
    private static List<Todo> todos= new ArrayList<>();
    private static int todosCount=3;

    static {
        todos.add(new Todo(1, "Learn SpringBoot", new Date(), false));
        todos.add(new Todo(2, "Learn SpringJPA", new Date(), false));
        todos.add(new Todo(3, "Learn Automated Testing", new Date(), false));
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return null;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todos;
    }

    @Override
    public Todo getTodoById() {
        return null;
    }
}
