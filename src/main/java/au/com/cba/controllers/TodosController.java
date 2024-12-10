package au.com.cba.controllers;

import au.com.cba.models.Todo;
import au.com.cba.services.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodosController {

    @Autowired
    private TodosService todosService;

    @GetMapping("todos")
    public List<Todo> getAllTodos(){
        return todosService.getAllTodos();
    }

    @GetMapping("todos/{id}")
    public Todo getTodoById(@PathVariable int id){
        return todosService.getTodoById(id);
    }
}
