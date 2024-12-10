package au.com.cba.services.impl;

import au.com.cba.exceptions.ResourceNotFoundException;
import au.com.cba.models.Todo;
import au.com.cba.repositories.TodosRepository;
import au.com.cba.services.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodosServiceDBImpl implements TodosService {
    @Autowired
    private TodosRepository todosRepository;

    @Override
    public Todo saveTodo(Todo todo) {
        return todosRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todosRepository.findAll();
    }

    @Override
    public Todo getTodoById(int id) {
        /*Optional<Todo> todo = todosRepository.findById(id);
        if(todo.isPresent())
            return todo.get();
        throw new ResourceNotFoundException("todos", "id",id);*/
        return todosRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("todos", "id", id));
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
       Todo existingTodo = todosRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("todos", "id", id));
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setTargerDate(todo.getTargerDate());
        existingTodo.setDone(todo.isDone());
        //save to db
        todosRepository.save(existingTodo);
        return existingTodo;
    }

    @Override
    public boolean deleteTodo(int id) {
        todosRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("todos", "id", id));
        todosRepository.deleteById(id);
        return true;
    }
}
