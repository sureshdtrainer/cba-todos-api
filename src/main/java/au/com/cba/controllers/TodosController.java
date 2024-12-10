package au.com.cba.controllers;

import au.com.cba.exceptions.ResourceNotFoundException;
import au.com.cba.models.Todo;
import au.com.cba.services.TodosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodosController {

    Logger logger= LoggerFactory.getLogger(TodosController.class);

    @Autowired
    private TodosService todosService;

    @GetMapping()
    public List<Todo> getAllTodos(){
        return todosService.getAllTodos();
    }

    @GetMapping("{id}")
    public Todo getTodoById(@PathVariable int id){
        return todosService.getTodoById(id);
    }

    @PostMapping()
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo){
        Todo newTodo = todosService.saveTodo(todo);
        logger.info("Todo Object"+todo);
        return new ResponseEntity<Todo>(newTodo, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo){
        return todosService.updateTodo(id,todo);
    }
    @DeleteMapping("{id}")
    public boolean deleteTodo(@PathVariable int id){
        return todosService.deleteTodo(id);
    }
}
