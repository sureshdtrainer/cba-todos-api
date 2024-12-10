package au.com.cba.services.impl;

import au.com.cba.models.Todo;
import au.com.cba.repositories.TodosRepository;
import au.com.cba.services.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodosServiceDBImpl implements TodosService {
    @Autowired
    private TodosRepository todosRepository;

    @Override
    public Todo saveTodo(Todo todo) {
        return null;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todosRepository.findAll();
    }

    @Override
    public Todo getTodoById(int id) {
        return null;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        return null;
    }

    @Override
    public boolean deleteTodo(int id) {
        return false;
    }
}
