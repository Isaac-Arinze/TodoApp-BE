package com.zikan.todomanagementproject.service.impl;

import com.zikan.todomanagementproject.dto.TodoDto;
import com.zikan.todomanagementproject.entity.Todo;
import com.zikan.todomanagementproject.exception.ResourceNotFoundException;
import com.zikan.todomanagementproject.repository.TodoRepository;
import com.zikan.todomanagementproject.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
//        convert TodoDto into Todo Jpa Entity

//        Todo todo = new Todo();
//
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());

//        instead of using the above np. of codes, we can simple use model mapper to reduce it

        Todo todo = modelMapper.map(todoDto, Todo.class);
        Todo savedTodo = todoRepository.save(todo);
//        Todo Jpa entity

//        TodoDto savedTodoDto = new TodoDto();
//        savedTodoDto.setId(todoDto.getId());
//        savedTodoDto.setTitle(todoDto.getTitle());
//        savedTodoDto.setDescription(todoDto.getDescription());

        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }
//    This enables us to customize exception for get method
    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Todo Not found with id : " + id));

        return modelMapper.map(todo, TodoDto.class);
    }
    @Override
    public List<TodoDto> getAllTodos() {
        List <Todo> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Todo not found with id : " + id));

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo with Id not found:" + id));
        todoRepository.deleteById(id);

    }
    @Override
    public TodoDto completeTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo not found with Id:" + id));
        todo.setCompleted(Boolean.TRUE);
       Todo updatedTodo =  todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }
    @Override
    public TodoDto inCompleteTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Todo Not Found with Id:" + id));

        todo.setCompleted(Boolean.FALSE);
        todoRepository.save(todo);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}
