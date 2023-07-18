package com.zikan.todomanagementproject.controller;

import com.zikan.todomanagementproject.dto.TodoDto;
import com.zikan.todomanagementproject.entity.Todo;
import com.zikan.todomanagementproject.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("api/todos")
public class TodoController {
    private TodoService todoService;
//    build add todo REST API
    @PostMapping()
   public ResponseEntity <TodoDto> addTodo(@RequestBody TodoDto todoDto){
       TodoDto savedTodo = todoService.addTodo(todoDto);
       return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
   }
//Build Get Todo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable ("id") Long todoId){
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }
//    Build Get All Todos REST API
    @GetMapping()
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List <TodoDto> todos = todoService.getAllTodos();
//        return new ResponseEntity<>(todos, HttpStatus.OK);
        return  ResponseEntity.ok(todos);
    }

//    Build Todo Rest API
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateDto (@RequestBody TodoDto todoDto, @PathVariable ("id") Long todoId){
        TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodo);
    }

//    Build Todo Delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity <String> deleteTodo(@PathVariable ("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo Successfully deleted");
    }

//    complete complete Todo RestApi

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo (@PathVariable ("id") Long todoId){
        TodoDto updatedTodo = todoService.completeTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }
//    Build in-complete Todo REST API
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable ("id") Long todoId){
        TodoDto updatedTodo = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodo);

    }
}
