package au.com.cba.services.impl;

import au.com.cba.exceptions.ResourceNotFoundException;
import au.com.cba.models.Todo;
import au.com.cba.services.TodosService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Service
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
        todo.setId(++todosCount);
        todos.add(todo);
        return todo;
        }

    @Override
    public List<Todo> getAllTodos() {
        return todos;
    }

    @Override
    public Todo getTodoById(int id) throws ResourceNotFoundException{
        for(Todo todo: todos){
            if(todo.getId()== id)
                return todo;
        }
        throw new ResourceNotFoundException("todos", "id", id);
    }

    @Override
    public Todo updateTodo(int id, Todo todo) throws ResourceNotFoundException{
        Todo existingTodo = this.getTodoById(id);
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setTargerDate(todo.getTargerDate());
        existingTodo.setDone(todo.isDone());
        return existingTodo;
    }

    @Override
    public boolean deleteTodo(int id) {
        for(int i=0; i< todos.size(); i++){
            if(todos.get(i).getId() == id){
                todos.remove(i);
                return true;
            }
        }
        return false;
    }
}
